package com.woniuxy.batchservice.provider;

import com.woniuxy.wuye.common.entity.TbCheckReduce;
import com.woniuxy.wuye.common.entity.TbCycle;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

@Slf4j
public class TbCheckReduceProvider {
    public String selectByCondition(TbCheckReduce tbCheckReduce){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("(SELECT g.*,h.deduction_name FROM  (SELECT e.*,f.item_name FROM (SELECT c.*,d.project_name FROM  (SELECT a.*,b.project_id FROM tb_check_reduce a LEFT JOIN tb_house b ON a.house_id=b.house_id) c LEFT JOIN tb_project d ON c.project_id=d.project_id) e LEFT JOIN tb_chargeable_items f ON e.feetype_id=f.id) g LEFT JOIN tb_money_deduction h ON g.reduce_type_id=h.id) z");
                if(tbCheckReduce.getProjectName()!=null && !tbCheckReduce.getProjectName().equals("")){
                    WHERE("project_name=#{projectName}");
                }
                if(tbCheckReduce.getItemName()!=null && !tbCheckReduce.getItemName().equals("")){
                    WHERE("item_name=#{itemName}");
                }
                if(tbCheckReduce.getProduceStatus()!=null && !tbCheckReduce.getProduceStatus().equals("")){
                    WHERE("produce_status=#{produceStatus}");
                }
                if(tbCheckReduce.getDeductionName()!=null  && !tbCheckReduce.getDeductionName().equals("")){
                    WHERE("deduction_name=#{deductionName}");
                }   if(tbCheckReduce.getReduceWay()!=null  && !tbCheckReduce.getReduceWay().equals("")){
                WHERE("reduce_way=#{reduceWay}");
            }   if(tbCheckReduce.getNumber()!=null  && !tbCheckReduce.getNumber().equals("")){
                WHERE("number=#{number}");
            }
                if(tbCheckReduce.getProduceName()!=null && !tbCheckReduce.getProduceName().equals("")){
                    WHERE("produce_name=#{produceName}");
                }
                if(tbCheckReduce.getProduceTime()!=null  && !tbCheckReduce.getProduceTime().equals("")){
                    WHERE("produce_time like concat(#{produceTime},'%')");
                }
                if(tbCheckReduce.getHouseId()!=null  && tbCheckReduce.getHouseId()!=0){
                    WHERE("house_id=#{houseId}");
                }
                if(tbCheckReduce.getFeetypeId()!=null  && tbCheckReduce.getFeetypeId()!=0){
                    WHERE("feetype_id=#{feetypeId}");
                }
                if(tbCheckReduce.getJudge()!=null  && !tbCheckReduce.getJudge().equals("")){
                    WHERE("judge=#{judge}");
                }if(tbCheckReduce.getReduceTypeId()!=null&&tbCheckReduce.getReduceTypeId()!=0){
                    WHERE("reduce_type_id=#{reduceTypeId}");
            }
                WHERE("status!=0");
            }

        }.toString();
        return  sql;
    }
}
