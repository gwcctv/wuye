package com.woniuxy.wuye.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 批量减免实体类
 */
@Data
public class TbCheckReduce implements Serializable {



    /**
     * 主键
     */
    private Integer id;

    /**
     * 批次号
     */
    private String number;

//    /**
//     * 项目ID
//     */
//    private Integer projectId;

    /**
     * 收费项目ID
     */
    private Integer feetypeID;

    /**
     * 减免类型ID
     */
    private Integer reduceTypeId;

    /**
     * 减免金额
     */
    private String reducePrice;

    /**
     * 减免类型 固定金额 固定比例
     */
    private String reduceWay;

    /**
     * 生成状态
     */
    private String produceStatus;

    /**
     * 创建热
     */
    private  String produceName;

    /**
     * 创建时间
     */
    private Date produceTime;

    /**
     * 房产ID
     */
    private Integer houseId;

    /**
     * 减免理由
     */
    private String reduceReason;

/**
 * 项目名
 * */
    private String projectName;


    /**
     * 收费项目名称
     * */
    private String itemName;

/**
 * 减免类型 物业费减免 水电费减免等
 * */
    private String deductionName;
}
