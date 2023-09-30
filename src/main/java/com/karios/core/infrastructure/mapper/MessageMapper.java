package com.karios.core.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.karios.core.domain.dto.MessageDTO;
import com.karios.core.domain.model.Message;
import com.karios.core.infrastructure.entity.MessageEntity;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ChatMapper.class})
public interface MessageMapper {

    Message toMessage(MessageEntity messageEntity);
    List<Message> toMessages(List<MessageEntity> messageEntities);
    
    MessageEntity toMessageEntity(Message message);
    List<MessageEntity> toMessageEntities(List<Message> messages);

}
