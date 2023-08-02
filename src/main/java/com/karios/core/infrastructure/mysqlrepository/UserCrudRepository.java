package com.karios.core.infrastructure.mysqlrepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.karios.core.infrastructure.entity.UserEntity;

public interface UserCrudRepository extends CrudRepository<UserEntity, Integer> {

    Optional<List<UserEntity>> findAllByUsernameIsContainingIgnoreCase(String username);
    Optional<UserEntity> findByUsername(String username);

}
