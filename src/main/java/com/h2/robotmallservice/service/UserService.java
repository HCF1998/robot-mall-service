package com.h2.robotmallservice.service;

import com.h2.robotmallservice.entity.User;
import com.h2.robotmallservice.model.response.PublicUserResponse;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    PublicUserResponse registerUser(User user) throws InstantiationException, IllegalAccessException;
}
