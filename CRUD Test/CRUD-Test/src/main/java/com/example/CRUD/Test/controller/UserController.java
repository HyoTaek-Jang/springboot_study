package com.example.CRUD.Test.controller;

import com.example.CRUD.Test.domain.User;
import com.example.CRUD.Test.repository.UserRepository;
import com.example.CRUD.Test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/*")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @PostMapping(value = "/setUser")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User setUser(@RequestBody User user) throws Exception {
        System.out.println(user.toString());
        User save = userRepository.save(user);
        return save;
    }

    @GetMapping("/get")
    public List<User> hello() {
        List<User> result = userRepository.findAll();
        return result;
    }

    @GetMapping("/getById/{id}")
    public Optional<User> getById(@PathVariable Long id){
        Optional<User> byId = userRepository.findById(id);
        return byId;
    }

    @GetMapping("/getById")
    public Optional<User> getById2(@RequestParam Long id){
        Optional<User> byId = userRepository.findById(id);
        return byId;
    }
}
