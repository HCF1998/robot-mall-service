package com.h2.robotmallservice.enums;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS("200","success"),
    SERVER_FAILURE("500","Server faiilure");

    private String resultCode;

    private String message;

    ResultCode(String resultCode, String message){
        this.resultCode = resultCode;
        this.message = message;
    }

}
