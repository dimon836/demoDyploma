package com.example.demodyploma.controller;

import com.example.demodyploma.exception.UserNotFoundException;
import com.example.demodyploma.repository.UserEntityRepository;
import com.example.demodyploma.service.UserService;
import com.example.demodyploma.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserEntityRepository userEntityRepo;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    List<UserEntity> getAllUsers() {
        return userEntityRepo.findAll();
    }

    @GetMapping("/users/{login}")
    UserEntity one(@PathVariable String login) throws UserNotFoundException {
        return userService.findByLogin(login);
    }

    @PutMapping("/users/{id}")
    UserEntity replaceUser(@RequestBody UserEntity newUser, @PathVariable Long id) {
        return userEntityRepo.findById(id)
                .map(userDto1 -> {
                    userDto1.setLogin(newUser.getLogin());
                    userDto1.setEmail(newUser.getEmail());
                    userDto1.setPassword(newUser.getPassword());
                    return userEntityRepo.save(userDto1);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userEntityRepo.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userEntityRepo.deleteById(id);
    }

}
