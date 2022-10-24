package com.woniuxy.busconfig.provider;

import com.woniuxy.wuye.common.entity.TbReceiveMoneyAccount;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyWay;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
@Slf4j
public class TbReceiveMoneyWayMapperProvider {

    public String selectByCondition(TbReceiveMoneyWay tbReceiveMoneyWay){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("(SELECT a.*,b.account FROM tb_receive_money_way a LEFT JOIN tb_receive_money_account b ON a.receive_money_account_id=b.id) z");
                if (tbReceiveMoneyWay.getWayName() != null && !tbReceiveMoneyWay.getWayName().equals("")) {
                    WHERE("way_name=#{wayName}");
                }
                if (tbReceiveMoneyWay.getType() != null && !tbReceiveMoneyWay.getType().equals("")) {
                    WHERE("type=#{type}");
                }
                if (tbReceiveMoneyWay.getAccount() != null && !tbReceiveMoneyWay.getAccount().equals("")) {
                    WHERE("account=#{account}");
                }
            }

        }.toString();
        return  sql;
    }

}
