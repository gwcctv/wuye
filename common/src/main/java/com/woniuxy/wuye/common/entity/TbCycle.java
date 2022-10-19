package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
@TableField(condition = SqlCondition.EQUAL)
    private Date startYear;
    /**
     * 周期收费开始时间
     */
    @TableField(condition = SqlCondition.EQUAL)
    private Date startMonth;
    /**
     * 周期收费开始时间
     */
    @TableField(condition = SqlCondition.EQUAL)
    private Date startDay;
    /**
     * 周期收费停止时间
     */
    @TableField(condition = SqlCondition.EQUAL)
    private Date endYear;
    /**
     * 周期收费停止时间
     */
    @TableField(condition = SqlCondition.EQUAL)
    private Date endMonth;
    /**
     * 周期收费停止时间
     */
    @TableField(condition = SqlCondition.EQUAL)
    private Date endDay;
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
    private Date produceTime;

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
    private String itemName;

    /**
     * 单元号
     * */
    private String unit;

/**
 * 楼层
 * */
    private String layer;

/**
 * 房号
 * */
    private String houseNumber;

/**
 * 项目名
 * */
    private String projectName;


    /**
     * 楼栋号
     * */
    private String  buildingNumber;
}
