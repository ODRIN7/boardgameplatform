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

    @Autowired
    private MessageService messageService;

    public MessageRestController() {
    }

    @PostConstruct
    public void fillData() {
        messageService.fillData();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Message> getMessages() {
       return messageService.getMessagess();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Message saveMessage(@RequestBody Message message) {
       return messageService.saveMessage(message);
    }

    @RequestMapping(value = "/{messageId}", method = RequestMethod.DELETE)
    public Message deleteMessage(@PathVariable("messageId") Long messageId) {
      return messageService.deleteMessage(messageId);
    }

}
