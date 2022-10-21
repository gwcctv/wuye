package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_projectfsc")
public class TbProjectfsc {
    @TableField(value = "fsc_id")
    private Integer fscId;
    @TableField(value = "project_id ")
    private Integer project_id;
}
