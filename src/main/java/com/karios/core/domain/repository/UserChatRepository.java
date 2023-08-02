package com.karios.core.domain.repository;

import java.util.List;
import java.util.Optional;

import com.karios.core.domain.model.UserChat;
import com.karios.core.infrastructure.entity.UserChatEntity;

public interface UserChatRepository {
	List<UserChat> getAll();
    List<UserChat> getAllByUserId(Integer id);
    List<UserChat> getAllByChatId(Integer id);
    Optional<UserChat> getById(Integer id);
    UserChat save(UserChatEntity userChatEntity);
    void deleteById(Integer id);
}
