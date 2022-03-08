package com.h2.robotmallservice.enums;

import lombok.Getter;

@Getter
public enum ErrorType {

    SERVER_Error("500_1","服务器异常"),
    BADREQUEST_ERRPR("400_1","错误请求");

    private String errorCode;

    private String errorMessage;

    ErrorType(String errorCode,String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
