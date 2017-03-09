package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.message.Chat;
import hu.odrin7.bga.domain.message.Message;

import java.util.List;

public interface MessageService {

    void fillData();

    Chat createChat(Chat chat);

    boolean connectToChat(long chatId);

    void discconnectFromChat(long chatId);

    List<Message> getMessages(long chatId);

    Message getMessagesByUser(long userId);

    Message writeMessage(Message message);

    Message deleteMessage(Long messageId);
}
