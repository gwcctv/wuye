package com.woniuxy.wuye.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 结算账户管理实体类
 */
@Data
public class TbReceiveMoneyAccount implements Serializable {


    /**
     * 主键
     */
    private Integer id;

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
    private Integer projectId;
    /**
     * 项目名字
     */
    private String projectName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private String status;

    /**
     * 账户对应的所有项目名字
     * */
    List<String> projectNames;

    /**
     * 账户对应的所有项目ID
     * */
    List<Integer> projectIds;

}
