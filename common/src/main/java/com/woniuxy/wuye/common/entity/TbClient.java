package com.woniuxy.wuye.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * TbClient
 */
@Data
public class TbClient implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户id
     */
    private Integer clientId;

    /**
     * 客户编号
     */
    private String number;

    /**
     * 客户名字
     */
    private String clientName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 身份证号
     */
    private String card;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 工作地址
     */
    private String workAddress;

    /**
     * 备注
     */
    private String description;

    /**
     * 房客关系
     */
    private String relationship;

    /**
     * 房产id
     */
    private Integer houseId;

    /**
     * 客户状态
     */
    private String clientState;

}
