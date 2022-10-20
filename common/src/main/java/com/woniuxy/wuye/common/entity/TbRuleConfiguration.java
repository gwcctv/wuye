package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 规则配置表
 * @author 魏锦鹏
 */
@Data
@TableName("tb_rule_configuration")
public class TbRuleConfiguration {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 规则名称
     */
    @TableField(value = "rule_name", condition = SqlCondition.EQUAL)
    private String ruleName;

    /**
     * 规则描述
     */
    @TableField(value = "rule_description", condition = SqlCondition.EQUAL)
    private String ruleDescription;

    /**
     * 是否启用
     */
    @TableField(value = "rule_situation", condition = SqlCondition.EQUAL)
    private String ruleSituation;

    private String projectName;
}

