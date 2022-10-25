package com.woniuxy.batchservice.provider;

import com.woniuxy.wuye.common.entity.TbCheckReduce;
import com.woniuxy.wuye.common.entity.TbClock;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

@Slf4j
public class TbClockProvider {

    public String selectByCondition(TbClock tbClock){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("(SELECT n.*,o.building_number FROM  (SELECT l.*,m.building_id,m.unit,m.layer,m.house_number FROM (SELECT g.*,h.client_id,h.client_name FROM (SELECT * FROM  (SELECT c.*,d.measure_type,d.machine_type,d.measure_name FROM (SELECT a.*,b.project_name FROM tb_clock a LEFT JOIN tb_project b ON a.project_id=b.project_id) c LEFT JOIN tb_measure d ON c.clock_id=d.id) e LEFT JOIN tb_measurehou f ON e.id=f.measure_id) g LEFT JOIN tb_client h ON g.house_id=h.client_id) l LEFT JOIN tb_house m ON l.house_id=m.house_id) n LEFT JOIN tb_building  o ON n.building_id=o.building_id) z");
                if(tbClock.getProjectName()!=null && !tbClock.getProjectName().equals("")){
                    WHERE("project_name=#{projectName}");
                }
                if(tbClock.getClientName()!=null && !tbClock.getClientName().equals("")){
                    WHERE("client_name=#{clientName}");
                }
                if(tbClock.getMeasureName()!=null && !tbClock.getMeasureName().equals("")){
                    WHERE("measure_name=#{measureName}");
                }
                if(tbClock.getMachineType()!=null  && !tbClock.getMachineType().equals("")){
                    WHERE("machine_type=#{machineType}");
                }
                if(tbClock.getMeasureType()!=null  && !tbClock.getMeasureType().equals("")){
                WHERE("measure_type=#{measureType}");
            }   if(tbClock.getProduceTime()!=null  && !tbClock.getProduceTime().equals("")){
                WHERE("produce_time=#{produceTime}");
            }
                if(tbClock.getEnterStatus()!=null && !tbClock.getEnterStatus().equals("")){
                    WHERE("enter_status=#{enterStatus}");
                }
                if(tbClock.getId()!=null && tbClock.getId()!=0){
                    WHERE("id=#{id}");
                }

            }

        }.toString();
        return  sql;
    }

}
