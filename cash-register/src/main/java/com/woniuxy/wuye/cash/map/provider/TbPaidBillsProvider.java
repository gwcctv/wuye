package com.woniuxy.wuye.cash.map.provider;

import com.woniuxy.wuye.common.entity.TbPaidBills;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:    收款单
 * @Author: baobo
 * @Date: 2022/10/20
 **/
public class TbPaidBillsProvider {
    /**
     * 关联客户表多条件查询
     * @param tbPaidBills
     * @return
     */
    public String getByCondition(TbPaidBills tbPaidBills){
        return new SQL(){{
            SELECT("*");
            FROM("tb_paid_bills");
            if(tbPaidBills.getHouseName()!=null){
                WHERE("house_name=#{houseName}");
                //TODO
            }
            WHERE("is_delete=0");
        }}.toString();
    }
}
