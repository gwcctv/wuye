package com.woniuxy.batchservice.jilianutils.mapper;

import com.woniuxy.batchservice.jilianutils.entity.House;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HouseMapper {
@Select("SELECT a.house_id,a.building_id,a.client_id,b.building_number,a.unit,a.house_number,c.client_name FROM tb_house a LEFT JOIN tb_building b ON a.building_id=b.building_id LEFT JOIN tb_client c ON a.client_id=c.client_id WHERE a.project_id=#{id}")
    List<House> getByProjectId(Integer id);
}
