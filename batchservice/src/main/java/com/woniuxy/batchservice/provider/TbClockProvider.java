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
                FROM("(SELECT e.*,f.client_id,f.client_name FROM (SELECT c.*,d.measure_type,d.machine_type,d.relevant_house,d.measure_name FROM (SELECT a.*,b.project_name FROM tb_clock a LEFT JOIN tb_project b ON a.project_id=b.project_id) c LEFT JOIN tb_measure d ON c.clock_id=d.id) e LEFT JOIN tb_client f ON e.relevant_house=f.client_id) z");
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

            }

        }.toString();
        return  sql;
    }

}
