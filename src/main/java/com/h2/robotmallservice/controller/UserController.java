package com.h2.robotmallservice.controller;

import com.h2.robotmallservice.common.BaseResponse.Result;
import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.enums.ResultCode;
import com.h2.robotmallservice.model.RegisteredUser;
import com.h2.robotmallservice.model.response.PublicUserResponse;
import com.h2.robotmallservice.service.impl.UserServiceImpl;
import com.h2.robotmallservice.utils.ResponseBuilderUtil;
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
    public PublicUserResponse registerUser(@RequestBody User user) throws InstantiationException, IllegalAccessException {

        userService.registerUser(user);
        RegisteredUser registeredUser = new RegisteredUser();
        registeredUser.setUserName(user.getUserName());

        //PublicUserResponse response = ResponseBuilderUtil.returnSuccessResponse(PublicUserResponse.class);
        PublicUserResponse response = ResponseBuilderUtil.returnFailtureResponse(PublicUserResponse.class);
        //response.setData(registeredUser);
        return response;

    }

}
