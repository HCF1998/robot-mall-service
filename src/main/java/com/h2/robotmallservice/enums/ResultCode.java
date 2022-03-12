package com.h2.robotmallservice.enums;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
@Getter
/**
 * 返回体枚举类
 */
public enum ResultCode {

    SUCCESS(200,"Success"),
    BAD_REQUEST(400,"Bad Request"),
    UNAUTHORIZATION(401,"Unauthorized"),
    INTERNAL_SERVER_ERROR(500,"Internal Server error");

    // 业务码
    private Integer code;

    //信息描述
    private String message;

    ResultCode(Integer code , String message){
        this.code = code;
        this.message = message;
    }

}
