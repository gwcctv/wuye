package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "id",type = IdType.AUTO )
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
    @TableField("feetype_id")
    private Integer feetypeId;

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
    private String produceTime;

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
    /**
     * 状态 大于0 还剩余几次使用  用于周期性减免
     *      0 使用完了
     *      生成账单时会把状态更改为1
     *      帐单作废或者账单退款 会把状态改为0
     * */
    private String status;
    /**
     * 判断是账单减免还是滞纳金减免
     * 1为滞纳金 0为账单减免
     * */
    String judge;
}
