package com.woniuxy.wuye.common.entity;

import lombok.Data;

/**
 * 收费项目表
 * @author 魏锦鹏
 */
@Data
public class TbChargeableItems  {
    private Integer id;
    /**
     * 项目名称
     */
    private String itemName;

    /**
     *项目类型
     */
    private Integer itmeTypeId;

    /**
     * 项目性质
     */
    private String feesQuality;

    /**
     * 状态
     */
    private String situation;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否周期性
     */
    private String periodic;

}
