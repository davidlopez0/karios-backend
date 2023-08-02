package com.karios.core.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.karios.core.domain.model.UserChat;
import com.karios.core.infrastructure.entity.UserChatEntity;

@Mapper(componentModel = "spring", uses = {ChatMapper.class, UserMapper.class})
public interface UserChatMapper {

	UserChat toUserChat(UserChatEntity userChatEntity);
    List<UserChat> toUsersChats(List<UserChatEntity> userChatEntities);

    UserChatEntity toUserChatEntities(UserChat userChat);
    List<UserChatEntity> toUsersChatsEntities(List<UserChat> userChats);
	
}
