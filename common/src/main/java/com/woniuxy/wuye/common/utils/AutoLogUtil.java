package com.woniuxy.wuye.common.utils;


import com.woniuxy.wuye.common.annotation.AutoLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author li
 * @data 2022/10/23{} 9:15
 */
@Component
@Aspect
public class AutoLogUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoLogUtil.class);

    @Around("@annotation(autoLog)")
    public Object around(ProceedingJoinPoint point, AutoLog autoLog ) throws Throwable {
        String value = autoLog.value();
        //获取类名及其方法名
        String method = ((MethodSignature) point.getSignature()).getMethod().getDeclaringClass().getName() + "." + point.getSignature().getName();
        //执行方法前打印
        long starts = System.currentTimeMillis();
        LOGGER.info("{}调用方法{}，参数：{}",value,method,point.getArgs());
        Object result = point.proceed();
        //执行方法后打印
        long end = System.currentTimeMillis();
        LOGGER.info("{}调用方法{}，结果：{}，耗时：{}ms",value,method,result,end-starts);
        return result;
    }

}
