package com.h2.robotmallservice.controller;

import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.model.response.RegisterUserResponse;
import com.h2.robotmallservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/registerUser")
    public RegisterUserResponse registerUser(@RequestBody User user) throws InstantiationException, IllegalAccessException {

        //todo 表层校验
        RegisterUserResponse response = userService.registerUser(user);
        return response;
    }

}
