package com.woniuxy.wuye.cash.map.provider;

import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.common.entity.TbDepositedFees;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:    预存单
 * @Author: baobo
 * @Date: 2022/10/20
 **/
public class TbDepositedFeesProvider {

    public String updateByCondition(TbDepositedFees tbDepositedFees ){
        return new SQL(){
            {
               UPDATE("tb_deposited_fees");
               if(tbDepositedFees.getDepositedTotal()!=null&&tbDepositedFees.getDepositedTotal()!=""){
                 SET("deposited_total=#{depositedTotal}");
               }
                if(tbDepositedFees.getAlreadyOffsetFees()!=null&&tbDepositedFees.getAlreadyOffsetFees()!=""){
                    SET("already_offset_fees=#{alreadyOffsetFees}");
                }
                if(tbDepositedFees.getAlreadyRefundFees()!=null&&tbDepositedFees.getAlreadyRefundFees()!=""){
                    SET("already_refund_fees=#{alreadyRefundFees}");
                }
                if(tbDepositedFees.getRemainderDeposited()!=null&&tbDepositedFees.getRemainderDeposited()!=""){
                    SET("remainder_deposited=#{remainderDeposited}");
                }
                if(tbDepositedFees.getRecentDepositedTime()!=null&&tbDepositedFees.getRecentDepositedTime()!=""){
                    SET("recent_deposited_time=#{recentDepositedTime}");
                }
                if(tbDepositedFees.getRecentOffsetTime()!=null&&tbDepositedFees.getRecentOffsetTime()!=""){
                    SET("recent_offset_time=#{recentOffsetTime}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
    public String getByCondition(ConditionVo conditionVo){
        return new SQL(){{
            SELECT("tb_deposited_fees.*,tb_client.client_name,tb_client.client_id,tb_project.project_name");
            FROM("tb_deposited_fees,tb_client,tb_project");
            WHERE("tb_client.client_id=tb_deposited_fees.deposited_user AND tb_project.project_id=tb_deposited_fees.project_id");
            if(conditionVo.getProjectName()!=null&&conditionVo.getProjectName()!=""){
                WHERE("project_name like concat('%',#{projectName},'%')");
            }
            if(conditionVo.getClientName()!=null&&conditionVo.getClientName()!=""){
                WHERE("client_name like concat('%',#{clientName},'%')");
            }
            if(conditionVo.getStartTime()!=null&&conditionVo.getStartTime()!=""){
                WHERE("recent_deposited_time >= #{startTime}");
            }
            if(conditionVo.getEndTime()!=null&&conditionVo.getEndTime()!=""){
                WHERE("recent_deposited_time <= #{endTime}");
            }
        }}.toString();
    }
}
