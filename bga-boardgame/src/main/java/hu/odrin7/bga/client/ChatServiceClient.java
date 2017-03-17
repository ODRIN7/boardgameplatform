package hu.odrin7.bga.client;

import hu.odrin7.bga.domain.message.Chat;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@FeignClient(name = "message-service")
public interface ChatServiceClient {

    @RequestMapping(value = "/messages/chat", method = RequestMethod.POST)
    Chat createChatByGameCreated(@RequestBody Chat chat);

    @RequestMapping(value = "/disconnect/{username}/{chatId}", method = RequestMethod.POST)
    ResponseEntity discconectFromChat(@PathVariable("chatId") long chatId,
                                             @PathVariable("username")  String username);

    @RequestMapping(value = "/connect/{username}/{chatId}", method = RequestMethod.POST)
    ResponseEntity connectToChat(@PathVariable("chatId") long chatId,
                                        @PathVariable("username")  String username);

}


