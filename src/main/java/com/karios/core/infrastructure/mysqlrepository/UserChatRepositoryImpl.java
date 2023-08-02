package com.karios.core.infrastructure.mysqlrepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karios.core.domain.model.UserChat;
import com.karios.core.domain.repository.UserChatRepository;
import com.karios.core.infrastructure.entity.UserChatEntity;
import com.karios.core.infrastructure.mapper.UserChatMapper;

@Repository
public class UserChatRepositoryImpl implements UserChatRepository {

    @Autowired
    private UserChatCrudRepository userChatCrudRepository;
    @Autowired
    private UserChatMapper mapper;

    @Override
    public List<UserChat> getAll() {
        return mapper.toUsersChats((List<UserChatEntity>) userChatCrudRepository.findAll());
    }

    @Override
    public List<UserChat> getAllByUserId(Integer id) {
        return mapper.toUsersChats((List<UserChatEntity>)
                userChatCrudRepository.findAllByUserId(id));
    }

    @Override
    public List<UserChat> getAllByChatId(Integer id) {
        return mapper.toUsersChats((List<UserChatEntity>)
                userChatCrudRepository.findAllByChatId(id));
    }

    @Override
    public Optional<UserChat> getById(Integer id) {
        return userChatCrudRepository.findById(id).map(userChatEntity ->
                mapper.toUserChat(userChatEntity));
    }

    @Override
    public UserChat save(UserChatEntity userChatEntity) {
        return mapper.toUserChat(userChatCrudRepository.save(userChatEntity));
    }

    @Override
    public void deleteById(Integer id) {
        userChatCrudRepository.deleteById(id);
    }
}
