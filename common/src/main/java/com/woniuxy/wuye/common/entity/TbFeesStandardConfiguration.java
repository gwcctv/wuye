package com.woniuxy.wuye.common.entity;

import lombok.Data;

/**
 * 收费标准配置表
 * @author 魏锦鹏
 */
@Data
public class TbFeesStandardConfiguration  {

    private String id;

    /**
     * 收费标准编号
     */
    private String standardNum;

    /**
     * 收费标准名称
     */
    private String standardName;

    /**
     * 收费项目
     */
    private String feesItem;

    /**
     * 计费方式
     */
    private String billingMethod;

    /**
     * 单价
     */
    private String price;

    /**
     * 关联项目
     */
    private String project;

    /**
     * 状态
     */
    private String situation;

}