package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.message.Chat;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Chat> getChats() {
        return messageService.getChats();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Chat createChat(@RequestBody Chat chat) {
        return messageService.createChat(chat);
    }

    @RequestMapping(value = "/{chatId}", method = RequestMethod.GET)
    public List<Message> getMessagesByChat(@PathVariable("chatId") Long chatId) {
        return messageService.getMessagesByChat(chatId);
    }

    @RequestMapping(value = "/connect/{chatId}", method = RequestMethod.POST)
    public boolean connectToChat(@PathVariable("chatId") long chatId) {
        messageService.connectToChat(chatId);
        return true;
    }

    @RequestMapping(value = "/disconnect/{chatId}", method = RequestMethod.POST)
    public boolean discconectFromChat(@PathVariable("chatId") long chatId) {
        messageService.discconnectFromChat(chatId);
        return true;
    }

    @RequestMapping(value = "/write/{chatId}/", method = RequestMethod.POST)
    public boolean writeMessage(@PathVariable("chatId") long chatId,
                                @RequestBody Message message) {
        messageService.writeMessage(chatId, message);
        return true;
    }
}
