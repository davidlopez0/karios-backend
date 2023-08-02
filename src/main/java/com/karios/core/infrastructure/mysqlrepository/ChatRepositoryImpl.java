package com.karios.core.infrastructure.mysqlrepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karios.core.domain.model.Chat;
import com.karios.core.domain.repository.ChatRepository;
import com.karios.core.infrastructure.entity.ChatEntity;
import com.karios.core.infrastructure.mapper.ChatMapper;

@Repository
public class ChatRepositoryImpl implements ChatRepository {

    @Autowired
    private ChatCrudRepository chatCrudRepository;
    @Autowired
    private ChatMapper mapper;

    @Override    
    public List<Chat> getAll(){
        return mapper.toChats((List<ChatEntity>) chatCrudRepository.findAll());
    }

    @Override
    public Optional<Chat> getById(Integer id){
        return chatCrudRepository.findById(id).map(chatEntity -> mapper.toChat(chatEntity));
    }

    @Override
    public Chat save(ChatEntity chatEntity) {
        return mapper.toChat(chatCrudRepository.save(chatEntity));
    }

    @Override
    public void deleteById(Integer id) {
        chatCrudRepository.deleteById(id);
    }
}