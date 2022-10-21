package com.woniuxy.wuye.cash.map.provider;

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
               if(tbDepositedFees.getDepositedTotal()!=null){
                 SET("deposited_total","#{depositedTotal}");
               }
                if(tbDepositedFees.getAlreadyOffsetFees()!=null){
                    SET("already_offset_fees","#{alreadyOffsetFees}");
                }
                if(tbDepositedFees.getAlreadyRefundFees()!=null){
                    SET("already_refund_fees","#{alreadyRefundFees}");
                }
                if(tbDepositedFees.getRemainderDeposited()!=null){
                    SET("remainder_deposited","#{remainderDeposited}");
                }
                if(tbDepositedFees.getRecentDepositedTime()!=null){
                    SET("recent_deposited_time","#{recentDepositedTime}");
                }
                if(tbDepositedFees.getRecentOffsetTime()!=null){
                    SET("recent_offset_time","#{recentOffsetTime}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
    public String getByCondition(TbDepositedFees tbDepositedFees ){
        return new SQL(){{
            SELECT("*");
            FROM("tb_deposited_fees","tb_client");
            WHERE("tb_deposited_fees.id=tb_client.client_id");
            //TODO
        }}.toString();
    }
}
