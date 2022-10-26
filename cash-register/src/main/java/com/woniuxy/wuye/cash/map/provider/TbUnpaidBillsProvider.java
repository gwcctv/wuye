package com.woniuxy.wuye.cash.map.provider;

import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.common.entity.TbUnpaidBills;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:    未收账单
 * @Author: baobo
 * @Date: 2022/10/20
 **/
public class TbUnpaidBillsProvider {
    public String updateByCondition(TbUnpaidBills tbUnpaidBills){
        return new SQL(){{
            UPDATE("tb_unpaid_bills");
            if(tbUnpaidBills.getRelief()!=null&&tbUnpaidBills.getRelief()!=""){
                SET("relief=#{relief}");
            }
            if(tbUnpaidBills.getOffset()!=null&&tbUnpaidBills.getOffset()!=""){
                SET("offset=#{offset}");
            }
            if(tbUnpaidBills.getNotReceived()!=null&&tbUnpaidBills.getNotReceived()!=""){
                SET("not_received=#{notReceived}");
            }
            if(tbUnpaidBills.getLateFees()!=null&&tbUnpaidBills.getLateFees()!=""){
                SET("late_fees=#{lateFees}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }
    public String getByCondition(ConditionVo conditionVo){
//            @Select("select * from tb_unpaid_bills where is_delete=0 and status=0")
        return new SQL(){{

            SELECT("tb_unpaid_bills.*,tb_client.client_name");
            FROM("tb_unpaid_bills,tb_client");
            WHERE("is_delete=0 and status=0 AND house_owner=client_id");
            if(conditionVo.getProjectName()!=null&&conditionVo.getProjectName()!=""){
                WHERE("project_name like concat('%',#{projectName},'%')");
            }if(conditionVo.getClientName()!=null&&conditionVo.getClientName()!=""){
                WHERE("client_name like concat('%',#{clientName},'%')");
            }if(conditionVo.getHouseName()!=null&&conditionVo.getHouseName()!=""){
                WHERE("house_name like concat('%',#{houseName},'%')");
            }if(conditionVo.getFeesItem()!=null&&conditionVo.getFeesItem()!=""){
                WHERE("fees_item like concat('%',#{feesItem},'%')");
            }if(conditionVo.getStartTime()!=null&&conditionVo.getStartTime()!=""){
                WHERE("bill_start_time >= #{startTime}");
            }if(conditionVo.getEndTime()!=null&&conditionVo.getEndTime()!=""){
                WHERE("bill_end_time <= #{endTime}");
            }if(conditionVo.getShouldGetTimeStart()!=null&&conditionVo.getShouldGetTimeStart()!=""){
                WHERE("should_received_time >= #{shouldGetTimeStart}");
            }if(conditionVo.getShouldGetTimeEnd()!=null&&conditionVo.getShouldGetTimeEnd()!=""){
                WHERE("should_received_time <= #{shouldGetTimeEnd}");
            }
        }}.toString();

    }
}
