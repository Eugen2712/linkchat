package com.practiceproject.linkchat_back.model;

import java.util.ArrayList;
import java.util.List;
import com.practiceproject.linkchat_back.model.Message;

public class ChatInfo {
    private String title;
    private List<User> users;
    private List<Message> messages;

    //new chat
    // existing chat

    public ChatInfo(String title) {
        //Create new chat using the title
        this.title = title;
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
    }
    public String ChatInfo( long chatId) {
        this.messages = MeessageRepository.getMessagesByChatId(chatId);

    }
}
