package com.h2.robotmallservice.service;

import com.h2.robotmallservice.common.ResponseResult;
import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.model.request.UserLoginRequest;

public interface UserService {

    ResponseResult registerUser(User user) throws InstantiationException, IllegalAccessException;

    ResponseResult userLogin(UserLoginRequest userLoginRequest) throws InstantiationException, IllegalAccessException;
}
