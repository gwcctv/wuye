package com.woniuxy.wuye.common.entity;

import lombok.Data;
/**
 * 账单减免类型
 * @author 魏锦鹏
 */
@Data
public class TbMoneyDeduction  {
    private String id;

    /**
     * 减免类型名称
     */
    private String deductionName;

    /**
     * 状态
     */
    private String situation;

}
