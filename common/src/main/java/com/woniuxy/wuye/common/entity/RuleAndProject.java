package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_ruleproject")
public class RuleAndProject {
    @TableField(value = "rule_id")
    private Integer roleId;
    @TableField(value = "project_id")
    private Integer ProjectId;
}
