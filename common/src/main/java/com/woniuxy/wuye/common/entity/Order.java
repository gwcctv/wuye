package com.woniuxy.wuye.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author：liangliang
 * @date:2022/10/18/18:55
 **/
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer orderId;

    /**
     * 计划类型
     */
    private String planType;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 描述
     */
    private String description;

    /**
     * 报告人
     */
    private String reporter;

    /**
     * 位置
     */
    private String location;

    /**
     * 报告时间
     */
    private Date reportDate;

    /**
     * 状态
     */
    private String status;

    /**
     * 接收人
     */
    private String accepter;

    /**
     * 工单编号
     */
    private String orderNum;



}
