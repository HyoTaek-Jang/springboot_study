package com.example.CRUD.Test.controller;

import com.example.CRUD.Test.domain.User;
import com.example.CRUD.Test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/setUser")
    public String setUser(User user) throws Exception{
        System.out.println(user.toString());
        return "set";
    }

    @GetMapping("/get")
    public String hello(){
        return "hello";
    }
}
