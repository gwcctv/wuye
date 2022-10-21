package com.woniuxy.housemanager.mapper;

import com.woniuxy.housemanager.provider.HouseProvider;
import com.woniuxy.wuye.common.entity.TbHouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 房产mapper
 */
public interface HouseMapper {
    /**
     * 增加房
     * @param tbHouse
     */
    @Insert("insert into tb_house (building_id,project_id,unit,layer,house_number,house_type,area,pay_time,stay_state,sell_state,fitment_state,lease_state,towards," +
            "handover_date,property_number,description)values (#{buildingId},#{projectId},#{unit},#{layer},#{houseNumber},#{houseType},#{area},#{payTime},#{stayState}," +
            "#{sellState},#{fitmentState},#{leaseState},#{towards},#{handoverDate},#{propertyNumber},#{description})")
    void insert(TbHouse tbHouse);

    /**
     * 删除房
     * @param id
     */
    @Delete("delete from tb_house where house_id=#{id}")
    void delete(Integer id);

    /**
     * 多条件修改
     * @param tbHouse
     */

    @UpdateProvider(value = HouseProvider.class,method = "update")
    void update(TbHouse tbHouse);

    /**
     * 多条件查询
     * @param tbHouse
     * @return
     */
    @SelectProvider(value = HouseProvider.class,method = "select")
    List<TbHouse> getByCondition(TbHouse tbHouse);

    /**
     * 查询全部
     * @return
     */
    @Select("SELECT h.*,p.project_name projectName,b.building_number buildingNumber,c.client_name clientName\n" +
            " FROM tb_house h,tb_project p,tb_building b,tb_client c\n" +
            "WHERE h.client_id=c.client_id AND h.building_id=b.building_id AND h.project_id=p.project_id")
    List<TbHouse> getAll();
}
