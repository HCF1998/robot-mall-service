package com.h2.robotmallservice.controller;

import com.h2.robotmallservice.common.ResponseResult;
import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.enums.ErrorEnums;
import com.h2.robotmallservice.model.request.UserLoginRequest;
import com.h2.robotmallservice.service.UserService;
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
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseResult registerUser(@RequestBody User user) throws InstantiationException, IllegalAccessException {

        //todo 表层校验
        ResponseResult result = userService.registerUser(user);
        return result;
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody UserLoginRequest loginRequestBody) throws InstantiationException, IllegalAccessException {

        ResponseResult responseResult = userService.userLogin(loginRequestBody);
        return responseResult;

    }
}
