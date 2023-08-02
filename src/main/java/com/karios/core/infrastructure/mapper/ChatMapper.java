package com.karios.core.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.karios.core.domain.model.Chat;
import com.karios.core.infrastructure.entity.ChatEntity;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    Chat toChat(ChatEntity chatEntity);
    List<Chat> toChats(List<ChatEntity> chatEntities);

    ChatEntity toChatEntity(Chat chat);
    List<ChatEntity> toChatEntities(List<Chat> chats);
}
