package hu.odrin7.bga.service;

import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.domain.message.Chat;
import hu.odrin7.bga.domain.message.ChatRepository;
import hu.odrin7.bga.domain.message.Message;
import hu.odrin7.bga.seq.dao.SequenceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class MessageServiceImpl implements MessageService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ChatRepository chatRepository;
    private final AuthServiceClient authServiceClient;
    private final SequenceDao sequenceDao;
    private static final String MESSAGE_SEQ_KEY = "message";
    private static final String CHAT_SEQ_KEY = "chat";

    @Autowired
    public MessageServiceImpl(ChatRepository chatRepository,
                              AuthServiceClient authServiceClient,
                              SequenceDao sequenceDao) {
        this.chatRepository = chatRepository;
        this.authServiceClient = authServiceClient;
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
                            "MessageTitle:" + j, "content of message" + j,
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
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Message> getMessagesByChat(long chatId) {
        return chatRepository.findOne(chatId).getMessages();
    }

    @Override
    public void connectToChat(long chatId) {

        Chat chat = chatRepository.findOne(chatId);
        if (chat != null) {
            chat.connect("username1");;
            chatRepository.save(chat);
        }
    }

    @Override
    public void discconnectFromChat(long chatId) {
        Chat chat = chatRepository.findOne(chatId);
        if (chat != null) {
            chat.disconnect("username1");
            chatRepository.save(chat);
        }
    }

    @Override
    public void writeMessage(long chatId, Message message) {

        Chat chat = chatRepository.findOne(chatId);
        if (chat != null) {
            chat.write(message);
            chatRepository.save(chat);
        }
    }
}
