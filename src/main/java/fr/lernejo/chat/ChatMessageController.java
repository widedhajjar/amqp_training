package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatMessageController {
    ChatMessageListener listener;
    public ChatMessageController(ChatMessageListener listener) {
        this.listener = listener;
    }


    @GetMapping(value ="/api/message")
    public List<String> getmessage(){
        return listener.repo.getLastTenMessages();
    }
}
