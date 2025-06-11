package com.practiceproject.linkchat_back.controller;

import com.practiceproject.linkchat_back.model.ChatInfo;
import com.practiceproject.linkchat_back.repository.ChatMessageRepository;
import com.practiceproject.linkchat_back.repository.ChatRepository;
import com.practiceproject.linkchat_back.repository.ChatUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    private final ChatRepository chatRepository;
    private final ChatUserRepository chatUserRepository;
    private final ChatMessageRepository chatMessageRepository;

    public ChatController(ChatRepository chatRepository,
                          ChatUserRepository chatUserRepository,
                          ChatMessageRepository chatMessageRepository) {
        this.chatRepository = chatRepository;
        this.chatUserRepository = chatUserRepository;
        this.chatMessageRepository = chatMessageRepository;
    }

    @GetMapping("/{chatId}")
    public Map<String, Object> getChatData(@PathVariable("chatId") long chatId) {
        logger.debug("Fetching chat data for {}", chatId);
        ChatInfo info = new ChatInfo(chatId, chatRepository, chatUserRepository, chatMessageRepository);
        return Map.of(
                "title", info.getTitle(),
                "users", info.getUsers(),
                "messages", info.getMessages()
        );
    }
}
