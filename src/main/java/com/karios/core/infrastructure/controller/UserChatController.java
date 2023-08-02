package com.karios.core.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karios.core.application.service.UserChatService;
import com.karios.core.domain.model.UserChat;
import com.karios.core.infrastructure.entity.UserChatEntity;

@RestController
@RequestMapping("/api/users-chats")
public class UserChatController {

    @Autowired
    private UserChatService userChatService;

    @GetMapping("/")
    public List<UserChat> getAll(){
        return userChatService.getAll();
    }

    @GetMapping("/user-id/{id}")
    public List<UserChat> getAllByUserId(@PathVariable Integer id){
        return userChatService.getAllByUserId(id);
    }

    @GetMapping("/chat-id/{id}")
    public List<UserChat> getAllByChatId(@PathVariable Integer id){
        return userChatService.getAllByChatId(id);
    }

    @GetMapping("/id/{id}")
    public UserChat getById(@PathVariable Integer id){
        return userChatService.getById(id);
    }

    @PostMapping("/create")
    public UserChat save(@RequestBody UserChatEntity userChatEntity){
        return userChatService.save(userChatEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        userChatService.deleteById(id);
    }
}