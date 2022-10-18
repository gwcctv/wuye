package com.woniuxy.wuye.common.entity;

import lombok.Data;

/**
 * 规则配置表
 * @author 魏锦鹏
 */
@Data
public class TbRuleConfiguration {
    /**
     * ''
     */
    private String id;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 规则描述
     */
    private String ruleDescription;

    /**
     * 是否启用
     */
    private String ruleSituation;

}

