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

            SELECT("*");
            FROM("tb_unpaid_bills");
            WHERE("is_delete=0 and status=0");

        }}.toString();

    }
}
