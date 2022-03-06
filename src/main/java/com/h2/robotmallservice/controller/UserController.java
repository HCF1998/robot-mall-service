package com.h2.robotmallservice.controller;

import com.h2.robotmallservice.common.BaseResponse.Result;
import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.enums.ResultCode;
import com.h2.robotmallservice.model.RegisteredUser;
import com.h2.robotmallservice.model.response.PublicUserResponse;
import com.h2.robotmallservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class UserController {

    private static final String VERSION = "1.0";

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/registerUser")
    public PublicUserResponse registerUser(@RequestBody User user) {

        userService.registerUser(user);
        RegisteredUser registeredUser = new RegisteredUser();
        registeredUser.setUserName(user.getUserName());

        PublicUserResponse response = new PublicUserResponse();
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS.getResultCode());
        result.setResultMessage(ResultCode.SUCCESS.getMessage());
        result.setVersion(VERSION);

        response.setResult(result);
        response.setData(registeredUser);
        return response;

    }

}
