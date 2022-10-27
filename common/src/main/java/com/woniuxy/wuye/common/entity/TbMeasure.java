package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.List;

/**
 * 计量表
 * @author 魏锦鹏
 */
@Data
@TableName("tb_measure")
public class TbMeasure  {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 计量表编号
     */
    @TableField(value = "measure_num", condition = SqlCondition.EQUAL)
    private String measureNum;

    /**
     * 倍率
     */
    @TableField(value = "magnification", condition = SqlCondition.EQUAL)
    private String magnification;

    /**
     * 计量表名称
     */
    @TableField(value = "measure_name", condition = SqlCondition.EQUAL)
    private String measureName;

    /**
     * 计量表种类
     */
    @TableField(value = "machine_type", condition = SqlCondition.EQUAL)
    private String machineType;

    /**
     * 计量表类型
     */
    @TableField(value = "measure_type", condition = SqlCondition.EQUAL)
    private String measureType;

    /**
     * 损耗
     */
    @TableField(value = "wastage", condition = SqlCondition.EQUAL)
    private String wastage;

    /**
     * 所属项目名称
     */
    @TableField(value = "project_name", condition = SqlCondition.EQUAL)
    private Integer projectName;
    @TableField(exist = false)
    private String thisProjectName;

    /**
     * 收费项目
     */
    @TableField(value = "money_from", condition = SqlCondition.LIKE)
    private String moneyFrom;

    /**
     * 关联房产
     */
   // @TableField(value = "relevant_house", condition = SqlCondition.EQUAL)
            @TableField(exist = false)
    private List<Integer> relevantHouse;

    /**
     * 状态
     */
    @TableField(value = "situation", condition = SqlCondition.EQUAL)
    private String situation;

    /**
     * 最后抄表时间
     */
    @TableField(value = "last_read", condition = SqlCondition.EQUAL)
    private String lastRead;
    @TableField(exist = false)
    private String buildingId;
    @TableField(exist = false)
    private String unit;
    @TableField(exist = false)
    private String layer;
    @TableField(exist = false)
    private String houseNumber;
    @TableField(exist = false)
    private String allName;

}
