package com.woniuxy.wuye.cash.utils;

import lombok.Data;

/**
 * @Description: 前端多条件查询的条件传输类
 * @Author: baobo
 * @Date: 2022/10/21
 **/
@Data
public class ConditionVo {
    //项目名
    private String projectName;
    //用户名
    private String clientName;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //收费项目
    private String feesItem;
    //应收日期
    private String shouldGetTime;
}
