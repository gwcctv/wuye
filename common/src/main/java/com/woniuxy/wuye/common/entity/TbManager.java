package com.woniuxy.wuye.common.entity;

import lombok.Data;

/**
 * 后台管理者实体类
 */
@Data
public class TbManager {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 管理者账号
     */
    private String account;
    /**
     * 管理者密码
     */
    private String password;
    /**
     *管理者头像
     */
    private String headPhone;
    /**
     * 管理者状态
      */
    private String state;
}
