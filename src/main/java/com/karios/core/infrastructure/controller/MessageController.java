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

import com.karios.core.application.service.MessageService;
import com.karios.core.domain.model.Message;
import com.karios.core.infrastructure.entity.MessageEntity;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @PostMapping("/create")
    public Message createMessage(@RequestBody MessageEntity messageEntity){
        return messageService.save(messageEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMessage(@PathVariable Integer id){
        messageService.deleteById(id);
    }
}

