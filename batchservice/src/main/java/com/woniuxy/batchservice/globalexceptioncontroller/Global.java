package com.woniuxy.batchservice.globalexceptioncontroller;

import com.woniuxy.wuye.common.exceptions.NoIdInSqlException;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Global {
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity exception1(Exception e){
        e.printStackTrace();
        return new ResponseEntity("400","NO","对象属性格式错误，sql无法将数据填入表中");
    }
    @ExceptionHandler(NoIdInSqlException.class)
    @ResponseBody
    public ResponseEntity exception2(){
        return new ResponseEntity("400","NO","没有这个id值");
    }
}
