package com.woniuxy.busconfig.provider;

import com.woniuxy.wuye.common.entity.TbCheckReduce;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyAccount;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
@Slf4j
public class TbReceiveMoneyAccountMapperProvider {
    public String selectByCondition(TbReceiveMoneyAccount tbReceiveMoneyAccount){
        String sql=new SQL(){
            {
                SELECT("*");
                FROM("(SELECT c.*,d.project_name FROM (SELECT * FROM tb_receive_money_account a LEFT JOIN tb_receive_money_account_project_middle b ON a.id=b.account_id) c LEFT JOIN tb_project d ON c.project_id=d.project_id) z");
                if (tbReceiveMoneyAccount.getAccount() != null && !tbReceiveMoneyAccount.getAccount().equals("")) {
                    WHERE("account=#{account}");
                }
                if (tbReceiveMoneyAccount.getBankNum() != null && !tbReceiveMoneyAccount.getBankNum().equals("")) {
                    WHERE("bank_num=#{bankNum}");
                }
                if (tbReceiveMoneyAccount.getProjectName() != null && !tbReceiveMoneyAccount.getProjectName().equals("")) {
                    WHERE("project_name=#{projectName}");
                }
            }

        }.toString();
        return  sql;
    }
}
