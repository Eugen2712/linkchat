package com.practiceproject.linkchat_back.repository;

import com.practiceproject.linkchat_back.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
