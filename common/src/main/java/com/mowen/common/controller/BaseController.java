package com.mowen.common.controller;

import com.mowen.common.domain.ErrorResult;
import com.mowen.common.domain.ResponseEntity;

/****
 * @project: spring-boot-example
 * @author: huangkai
 * @create-time: 2020/4/30 9:26 
 * @description:
 *****/
public class BaseController {


    public String buildSuccessResult(Object object){
        ResponseEntity responseEntity = new ResponseEntity("200", object);
        return responseEntity.toString();
    }

    public String buildErrorResult(String errorCode, String errorMessage){
        ErrorResult errorResult = new ErrorResult();
        errorResult.setEc(errorCode);
        errorResult.setEm(errorMessage);
        ResponseEntity responseEntity = new ResponseEntity("200", errorResult);
        return responseEntity.toString();
    }

    public String buildErrorResultMessage(String errorMessage){
        return buildErrorResult(null, errorMessage);
    }

    public String buildErrorResultCode(String errorCode){
        return buildErrorResult(errorCode, null);
    }
}
