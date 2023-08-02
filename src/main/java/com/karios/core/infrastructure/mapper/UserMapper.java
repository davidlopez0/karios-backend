package com.karios.core.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.karios.core.domain.model.User;
import com.karios.core.infrastructure.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDomainUser(UserEntity user);
    List<User> toDomainUsers(List<UserEntity> users);

    @Mappings({
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "google", ignore = true)
    })
    UserEntity toDBOUser(User domainUser);
    List<UserEntity> toDBOUsers(List<User> domainUsers);

}