package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
/**
 * 账单减免类型
 * @author 魏锦鹏
 */
@Data
@TableName("tb_money_deduction")
public class TbMoneyDeduction  {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 减免类型名称
     */
    @TableField(value = "deduction_name", condition = SqlCondition.LIKE)
    private String deductionName;

    /**
     * 状态
     */
    @TableField(value = "situation", condition = SqlCondition.EQUAL)
    private String situation;

}
