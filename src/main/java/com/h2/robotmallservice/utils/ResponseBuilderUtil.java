//package com.h2.robotmallservice.utils;
//
//import com.h2.robotmallservice.enums.Contants;
//import com.h2.robotmallservice.enums.ErrorEnums;
//import com.h2.robotmallservice.enums.ResultCode;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
///**
// * 通过反射构建Response返回体
// */
//public class ResponseBuilderUtil {
//    public static void setter(Object obj,Object value,Class<?> type){
//        try {
//            Method method = obj.getClass().getMethod("setResult",type);
//            method.invoke(obj,value);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * build up success response
//     * @param targetResponseClass 返回体目标类
//     * @param <T>
//     * @return
//     * @throws InstantiationException
//     * @throws IllegalAccessException
//     */
//    public static <T extends BaseResponse> T returnSuccessResponse(Class<? extends BaseResponse> targetResponseClass) throws InstantiationException, IllegalAccessException {
//
//        BaseResponse.Result result = new BaseResponse.Result();
//        result.setResultCode(ResultCode.SUCCESS.getResultCode());
//        result.setResultMessage(ResultCode.SUCCESS.getMessage());
//        result.setVersion(Contants.VERSION);
//
//        Object obj = targetResponseClass.newInstance();
//        try {
//            Method method = obj.getClass().getMethod("setResult", BaseResponse.Result.class);
//            method.invoke(obj, result);
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        return (T) obj;
//    }
//
//    /**
//     * build up failure response
//     * @param targetResponseClass
//     * @param <T>
//     * @return
//     * @throws InstantiationException
//     * @throws IllegalAccessException
//     */
//    public static <T extends BaseResponse> T returnFailtureResponse(Class<? extends BaseResponse> targetResponseClass) throws InstantiationException, IllegalAccessException {
//
//        BaseResponse.Result result = new BaseResponse.Result();
//        result.setResultCode(ResultCode.SERVER_FAILURE.getResultCode());
//        result.setResultMessage(ResultCode.SERVER_FAILURE.getMessage());
//        result.setVersion(Contants.VERSION);
//
//        BaseResponse.Error error = new BaseResponse.Error();
//        error.setErrorCode(ErrorEnums.SERVER_Error.getErrorCode());
//        error.setErrorMessage(ErrorEnums.SERVER_Error.getErrorMessage());
//
//        Object obj = targetResponseClass.newInstance();
//        try {
//            Method resultMethod = obj.getClass().getMethod("setResult", BaseResponse.Result.class);
//            resultMethod.invoke(obj, result);
//            Method errorMethod = obj.getClass().getMethod("setError", BaseResponse.Error.class);
//            errorMethod.invoke(obj,error);
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        return (T) obj;
//    }
//}
