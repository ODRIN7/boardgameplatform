package hu.odrin7.bga.client;

import hu.odrin7.bga.domain.message.Chat;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@FeignClient(name = "chat-service")
public interface ChatServiceClient {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Chat createChat(@RequestBody Chat chat, Principal principal);
}


