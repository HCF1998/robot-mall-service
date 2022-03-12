package com.h2.robotmallservice.model.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Getter
@Setter
public class UserLoginResponse {

    private String userName;

    private String accessToken;

    public UserLoginResponse(String userName, String accessToken) {
        this.userName = userName;
        this.accessToken = accessToken;
    }
}
