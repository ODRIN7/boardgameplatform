package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.message.Chat;
import hu.odrin7.bga.domain.message.ChatRepository;
import hu.odrin7.bga.domain.message.Message;
import hu.odrin7.bga.domain.message.ReadParam;
import hu.odrin7.bga.seq.dao.SequenceDao;
import hu.odrin7.bga.service.exceptions.UserNotConnectedToChat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class MessageServiceImpl implements MessageService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ChatRepository chatRepository;
    private final SequenceDao sequenceDao;
    private static final String MESSAGE_SEQ_KEY = "message";
    private static final String CHAT_SEQ_KEY = "chat";

    @Autowired
    public MessageServiceImpl(ChatRepository chatRepository,
                              SequenceDao sequenceDao) {
        this.chatRepository = chatRepository;
        this.sequenceDao = sequenceDao;
    }


    @Override
    public void fillData() {
        List<Chat> chats = this.getChats();
        if (chats.isEmpty()) {
            sequenceDao.saveNewKey(CHAT_SEQ_KEY, 800);
            sequenceDao.saveNewKey(MESSAGE_SEQ_KEY, 700);
            for (long i = 1; i <= 10; i++) {
                Chat chat = Chat.create(
                    sequenceDao.getNextSequenceId(CHAT_SEQ_KEY), "", 100 + i, "username1");
                for (long j = 1; j <= 10; j++) {
                    chat.write(
                        Message.create(
                            sequenceDao.getNextSequenceId(MESSAGE_SEQ_KEY),
                            "content of message" + j,
                            "username1",
                            chat.getConnectedUser()));
                }

                chatRepository.save(chat);
                log.warn(chat.toString());
            }
        }
    }

    @Override
    public List<Chat> getChats() {
        return newArrayList(chatRepository.findAll());
    }

    @Override
    public Chat createChat(Chat chat, String  username) {

        setChatParams(chat, username);
        return chatRepository.save(chat);
    }


    @Override
    public List<Message> getMessagesByChat(long chatId, Principal principal) throws UserNotConnectedToChat {
        Chat chat = chatRepository.findOne(chatId);
        if (chat != null && isConnected(chat.getConnectedUser(), principal)) {
            return chat.getMessages();
        }
        throw new UserNotConnectedToChat("UserNotConnectedToChat");
    }

    private boolean isConnected(List<String> AlreadyConnectedUser, Principal principal) {
        return AlreadyConnectedUser.contains(principal.getName());
    }

    @Override
    public void connectToChat(long chatId, String username) {

        Chat chat = chatRepository.findOne(chatId);
        if (chat != null) {
            chat.connect(username);
            chatRepository.save(chat);
            log.info(">>>>>>>>>>>>>Connected " + username + " to  chat>>>>>>>>>>:" + chat.getId());
        }
    }

    @Override
    public void disconnectFromChat(long chatId, String username) {
        Chat chat = chatRepository.findOne(chatId);
        if (chat != null) {
            chat.disconnect(username);
            chatRepository.save(chat);
            log.info(">>>>>>>>>>>>>Disconnected " + username + " from chat>>>>>>>>>>:" + chat.getId());
        }
    }

    @Override
    public void writeMessage(long chatId, Message message, String username) {
        Chat chat = chatRepository.findOne(chatId);
        if (chat != null) {
            setMessageData(message, username, chat.getConnectedUser());
            chat.write(message);
            chatRepository.save(chat);
            log.info(">>>>>>>>>>>>>Message was sent>>>>>>>>>>:  " + message.toString());
        }
    }

    @Override
    public void read(long chatId, String username) {
        Chat chat = chatRepository.findOne(chatId);
        if (chat != null) {

            log.info(">>>>>>>>>>>>>Messages read>>>>>>>>>>:  ");
        }
    }

    private void setMessageData(Message message, String username, List<String> connectedUser) {
        message.setMessageId(sequenceDao.getNextSequenceId(MESSAGE_SEQ_KEY));
        message.setAuthorId(username);
        message.setTimestamp(LocalDateTime.now());
        setReadParam(message, connectedUser, username);
    }

    private void setReadParam(Message message, List<String> connectedUser, String authorId) {
        List<ReadParam> allUnreadParam = new ArrayList<>();
        for (String username : connectedUser) {
            if (Objects.equals(username, authorId)) {
                allUnreadParam.add(new ReadParam(username, true));
            }
            allUnreadParam.add(new ReadParam(username, false));
        }
        message.setReadParams(allUnreadParam);
    }


    private void setChatParams(Chat chat, String username) {
        chat.setConnectedUser(new ArrayList<>());
        chat.setMessages(new ArrayList<>());
        chat.setConnectedUser(new ArrayList<>());
        chat.connect(username);
    }
}
