package com.karios.core.domain.repository;

import java.util.List;
import java.util.Optional;

import com.karios.core.domain.model.User;
import com.karios.core.infrastructure.entity.UserEntity;

public interface UserRepository {
	List<User> getAll();
    Optional<UserEntity> getById(Integer id);
    Optional<List<User>> getAllByUsername(String username);
    User save(UserEntity user);
    void deleteById(Integer id);
}
