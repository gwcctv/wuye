package com.woniuxy.wuye.common.entity.vo;

import com.woniuxy.wuye.common.entity.TbHouse;
import lombok.Data;

@Data
public class HouseVo {

    private TbHouse tbHouse;
    private Integer pageSize;
    private  Integer page;

}
