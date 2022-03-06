package com.h2.robotmallservice.enums;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS("200","success");

    private String resultCode;

    private String message;

    ResultCode(String resultCode, String message){
        this.resultCode = resultCode;
        this.message = message;
    }

}
