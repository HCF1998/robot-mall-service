package com.h2.robotmallservice.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {

    private String userName;

    private String password;
}
