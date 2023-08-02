package com.karios.core.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karios.core.application.service.UserService;
import com.karios.core.domain.model.User;
import com.karios.core.infrastructure.entity.UserEntity;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAll();
        if(users != null){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable Integer id){
        UserEntity user = userService.getById(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<User>> getByUsername(@PathVariable String username){
        List<User> users = userService.getAllByUsername(username);
        if(users != null){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody UserEntity user){
        User userSaved = userService.createUser(user);
        if(userSaved instanceof User){
            return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody UserEntity user){
        User userUpdated = userService.updateUser(id, user);
        if(userUpdated instanceof User){
            return new ResponseEntity<>(userUpdated, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}