package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.message.Message;
import hu.odrin7.bga.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController
@RequestMapping("/messages")
public class MessageRestController {

    private final MessageService messageService;

    @Autowired
    public MessageRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostConstruct
    public void fillData() {
        messageService.fillData();
    }

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    public List<Message> getMessages() {
        return messageService.getMessages(1);
    }

    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    public List<Message> getMessagesByUser() {
        return messageService.getMessages(1);
    }

    @RequestMapping(value = "/aa", method = RequestMethod.POST)
    public Message writeMessageByUser(@RequestBody Message message) {
        return messageService.writeMessage(message);
    }

    @RequestMapping(value = "/aaa", method = RequestMethod.POST)
    public Message createChat(@RequestBody Message message) {
        return messageService.writeMessage(message);
    }

    @RequestMapping(value = "/aaaa", method = RequestMethod.POST)
    public Message connectToChat(@RequestBody Message message) {
        return messageService.writeMessage(message);
    }

    @RequestMapping(value = "/aaaaa", method = RequestMethod.POST)
    public Message discconectFromChat(@RequestBody Message message) {
        return messageService.writeMessage(message);
    }

    @RequestMapping(value = "/{messageId}", method = RequestMethod.DELETE)
    public Message deleteMessage(@PathVariable("messageId") Long messageId) {
        return messageService.deleteMessage(messageId);
    }

}
