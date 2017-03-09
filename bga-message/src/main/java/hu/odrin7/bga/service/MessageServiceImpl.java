package hu.odrin7.bga.service;

import hu.odrin7.bga.client.AuthServiceClient;
import hu.odrin7.bga.client.BoardGameServiceClient;
import hu.odrin7.bga.domain.message.Chat;
import hu.odrin7.bga.domain.message.ChatRepository;
import hu.odrin7.bga.domain.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final Logger log = LoggerFactory.getLogger(getClass());


    private final BoardGameServiceClient boardGameServiceClient;
    private final ChatRepository chatRepository;
    private final AuthServiceClient authServiceClient;

    @Autowired
    public MessageServiceImpl(BoardGameServiceClient boardGameServiceClient,
                              ChatRepository chatRepository,
                              AuthServiceClient authServiceClient) {
        this.boardGameServiceClient = boardGameServiceClient;
        this.chatRepository = chatRepository;
        this.authServiceClient = authServiceClient;
    }


    @Override
    public void fillData() {

    }

    @Override
    public Chat createChat(Chat chat) {
        return null;
    }

    @Override
    public boolean connectToChat(long chatId) {
        return false;
    }

    @Override
    public void discconnectFromChat(long chatId) {

    }

    @Override
    public List<Message> getMessages(long chatId) {
        return null;
    }

    @Override
    public Message getMessagesByUser(long userId) {
        return null;
    }

    @Override
    public Message writeMessage(Message message) {
        return null;
    }

    @Override
    public Message deleteMessage(Long messageId) {
        return null;
    }
}
