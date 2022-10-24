package com.woniuxy.wuye.cash.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/23
 **/
public class WoNiuTimeUtil {
    public static String getNowTimeNumber(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyymmddHHMMss"));
    }
    public static String getNowTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH-MM-ss"));
    }
}
