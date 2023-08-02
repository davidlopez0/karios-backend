package com.karios.core.infrastructure.mysqlrepository;

import org.springframework.data.repository.CrudRepository;

import com.karios.core.infrastructure.entity.UserChatEntity;

public interface UserChatCrudRepository extends CrudRepository<UserChatEntity, Integer> {

    Iterable<UserChatEntity> findAllByUserId(Integer userId);
    Iterable<UserChatEntity> findAllByChatId(Integer id);

}