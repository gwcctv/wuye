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
                    FROM("(SELECT a.*,b.building_id,b.unit,b.layer,b.house_number FROM (SELECT*FROM (SELECT tm.*,tbp.project_name  tbp_project_name FROM tb_measure tm LEFT JOIN tb_project  tbp ON tm.project_name= tbp.project_id) c LEFT JOIN tb_measurehou d ON c.id=d.measure_id) a LEFT JOIN tb_house b ON a.house_id=b.house_id) hhh");}
            }.toString();
        }else {
            return new SQL() {
                {
                    SELECT("*");
                    FROM("(SELECT a.*,b.building_id,b.unit,b.layer,b.house_number FROM (SELECT*FROM (SELECT tm.*,tbp.project_name  tbp_project_name FROM tb_measure tm LEFT JOIN tb_project  tbp ON tm.project_name= tbp.project_id) c LEFT JOIN tb_measurehou d ON c.id=d.measure_id) a LEFT JOIN tb_house b ON a.house_id=b.house_id) hhh");
                    if (TbMeasure.getMeasureName()!= null && !"".equals(TbMeasure.getMeasureName())) {
                        WHERE("measure_name like concat('%',#{measureName},'%')");
                    }
                    if (TbMeasure.getMeasureNum()!= null) {
                        WHERE("measure_num=#{measureNum}");
                    }
                    if (TbMeasure.getMeasureType()!= null) {
                        WHERE("measure_type=#{measureType}");
                    }
                    if(TbMeasure.getMachineType()!= null) {
                    WHERE("machine_type=#{machineType}");
                }
                    if(TbMeasure.getMagnification()!= null) {
                        WHERE("magnification=#{magnification}");
                    }
                    if(TbMeasure.getWastage()!= null) {
                        WHERE("wastage=#{wastage}");
                    }
                    if(TbMeasure.getThisProjectName()!= null) {
                        WHERE("this_project_name=#{thisProjectName}");
                    }
                    if(TbMeasure.getMoneyFrom()!= null) {
                        WHERE("money_from=#{moneyFrom}");
                    }
                    if(TbMeasure.getSituation()!= null) {
                    WHERE("situation=#{situation}");
                }
                    if(TbMeasure.getLastRead()!= null) {
                        WHERE("last_read=#{lastRead}");
                    }
                    if(TbMeasure.getBuildingId()!= null) {
                        WHERE("building_id=#{buildingId}");
                    }
                    if(TbMeasure.getUnit()!= null) {
                        WHERE("unit=#{unit}");
                    }
                    if(TbMeasure.getLayer()!= null) {
                        WHERE("layer=#{layer}");
                    }
                    if(TbMeasure.getHouseNumber()!= null) {
                        WHERE("house_number=#{houseNumber}");
                    }
                }
            }.toString();
        }
    }
}