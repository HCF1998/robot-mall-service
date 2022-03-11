package com.h2.robotmallservice.service;

import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.model.request.UserLoginRequest;
import com.h2.robotmallservice.model.response.RegisterUserResponse;

public interface UserService {

    RegisterUserResponse registerUser(User user) throws InstantiationException, IllegalAccessException;

    RegisterUserResponse userLogin(UserLoginRequest userLoginRequest) throws InstantiationException, IllegalAccessException;
}
