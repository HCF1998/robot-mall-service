package com.h2.robotmallservice.model.response;

import com.h2.robotmallservice.common.BaseResponse;

public class UserLoginResponse extends BaseResponse<T> {
    public UserLoginResponse(Result result,Error error,String token);
}
