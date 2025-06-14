package com.practiceproject.linkchat_back.model;

import com.practiceproject.linkchat_back.repository.ChatMessageRepository;
import com.practiceproject.linkchat_back.repository.ChatRepository;
import com.practiceproject.linkchat_back.repository.ChatUserRepository;

import com.practiceproject.linkchat_back.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatInfo {
    private String title;
    private List<User> users;
    private List<ChatMessage> messages;

    /**
     * Creates a new chat with default title {@code "New Chat"}.
     */
    public ChatInfo() {
        this("New Chat");
    }

    public ChatInfo(String title) {
        this.title = title;
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public ChatInfo(String link,
                    ChatRepository chatRepository,
                    ChatUserRepository chatUserRepository,
                    ChatMessageRepository messageRepository) {
        Chat chat = chatRepository.findByLink(link).orElse(null);
        if (chat != null) {
            long chatId = chat.getChatId();
            this.title = chat.getTitle();
            this.users = chatUserRepository.getChatUsers(chatId);
            this.messages = messageRepository.getMessagesByChatId(chatId);
        } else {
            this.title = null;
            this.users = new ArrayList<>();
            this.messages = new ArrayList<>();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}
