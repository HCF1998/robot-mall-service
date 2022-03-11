package com.h2.robotmallservice.service.impl;

import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.model.RegisteredUser;
import com.h2.robotmallservice.model.response.PublicUserResponse;
import com.h2.robotmallservice.repository.UserRepository;
import com.h2.robotmallservice.service.UserService;
import com.h2.robotmallservice.utils.ResponseBuilderUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public PublicUserResponse registerUser(User user) throws InstantiationException, IllegalAccessException {

        PublicUserResponse publicUserResponse;

        Optional<User> optionalUser = userRepository.findByUserName(user.getUserName());

        if (optionalUser.isPresent()) {
            publicUserResponse = ResponseBuilderUtil.returnFailtureResponse(PublicUserResponse.class);

        } else {
            String password = encoder.encode(user.getPassword());
            user.setPassword(password);
            userRepository.save(user);
            publicUserResponse = ResponseBuilderUtil.returnSuccessResponse(PublicUserResponse.class);
            RegisteredUser registeredUser = new RegisteredUser();
            registeredUser.setUserName(user.getUserName());
            publicUserResponse.setData(registeredUser);
        }
        return publicUserResponse;
    }
}
