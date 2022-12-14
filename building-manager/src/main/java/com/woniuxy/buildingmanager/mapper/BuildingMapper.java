package com.woniuxy.buildingmanager.mapper;

import com.woniuxy.buildingmanager.provider.BuildingProvider;
import com.woniuxy.wuye.common.entity.TbBuilding;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BuildingMapper {
    /**
     * 增加楼栋
     * @param tbBuilding
     */
    @Select("insert into tb_building (number,building_number,building_type,layer,unit,description,project_id)values" +
            "(#{number},#{buildingNumber},#{buildingType},#{layer},#{unit},#{description},#{projectId})")
    void insert(TbBuilding tbBuilding);

    /**
     * 删除楼栋根据id
     * @param id
     */
    @Delete("delete from tb_building where building_id=#{id}")
    void delete(Integer id);

    /**
     * 多条件修改楼栋信息
     * @param tbBuilding
     */
    @UpdateProvider(value = BuildingProvider.class,method = "update")
    void update(TbBuilding tbBuilding);



    /**
     * 查询全部楼栋(并带出项目名)
     * @return
     */
//    @Select("SELECT tb.* ,tp.project_name FROM tb_building tb,tb_project tp WHERE tb.project_id=tp.project_id")
//    @Results({
//            @Result(column = "building_id",property = "buildingId",id = true),
//            @Result(column = "number",property = "number"),
//            @Result(column = "building_number",property = "buildingNumber"),
//            @Result(column = "building_type",property = "buildingType") ,
//            @Result(column = "layer",property = "layer") ,
//            @Result(column = "unit",property = "unit"),
//            @Result(column = "description",property = "description"),
//           @Result(column = "project_name",property = "tbProject.projectName")
//
//    })
    @Select("SELECT tb.* ,tp.project_name projectName FROM tb_building tb,tb_project tp WHERE tb.project_id=tp.project_id")
    @Results(id = "result",value = {
            @Result(column = "building_id",property = "buildingId",id = true),
           @Result(column = "projectName",property = "projectName")
    })
    List<TbBuilding> getAll();
    /**
     * 多条件查询
     * @param tbBuilding
     * @return
     */
    @SelectProvider(value = BuildingProvider.class,method ="select")
    @ResultMap("result")
    List<TbBuilding> getByCondition(TbBuilding tbBuilding);

    /**
     * 根据楼栋编号查楼栋id
     * @param buildingNumber
     * @return
     */
    @Select("select building_id from tb_building where building_number=#{buildingNumber}")
    int getByBuildingNumber(int buildingNumber);
    /**
     * 多条件查询
     * @param tbBuilding
     * @return
     */
//    @Select("SELECT tb.* ,tp.project_name projectName FROM tb_building tb,tb_project tp WHERE tb.project_id=tp.project_id\n" +
//            "and tb.building_type=#{buildingType} and tb.building_number=#{buildingNumber} \n" +
//            "and tb.project_id IN ( SELECT project_id FROM tb_project WHERE project_name=#{projectName})")
//
//    List<TbBuilding> getByCondition(TbBuilding tbBuilding);


}
