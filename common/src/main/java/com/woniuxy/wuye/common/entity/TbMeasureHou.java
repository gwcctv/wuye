package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@TableName("tb_measurehou")
public class TbMeasureHou {
@TableField(value = "house_id")
    private Integer houseId;
@TableField(value = "measure_id")
private  Integer measureId;
}
