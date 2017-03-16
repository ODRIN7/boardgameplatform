package hu.odrin7.bga.Controller;

import hu.odrin7.bga.domain.message.Chat;
import hu.odrin7.bga.domain.message.Message;
import hu.odrin7.bga.service.MessageService;
import hu.odrin7.bga.service.exceptions.UserNotConnectedToChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.security.Principal;
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
    public Chat createChat(@RequestBody Chat chat, Principal principal) {
        return messageService.createChat(chat, principal.getName());
    }

    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public Chat createChatByGameCreated(@RequestBody Chat chat) {
        return messageService.createChat(chat, chat.getConnectedUser().get(0));
    }

    @RequestMapping(value = "/{chatId}", method = RequestMethod.GET)
    public List<Message> getMessagesByChat(@PathVariable("chatId") Long chatId, Principal principal) throws UserNotConnectedToChat {
        return messageService.getMessagesByChat(chatId, principal);
    }

    @RequestMapping(value = "/connect/{chatId}", method = RequestMethod.POST)
    public void connectToChat(@PathVariable("chatId") long chatId, Principal principal) {
        messageService.connectToChat(chatId, principal);
    }

    @RequestMapping(value = "/disconnect/{chatId}", method = RequestMethod.POST)
    public void discconectFromChat(@PathVariable("chatId") long chatId, Principal principal) {
        messageService.disconnectFromChat(chatId, principal);
    }

    @RequestMapping(value = "/write/{chatId}/", method = RequestMethod.POST)
    public void writeMessage(@PathVariable("chatId") long chatId,
                                @RequestBody Message message,
                                Principal principal) {
        messageService.writeMessage(chatId, message, principal);
    }
}
