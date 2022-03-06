package com.h2.robotmallservice.service;

import com.h2.robotmallservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    void registerUser(User user);
}
