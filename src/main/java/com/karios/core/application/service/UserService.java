package com.karios.core.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.karios.core.domain.model.User;
import com.karios.core.domain.repository.UserRepository;
import com.karios.core.infrastructure.entity.UserEntity;
import com.karios.core.infrastructure.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper mapper;

    public List<User> getAll(){
        List<User> users = userRepository.getAll();
        if(users.size() > 0){
            return users;
        }

        return null;
    }

    public UserEntity getById(Integer id){
        Optional<UserEntity> user = userRepository.getById(id);
        if(user.isPresent()){
            return user.get();
        }

        return null;
    }
    
    public List<User> getAllByUsername(String username){
        Optional<List<User>> users = userRepository.getAllByUsername(username);
        if(users.isPresent()){
            List<User> usersEncontrados = users.get();
            if(usersEncontrados.size() > 0){
                return usersEncontrados;
            }
        }

        return null;
    }

    public User createUser(UserEntity user){
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Integer id, UserEntity user){
        Optional<UserEntity> userBuscado = userRepository.getById(id);
        if(userBuscado.isPresent()){
            UserEntity userEncontrado = userBuscado.get();
            if(user.getImageUrl() != null){
                userEncontrado.setImageUrl(user.getImageUrl());
            }
            if(user.getUsername() != null){
                userEncontrado.setUsername(user.getUsername());
            }

            return userRepository.save(userEncontrado);
        }

        return null;
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

}