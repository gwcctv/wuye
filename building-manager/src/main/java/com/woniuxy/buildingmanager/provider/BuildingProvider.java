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
              UPDATE("tb_building");
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
              if(tbBuilding.getDescription()!=null){
                    SET("description=#{description}");
              }
              if(tbBuilding.getProjectId()!=null){
                SET("project_id=#{projectId}");
              }
                WHERE("building_id=#{buildingId}");
            }
        }.toString();
    }

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
                    SELECT("*");
                    FROM("tb_building");
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
                    if(tbBuilding.getProjectId()!=null){
                        WHERE("project_id=#{projectId}");
                    }

                }
            }.toString();
        }

    }
}
