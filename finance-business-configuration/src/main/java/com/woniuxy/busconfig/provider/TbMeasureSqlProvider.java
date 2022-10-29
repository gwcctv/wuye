package com.woniuxy.busconfig.provider;

import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.entity.TbMeasure;
import org.apache.ibatis.jdbc.SQL;

/**
 * 用户可修改字段
 * @魏锦鹏
 */
public class TbMeasureSqlProvider {

    public String getByCondition(TbMeasure TbMeasure) {
        if(TbMeasure==null){
            return  new SQL(){
                {
                    SELECT("*");
                    FROM("(SELECT a.*,b.building_id,b.unit,b.layer,b.house_number FROM (SELECT*FROM (SELECT tm.*,tbp.project_name  thisProjectName FROM tb_measure tm LEFT JOIN tb_project  tbp ON tm.project_name= tbp.project_id) c LEFT JOIN tb_measurehou d ON c.id=d.measure_id) a LEFT JOIN tb_house b ON a.house_id=b.house_id) hhh");}
            }.toString();
        }else {
            return new SQL() {
                {
                    SELECT("*");
                    FROM("(SELECT a.*,b.building_id,b.unit,b.layer,b.house_number FROM (SELECT*FROM (SELECT tm.*,tbp.project_name  thisProjectName FROM tb_measure tm LEFT JOIN tb_project  tbp ON tm.project_name= tbp.project_id) c LEFT JOIN tb_measurehou d ON c.id=d.measure_id) a LEFT JOIN tb_house b ON a.house_id=b.house_id) hhh");
                    if (TbMeasure.getMeasureName()!= null && !"".equals(TbMeasure.getMeasureName())) {
                        WHERE("measure_name like concat('%',#{measureName},'%')");
                    }
                    if (TbMeasure.getMeasureNum()!= null&& !"".equals(TbMeasure.getMeasureNum())) {
                        WHERE("measure_num=#{measureNum}");
                    }
                    if (TbMeasure.getMeasureType()!= null&& !"".equals(TbMeasure.getMeasureType())) {
                        WHERE("measure_type=#{measureType}");
                    }
                    if(TbMeasure.getMachineType()!= null&& !"".equals(TbMeasure.getMachineType())) {
                    WHERE("machine_type=#{machineType}");
                }
                    if(TbMeasure.getMagnification()!= null&& !"".equals(TbMeasure.getMagnification())) {
                        WHERE("magnification=#{magnification}");
                    }
                    if(TbMeasure.getWastage()!= null&& !"".equals(TbMeasure.getWastage())) {
                        WHERE("wastage=#{wastage}");
                    }

                    if(TbMeasure.getMoneyFrom()!= null&& !"".equals(TbMeasure.getMoneyFrom())) {
                        WHERE("money_from=#{moneyFrom}");
                    }
                    if(TbMeasure.getSituation()!= null&& !"".equals(TbMeasure.getSituation())) {
                    WHERE("situation=#{situation}");
                }
                    if(TbMeasure.getLastRead()!= null&& !"".equals(TbMeasure.getLastRead())) {
                        WHERE("last_read=#{lastRead}");
                    }
                    if(TbMeasure.getBuildingId()!= null&& !"".equals(TbMeasure.getBuildingId())) {
                        WHERE("building_id=#{buildingId}");
                    }
                    if(TbMeasure.getUnit()!= null&& !"".equals(TbMeasure.getUnit())) {
                        WHERE("unit=#{unit}");
                    }
                    if(TbMeasure.getLayer()!= null&& !"".equals(TbMeasure.getLayer())) {
                        WHERE("layer=#{layer}");
                    }
                    if(TbMeasure.getHouseNumber()!= null&& !"".equals(TbMeasure.getHouseNumber())) {
                        WHERE("house_number=#{houseNumber}");
                    }
                    if(TbMeasure.getThisProjectName()!= null&& !"".equals(TbMeasure.getThisProjectName())) {
                        WHERE("thisProjectName=#{thisProjectName}");
                    }
                }
            }.toString();
        }
    }
}