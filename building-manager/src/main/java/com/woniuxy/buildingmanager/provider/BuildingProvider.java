package com.woniuxy.buildingmanager.provider;

import com.woniuxy.wuye.common.entity.TbBuilding;
import org.apache.ibatis.jdbc.SQL;

public class BuildingProvider {
    /**
     * 多条件修改
     * @param tbBuilding
     * @return
     */
    public String update(TbBuilding tbBuilding){
        return new SQL(){
            {
              UPDATE("tb_building tb");
              if(tbBuilding.getNumber()!=null){
                  SET("number=#{number}");
              }
              if(tbBuilding.getBuildingNumber()!=null){
                  SET("building_number=#{buildingNumber}");
              }
              if(tbBuilding.getBuildingType()!=null){
                    SET("building_type=#{buildingType}");
              }
              if(tbBuilding.getLayer()!=null){
                    SET("layer=#{layer}");
              }
              if(tbBuilding.getUnit()!=null){
                    SET("unit=#{unit}");
              }
              if(tbBuilding.getProjectName()!=null){//这里表示修改楼栋表的项目名，然后改变楼栋表的项目id
                    SET("tb.project_id= (SELECT tp.project_id FROM tb_project tp WHERE tp.project_name=#{projectName})");
                     //SET("tb.project_id=#{projectId}");
              }
              if(tbBuilding.getDescription()!=null){
                    SET("description=#{description}");
              }

              WHERE("tb.building_id=#{buildingId}");
            }
        }.toString();
    }

    /**
     * 多条件查询
     * @param tbBuilding
     * @return
     */
    public String select(TbBuilding tbBuilding){
        if(tbBuilding==null){
            return new SQL(){
                {
                    SELECT("*");
                    FROM("tb_building");
                }
            }.toString();
        }else{
            return new SQL(){
                {
                    SELECT("tb.* ,tp.project_name projectName");
                    FROM("tb_building tb,tb_project tp");
                    if(tbBuilding.getBuildingId()!=null){
                        WHERE("building_id=#{buildingId}");
                    }
                    if(tbBuilding.getNumber()!=null){
                        WHERE("number=#{number}");
                    }
                    if(tbBuilding.getBuildingNumber()!=null){
                        WHERE("building_number=#{buildingNumber}");
                    }
                    if(tbBuilding.getBuildingType()!=null&&!"".equals(tbBuilding.getBuildingType())){
                        WHERE("building_type=#{buildingType}");
                    }
                    if(tbBuilding.getLayer()!=null){
                        WHERE("layer=#{layer}");
                    }
                    if(tbBuilding.getUnit()!=null){
                        WHERE("unit=#{unit}");
                    }
                    if(tbBuilding.getDescription()!=null){
                        WHERE("description=#{description}");
                    }
                    if(tbBuilding.getProjectName()!=null && ! "".equals(tbBuilding.getProjectName())){
                        //这里表示通过输入项目名，然后就可以查出该项目下的楼栋
                        WHERE("tb.project_id IN (SELECT tp.project_id FROM tb_project WHERE tp.project_name=#{projectName})");
                    }else {
                        WHERE("tb.project_id=tp.project_id");
                    }

                }
            }.toString();
        }

    }
}
