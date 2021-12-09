package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {
    public static ChatMessageRepository repo = new ChatMessageRepository();
    public void onMessage(String message){
        repo.addChatMessage(message);
    }
}
