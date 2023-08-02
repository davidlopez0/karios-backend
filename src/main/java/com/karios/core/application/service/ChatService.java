package com.karios.core.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karios.core.domain.model.Chat;
import com.karios.core.domain.repository.ChatRepository;
import com.karios.core.infrastructure.entity.ChatEntity;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public List<Chat> getAll(){
        List<Chat> chats = chatRepository.getAll();
        if(chats.size() > 0){
            return chats;
        }

        return null;
    }

    public Chat getById(Integer id){
        Optional<Chat> chat = chatRepository.getById(id);
        if(chat.isPresent()){
            return chat.get();
        }

        return null;
    }

    public Chat createChat(ChatEntity chatEntity){
        return chatRepository.save(chatEntity);
    }

    public void deleteById(Integer id){
        chatRepository.deleteById(id);
    }

}