package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.message.Chat;
import hu.odrin7.bga.domain.message.Message;
import hu.odrin7.bga.service.exceptions.UserNotConnectedToChat;

import java.security.Principal;
import java.util.List;

public interface MessageService {

    void fillData();

    List<Chat> getChats();

    Chat createChat(Chat chat, String username);

    List<Message> getMessagesByChat(long chatId, Principal principal) throws UserNotConnectedToChat;

    void connectToChat(long chatId, String username);

    void disconnectFromChat(long chatId, String usernmae);

    void writeMessage(long chatId, Message message, String username);

    void read(long chatId, String username);
}
