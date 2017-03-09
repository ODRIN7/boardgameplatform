package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.message.Message;

import java.util.List;

public interface MessageService {

    void fillData();
    List<Message> getMessagess();
    Message saveMessage(Message message);
    Message deleteMessage(Long postId);

}
