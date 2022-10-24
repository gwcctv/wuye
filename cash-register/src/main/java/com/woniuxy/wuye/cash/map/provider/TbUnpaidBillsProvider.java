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
            if(tbUnpaidBills.getRelief()!=null){
                SET("relief=#{relief}");
            }
            if(tbUnpaidBills.getOffset()!=null){
                SET("offset=#{offset}");
            }
            if(tbUnpaidBills.getNotReceived()!=null){
                SET("not_received=#{notReceived}");
            }
            if(tbUnpaidBills.getLateFees()!=null){
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
            if(conditionVo.getProjectName()!=null){
                WHERE("project_name like concat('%',#{projectName},'%')");
            }if(conditionVo.getClientName()!=null){
                WHERE("client_name like concat('%',#{clientName},'%')");
            }if(conditionVo.getHouseName()!=null){
                WHERE("house_name like concat('%',#{houseName},'%')");
            }if(conditionVo.getFeesItem()!=null){
                WHERE("fees_item like concat('%',#{feesItem},'%')");
            }if(conditionVo.getStartTime()!=null){
                WHERE("bill_start_time >= #{startTime}");
            }if(conditionVo.getEndTime()!=null){
                WHERE("bill_end_time <= #{endTime}");
            }if(conditionVo.getShouldGetTimeStart()!=null){
                WHERE("should_received_time >= #{shouldGetTimeStart}");
            }if(conditionVo.getShouldGetTimeEnd()!=null){
                WHERE("should_received_time <= #{shouldGetTimeEnd}");
            }
        }}.toString();

    }
}
