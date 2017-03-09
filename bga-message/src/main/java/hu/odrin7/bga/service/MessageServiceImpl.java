package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
import hu.odrin7.bga.domain.message.Message;
import hu.odrin7.bga.domain.message.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private MessageRepository messageRepository;

    public MessageServiceImpl() {
    }

    @Override
    public void fillData() {
        List<Message> posts = this.getMessagess();
        if (posts.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                Message post = new Message("Sample message post title #" + i, "Sample message post content #" + i);
                messageRepository.save(post);
                log.warn(post.toString());
            }
        }
    }

    @Override
    public List<Message> getMessagess() {
        return Lists.newArrayList(messageRepository.findAll());
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message deleteMessage(Long postId) {
        Message message = messageRepository.findOne(postId);
        if (message != null) {
            messageRepository.delete(message);
        }
        return message;
    }
}
