package com.h2.robotmallservice.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.h2.robotmallservice.common.BaseResponse;
import com.h2.robotmallservice.model.RegisteredUser;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterUserResponse extends BaseResponse<RegisteredUser> {

    public RegisterUserResponse(Result result, Error error, RegisteredUser data) {
        super(result, error, data);
    }
}
