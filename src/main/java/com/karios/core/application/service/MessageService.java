package com.karios.core.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karios.core.domain.model.Message;
import com.karios.core.domain.repository.MessageRepository;
import com.karios.core.infrastructure.entity.MessageEntity;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Message save(MessageEntity messageEntity){
        return messageRepository.save(messageEntity);
    }

    public void deleteById(Integer id){
        messageRepository.deleteById(id);
    }

}
