package com.woniuxy.batchservice.provider;

import com.woniuxy.wuye.common.entity.TbCycle;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

@Slf4j
public class TbcycleProvider {
    public String selectByCondition(TbCycle tbCycle){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("(SELECT e.*,f.number building_number FROM (SELECT c.*,d.project_name FROM (SELECT a.*,b.project_id,b.building_id,b.unit,b.layer,b.house_number,b.client_id,b.area FROM   (SELECT c.*,i.item_name FROM tb_cycle c LEFT JOIN tb_chargeable_items i ON c.feetype_id=i.id) a LEFT JOIN tb_house b ON a.house_id=b.house_id) c LEFT JOIN tb_project d ON c.project_id=d.project_id) e LEFT JOIN tb_building f ON e.building_id=f.building_id) g");
                if(tbCycle.getProjectName()!=null && !tbCycle.getProjectName().equals("")){
                    WHERE("project_name=#{projectName}");
                }
                if(tbCycle.getItemName()!=null && !tbCycle.getItemName().equals("")){
                    WHERE("item_name=#{itemName}");
                }
                if(tbCycle.getProduceStatus()!=null && !tbCycle.getProduceStatus().equals("")){
                    WHERE("produce_status=#{produceStatus}");
                }
                if(tbCycle.getStartYear()!=null  && !tbCycle.getStartYear().equals("")){
                    WHERE("start_year  <= #{startYear}");
                }   if(tbCycle.getStartMonth()!=null  && !tbCycle.getStartMonth().equals("")){
                WHERE("start_month=#{startMonth}");
            }   if(tbCycle.getStartDay()!=null  && !tbCycle.getStartDay().equals("")){
                WHERE("start_day=#{startDay}");
            }
                if(tbCycle.getEndYear()!=null && !tbCycle.getEndYear().equals("")){
                    WHERE("end_year=#{endYear}");
                }
                if(tbCycle.getEndMonth()!=null && !tbCycle.getEndMonth().equals("")){
                    WHERE("end_month=#{endMonth}");
                }
                if(tbCycle.getEndDay()!=null && !tbCycle.getEndDay().equals("")){
                    WHERE("end_day=#{endDay}");
                }
                if(tbCycle.getProduceName()!=null && !tbCycle.getProduceName().equals("")){
                    WHERE("produce_name=#{produceName}");
                }
                if(tbCycle.getProduceTime()!=null  && !tbCycle.getProduceTime().equals("")){
                    WHERE("produce_time like concat(#{produceTime},'%')");
                }
                if(tbCycle.getFeetypeId()!=null  && tbCycle.getFeetypeId()!=0){
                    WHERE("feetype_Id=#{feetypeId}");
                }
                WHERE("feecycle>0");
            }

        }.toString();
        return  sql;
    }
}
