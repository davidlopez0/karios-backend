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

import com.karios.core.application.service.ChatService;
import com.karios.core.domain.model.Chat;
import com.karios.core.infrastructure.entity.ChatEntity;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/")
    public List<Chat> getAll(){
        return chatService.getAll();
    }

    @GetMapping("/id/{id}")
    public Chat getById(@PathVariable Integer id){
        return chatService.getById(id);
    }

    @PostMapping("/create")
    public void createChat(@RequestBody ChatEntity chatEntity){
        chatService.createChat(chatEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        chatService.deleteById(id);
    }
}