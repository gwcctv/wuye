package com.woniuxy.buildingmanager.vo;

import com.woniuxy.wuye.common.entity.TbBuilding;
import lombok.Data;

@Data
public class BuildingVo {
    private TbBuilding tbBuilding;
    private Integer page;
    private Integer pageSize;
}
