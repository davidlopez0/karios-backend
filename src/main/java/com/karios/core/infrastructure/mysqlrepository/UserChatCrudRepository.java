package com.karios.core.infrastructure.mysqlrepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.karios.core.infrastructure.entity.UserChatEntity;

public interface UserChatCrudRepository extends CrudRepository<UserChatEntity, Integer> {

    Iterable<UserChatEntity> findAllByUserId(Integer userId);
    Iterable<UserChatEntity> findAllByChatId(Integer id);
    
    @Query("SELECT uc FROM UserChatEntity uc WHERE uc.userId != :myUserId AND uc.chatId IN (SELECT chatId FROM UserChatEntity WHERE userId = :myUserId)")
    Iterable<UserChatEntity> findAllChatsByUserId(@Param("myUserId") Integer userId);

}