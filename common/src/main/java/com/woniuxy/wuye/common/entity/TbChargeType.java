package com.woniuxy.wuye.common.entity;

import lombok.Data;

import java.util.List;

/**
 * 收费项类型
 * @author 魏锦鹏
 */
@Data
public class TbChargeType  {

    private Integer id;
    /**
     * 类型名称
     */
    private String name;
   private Integer father;
    private List<TbChargeType> subMenus;

}
