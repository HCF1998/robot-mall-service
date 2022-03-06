package com.h2.robotmallservice.service.impl;

import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.repository.UserRepository;
import com.h2.robotmallservice.service.UserService;
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
    public void registerUser(User user) {

        Optional<User> optionalUser = userRepository.findByUserName(user.getUserName());

        if (optionalUser.isPresent()){

        }else {
            String password = encoder.encode(user.getPassword());
            user.setPassword(password);
            System.out.println(password);
            userRepository.save(user);
        }
    }
}
