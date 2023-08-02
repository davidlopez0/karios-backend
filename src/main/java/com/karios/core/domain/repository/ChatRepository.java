package com.karios.core.domain.repository;

import java.util.List;
import java.util.Optional;

import com.karios.core.domain.model.Chat;
import com.karios.core.infrastructure.entity.ChatEntity;

public interface ChatRepository {
	Chat save(ChatEntity chatEntity);
    List<Chat> getAll();
    Optional<Chat> getById(Integer id);
    void deleteById(Integer id);
}
