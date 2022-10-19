package com.woniuxy.wuye.common.entity;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/19
 **/
import lombok.Data;

import java.io.Serializable;

/**
 * 预存金额总表
 */
@Data
public class TbDepositedFees implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 关联用户表
     */
    private TbClient depositedUser;

    /**
     * 剩余预存金额
     */
    private String remainderDeposited;

    /**
     * 更新时间
     */
    private String time;

}
