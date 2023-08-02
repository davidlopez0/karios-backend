package com.karios.core.infrastructure.mysqlrepository;

import org.springframework.data.repository.CrudRepository;

import com.karios.core.infrastructure.entity.MessageEntity;

public interface MessageCrudRepository extends CrudRepository<MessageEntity, Integer> {
}