package com.karios.core.infrastructure.mysqlrepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karios.core.domain.model.Message;
import com.karios.core.domain.repository.MessageRepository;
import com.karios.core.infrastructure.entity.MessageEntity;
import com.karios.core.infrastructure.mapper.MessageMapper;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;
    @Autowired
    private MessageMapper mapper;

    @Override
    public List<Message> getAll() {
        return mapper.toMessages((List<MessageEntity>) messageCrudRepository.findAll());
    }

    @Override
    public Message save(MessageEntity messageEntity) {
        return mapper.toMessage(messageCrudRepository.save(messageEntity));
    }

    @Override
    public void deleteById(Integer id) {
        messageCrudRepository.deleteById(id);
    }
}