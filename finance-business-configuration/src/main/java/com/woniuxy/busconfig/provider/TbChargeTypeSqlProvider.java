package com.woniuxy.busconfig.provider;

import com.woniuxy.wuye.common.entity.TbChargeType;
import com.woniuxy.wuye.common.entity.TbChargeableItems;
import org.apache.ibatis.jdbc.SQL;

public class TbChargeTypeSqlProvider {

    public String update(TbChargeType tbChargeType) {
        return  new SQL() {
            {
                UPDATE("tb_charge_type");
                if(tbChargeType.getName()!=null){
                    SET("name=#{name}");
                }
                if(tbChargeType.getFather()!=null){
                    SET("father=#{father}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
