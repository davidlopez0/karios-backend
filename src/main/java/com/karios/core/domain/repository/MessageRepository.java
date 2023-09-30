package com.karios.core.domain.repository;

import java.util.List;

import com.karios.core.domain.model.Message;
import com.karios.core.infrastructure.entity.MessageEntity;

public interface MessageRepository {
	List<Message> getAll();
	List<Message> getAllByChatId(Integer id);
    Message save(MessageEntity messageEntity);
    void deleteById(Integer id);
}
