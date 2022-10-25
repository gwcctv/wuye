package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TbHouse
 */
@Data
public class TbHouse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房产id
     */
    private Integer houseId;
    /**
     * 客户id
     */
    private Integer clientId;

    /**
     * 楼栋id
     */
    private Integer buildingId;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 单元
     */
    private String unit;

    /**
     * 楼层
     */
    private String layer;

    /**
     * 房产号
     */
    private String houseNumber;

    /**
     * 房产类型
     */
    private String houseType;

    /**
     * 房产面积
     */
    private Double area;

    /**
     * 计费开始日期
     */
    private Date payTime;

    /**
     * 入住状态
     */
    private String stayState;

    /**
     * 出售状态
     */
    private String sellState;

    /**
     * 装修状态
     */
    private String fitmentState;

    /**
     * 租赁状态
     */
    private String leaseState;

    /**
     * 朝向
     */
    private String towards;

    /**
     * 交房日期
     */
    private Date handoverDate;

    /**
     * 不动产权号
     */
    private String propertyNumber;

    /**
     * 房产坐落
     */
    private String description;
    /**
     * 项目名
     */
    @TableField(exist = false)
    private String projectName;
    /**
     * 楼栋号
     */
    @TableField(exist = false)
    private Integer buildingNumber;
    /**
     * 客户名
     */
    @TableField(exist = false)
    private String clientName;


}
