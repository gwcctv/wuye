package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 收费标准配置表
 * @author 魏锦鹏
 */
@Data
//@TableName("tb_fees_standard_configuration")
public class TbFeesStandardConfiguration  {
//@TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 收费标准编号
     */
   // @TableField(value = "standard_num", condition = SqlCondition.EQUAL)
    private String standardNum;

    /**
     * 收费标准名称
     */
   // @TableField(value = "standard_name", condition = SqlCondition.LIKE)
    private String standardName;

    /**
     * 收费项目
     */
   // @TableField(value = "fees_item", condition = SqlCondition.EQUAL)
    private Integer feesItem;

    /**
     * 计费方式
     */
   // @TableField(value = "billing_method", condition = SqlCondition.EQUAL)
    private String billingMethod;

    /**
     * 单价
     */
   // @TableField(value = "price", condition = SqlCondition.EQUAL)
    private BigDecimal price;

    /**
    * 关联项目
     *
     * * */
   // @TableField(value = "project", condition = SqlCondition.EQUAL)
    private List<Integer> projectNameList;
    private String projectName;
    /**
     * 状态
     */
   // @TableField(value = "situation", condition = SqlCondition.EQUAL)
    private String situation;
    @TableField(exist = false)
    private Integer projectId;
}