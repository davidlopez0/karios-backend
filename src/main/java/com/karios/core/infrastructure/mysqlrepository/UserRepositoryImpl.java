package com.karios.core.infrastructure.mysqlrepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karios.core.domain.model.User;
import com.karios.core.domain.repository.UserRepository;
import com.karios.core.infrastructure.entity.UserEntity;
import com.karios.core.infrastructure.mapper.UserMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll() {
        return mapper.toDomainUsers((List<UserEntity>) userCrudRepository.findAll());
    }

    @Override
    public Optional<UserEntity> getById(Integer id) {
        return userCrudRepository.findById(id);
    }

    @Override
    public Optional<List<User>> getAllByUsername(String username) {
        return userCrudRepository.findAllByUsernameIsContainingIgnoreCase(username).map(users ->
                mapper.toDomainUsers(users));
    }

    @Override
    public User save(UserEntity user) {
        return mapper.toDomainUser(userCrudRepository.save(user));
    }

    @Override
    public void deleteById(Integer id) {
        userCrudRepository.deleteById(id);
    }
}
