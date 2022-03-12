package com.h2.robotmallservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.h2.robotmallservice.common.ResponseResult;
import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.enums.ErrorEnums;
import com.h2.robotmallservice.model.request.UserLoginRequest;
import com.h2.robotmallservice.model.response.UserLoginResponse;
import com.h2.robotmallservice.repository.UserRepository;
import com.h2.robotmallservice.service.UserService;
import com.h2.robotmallservice.utils.JWTUtils;
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


    @Override
    public ResponseResult registerUser(User user) throws InstantiationException, IllegalAccessException {

        Optional<User> optionalUser = userRepository.findByUserName(user.getUserName());

        if (optionalUser.isPresent()) {
            return ResponseResult.failure(ErrorEnums.REGISTER_ERROR_01);
        } else {
            String password = encoder.encode(user.getPassword());
            user.setPassword(password);
            userRepository.save(user);
        }
        return ResponseResult.success();
    }

    @Override
    public ResponseResult userLogin(UserLoginRequest userLoginRequest) {

        Optional<User> user = userRepository.findByUserName(userLoginRequest.getUserName());
        if (user.isPresent()) {

            String dbPassword = user.get().getPassword();
            boolean matches = encoder.matches(userLoginRequest.getPassword(), dbPassword);

            if (matches) {
                try {
                    String token = JWTUtils.generateToken("Test");
                    UserLoginResponse userLoginResponse = new UserLoginResponse(userLoginRequest.getUserName(),token);
                    return ResponseResult.success(userLoginResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ResponseResult.failure(ErrorEnums.SERVER_ERROR);

    }
}
