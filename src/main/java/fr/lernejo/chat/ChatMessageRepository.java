package fr.lernejo.chat;
import java.util.ArrayList;
import java.util.List;
public class ChatMessageRepository {
    List<String> list;
    public ChatMessageRepository() {
        list = new ArrayList<>();
    }

    void addChatMessage(String message){
        if(list.size()<10){
            list.add(message);
        }
        else {
            list.add(message);
            list = list.subList(list.size()-10,list.size());
        }
    }
    List<String> getLastTenMessages(){
        return list;
    }
}
