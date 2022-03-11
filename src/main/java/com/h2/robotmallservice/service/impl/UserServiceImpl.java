package com.h2.robotmallservice.service.impl;

import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.model.RegisteredUser;
import com.h2.robotmallservice.model.request.UserLoginRequest;
import com.h2.robotmallservice.model.response.RegisterUserResponse;
import com.h2.robotmallservice.repository.UserRepository;
import com.h2.robotmallservice.service.UserService;
import com.h2.robotmallservice.utils.JWTUtils;
import com.h2.robotmallservice.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired

    @Override
    public RegisterUserResponse registerUser(User user) throws InstantiationException, IllegalAccessException {

        RegisterUserResponse registerUserResponse;

        Optional<User> optionalUser = userRepository.findByUserName(user.getUserName());

        if (optionalUser.isPresent()) {
            registerUserResponse = ResponseBuilderUtil.returnFailtureResponse(RegisterUserResponse.class);

        } else {
            String password = encoder.encode(user.getPassword());
            user.setPassword(password);
            userRepository.save(user);
            registerUserResponse = ResponseBuilderUtil.returnSuccessResponse(RegisterUserResponse.class);
            RegisteredUser registeredUser = new RegisteredUser();
            registeredUser.setUserName(user.getUserName());
            registerUserResponse.setData(registeredUser);
        }
        return registerUserResponse;
    }

    @Override
    public RegisterUserResponse userLogin(UserLoginRequest userLoginRequest) throws InstantiationException, IllegalAccessException {

        RegisterUserResponse registerUserResponse;
        String requestPassword = encoder.encode(userLoginRequest.getPassword());
        String dbPassword = userRepository.findPasswordByUserName(userLoginRequest.getUserName());

        if (requestPassword.equals(dbPassword)){
            String token = JWTUtils.generateToken("Test");
            registerUserResponse = ResponseBuilderUtil.returnSuccessResponse(RegisterUserResponse.class);
            registerUserResponse.setData(token);
        }
    }
}
