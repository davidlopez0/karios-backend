package com.karios.core.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karios.core.domain.model.UserChat;
import com.karios.core.domain.repository.UserChatRepository;
import com.karios.core.infrastructure.entity.UserChatEntity;

@Service
public class UserChatService {

    @Autowired
    private UserChatRepository userChatRepository;

    public List<UserChat> getAll(){
        List<UserChat> userChats = userChatRepository.getAll();
        if(userChats.size() > 0){
            return userChats;
        }

        return null;
    }

    public List<UserChat> getAllByUserId(Integer id){
        List<UserChat> userChats = userChatRepository.getAllByUserId(id);
        if(userChats.size() > 0){
            return userChats;
        }
        return null;
    }

    public List<UserChat> getAllByChatId(Integer id){
        List<UserChat> userChats = userChatRepository.getAllByChatId(id);
        if(userChats.size() > 0){
            return userChats;
        }
        return null;
    }

    public UserChat getById(Integer id){
        Optional<UserChat> userChat = userChatRepository.getById(id);
        if(userChat.isPresent()){
            return userChat.get();
        }

        return null;
    }

    public UserChat save(UserChatEntity userChatEntity){
        UserChat userChat = userChatRepository.save(userChatEntity);
        return userChat;
    }

    public void deleteById(Integer id){
        userChatRepository.deleteById(id);
    }

}
