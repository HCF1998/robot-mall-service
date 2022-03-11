package com.h2.robotmallservice.controller;

import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.repository.UserRepository;
import com.h2.robotmallservice.utils.JWTUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/public/login")
    public String login(@RequestBody LoginRequestBody loginRequestBody){
        Optional<User> user = userRepository.findByUserName(loginRequestBody.getUsername());
        if (user.isPresent()){
            return JWTUtils.generateToken("user");
        }
        return null;
    }
}

@Getter
@Setter
class LoginRequestBody{
    private String username;
}
