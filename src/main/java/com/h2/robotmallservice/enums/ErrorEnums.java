package com.h2.robotmallservice.enums;

import lombok.Getter;

@Getter
public enum ErrorEnums {

    REGISTER_ERROR_01(500,"REGISTER_ERROR_01","User already exists"),
    REGISTER_ERROR_02(500,"REGISTER_ERROR_02","request format validate failure"),

    SERVER_ERROR(500, "UNKNOW_SYSTEM_ERROR", "Unknow system error");


    private Integer errorCode;

    private String errorType;

    private String errorMessage;

    ErrorEnums(Integer errorCode, String errorType, String errorMessage) {
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }
}
