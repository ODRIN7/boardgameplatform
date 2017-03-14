package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.message.Chat;
import hu.odrin7.bga.domain.message.Message;

import java.util.List;

public interface MessageService {

    void fillData();

    List<Chat> getChats();

    Chat createChat(Chat chat);

    List<Message> getMessagesByChat(long chatId);

    void connectToChat(long chatId);

    void discconnectFromChat(long chatId);

    void writeMessage(long chatId, Message message);

}
