package com.h2.robotmallservice.common;

import com.h2.robotmallservice.enums.ErrorEnums;
import com.h2.robotmallservice.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseResult<T> {

    private Integer code;

    private String message;

    private ErrorEnums errorEnums;

    private T data;

    private ResponseResult(ResultCode resultCode, ErrorEnums errorEnums, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.errorEnums = errorEnums;
        this.data = data;
    }


    public static ResponseResult<Void> success() {
        return new ResponseResult<Void>(ResultCode.SUCCESS, null, null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(ResultCode.SUCCESS, null, data);
    }

    public static ResponseResult<Void> failure(ErrorEnums errorEnums) {
        switch (errorEnums.getErrorCode()) {
            case 400:
                return new ResponseResult<Void>(ResultCode.BAD_REQUEST, errorEnums, null);
            case 401:
                return new ResponseResult<Void>(ResultCode.UNAUTHORIZATION, errorEnums, null);
            case 500:
                return new ResponseResult<Void>(ResultCode.INTERNAL_SERVER_ERROR, errorEnums, null);
        }
        return null;
    }
}
