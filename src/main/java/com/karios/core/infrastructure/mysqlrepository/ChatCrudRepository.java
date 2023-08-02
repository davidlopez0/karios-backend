package com.karios.core.infrastructure.mysqlrepository;

import org.springframework.data.repository.CrudRepository;

import com.karios.core.infrastructure.entity.ChatEntity;

public interface ChatCrudRepository extends CrudRepository<ChatEntity, Integer> {
}
