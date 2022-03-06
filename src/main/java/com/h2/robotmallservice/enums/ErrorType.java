package com.h2.robotmallservice.enums;

import org.springframework.validation.Errors;

public enum ErrorType {

    SERVER_Error(500,"服务器异常"),
    BADREQUEST_ERRPR(400,"错误请求");

    private int errorCode;

    private String errorMessage;

    ErrorType(int errorCode,String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
