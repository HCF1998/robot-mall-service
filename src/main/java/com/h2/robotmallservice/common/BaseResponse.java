package com.h2.robotmallservice.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public abstract class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -8824033221519683369L;

    private Result result;

    private Error error;

    private T data;


    @Getter
    @Setter
    //Json串序列化：SnakeCase策略,Java对象属性：personId，序列化后：person_id
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Result {

        private String resultCode;

        private String resultMessage;

        private String version;

    }

    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Error {

        private String errorCode;

        private String errorMessage;

    }
}
