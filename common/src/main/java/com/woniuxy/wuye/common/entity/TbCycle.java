package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 循环周期业务实体类
 */
@Data
@TableName("tb_cycle")
public class TbCycle implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO )
    private Integer id;




    /**
     * 收费项目ID
     */
   @TableField(value = "feetype_id",condition = SqlCondition.EQUAL)
    private Integer feetypeId;

    /**
     * 房产ID
     */
    @TableField(value = "house_id",condition = SqlCondition.EQUAL)
    private Integer houseId;

    /**
     * 收费周期
     */
@TableField(condition = SqlCondition.EQUAL)
    private Integer feecycle;

    /**
     * 周期收费开始时间
     */
@TableField(value = "start_year",condition = SqlCondition.EQUAL)
    private String startYear;
    /**
     * 周期收费开始时间
     */
    @TableField(value = "start_month",condition = SqlCondition.EQUAL)
    private String startMonth;
    /**
     * 周期收费开始时间
     */
    @TableField(value = "start_day",condition = SqlCondition.EQUAL)
    private String startDay;
    /**
     * 周期收费停止时间
     */
    @TableField(value = "end_year",condition = SqlCondition.EQUAL)
    private String endYear;
    /**
     * 周期收费停止时间
     */
    @TableField(value = "end_month",condition = SqlCondition.EQUAL)
    private String endMonth;
    /**
     * 周期收费停止时间
     */
    @TableField(value = "end_day",condition = SqlCondition.EQUAL)
    private String endDay;
    /**
     * 创建状态
     */
    @TableField(value = "produce_status",condition = SqlCondition.EQUAL)
    private String produceStatus;

    /**
     * 创建人
     */
    @TableField(value = "produce_name",condition = SqlCondition.EQUAL)
    private String produceName;

    /**
     * 创建时间
     */
    @TableField(value = "produce_time",condition = SqlCondition.EQUAL)
    private String produceTime;

    /**
     * 业务批次号
     */
    @TableField(condition = SqlCondition.EQUAL)
    private String number;

    /**
     * 单价
     */
    @TableField(condition = SqlCondition.EQUAL)
    private String price;

    /**
     * 应收    单价*周期
     */

    @TableField(value = "total_money",condition = SqlCondition.EQUAL)
    private String totalMoney;

    /**
     * 生成失败的原因 比如逻辑问题 截止时间早于起始时间
     */
    @TableField(value = "failure_produce_reason",condition = SqlCondition.LIKE)
    private String failureProduceReason;


    /**
     * 收费项目名称
     * */
    @TableField(exist = false)
    private String itemName;

    /**
     * 单元号
     * */
    @TableField(exist = false)
    private String unit;

/**
 * 楼层
 * */
@TableField(exist = false)
    private String layer;

/**
 * 房号
 * */
@TableField(exist = false)
    private String houseNumber;

/**
 * 项目名
 * */
@TableField(exist = false)
    private String projectName;
    /**
     * 项目Id
     * */
    @TableField(exist = false)
    private Integer projectId;


    /**
     * 楼栋号
     * */
    @TableField(exist = false)
    private String  buildingNumber;
    /**
     * 周期业务对应的减免账单
     * */
    @TableField(exist = false)
    private List<TbCheckReduce> tbCheckReduceList;
    /**
     * 周期业务对应的减免滞纳金减免
     * */
    @TableField(exist = false)
    private List<TbCheckReduce> tbCheckReduceListForLateMoney;

    /**
     * 客户Id
     * */
    @TableField(exist = false)
    Integer clientId;
    /**
     * 开始时间
     * */
    @TableField(exist = false)
    String  startTime;
    /**
     * 截止时间
     * */
    @TableField(exist = false)
    String endTime;

}
