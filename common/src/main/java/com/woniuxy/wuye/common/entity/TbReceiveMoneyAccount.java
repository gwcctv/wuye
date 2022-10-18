package com.woniuxy.wuye.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 结算账户管理实体类
 */
@Data
public class TbReceiveMoneyAccount implements Serializable {


    /**
     * 主键
     */
    private String id;

    /**
     * 账户名称
     */
    private String account;

    /**
     * 开户行
     */
    private String bank;

    /**
     * 账号
     */
    private String bankNum;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private String status;

}
