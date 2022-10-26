package com.woniuxy.wuye.cash.map.provider;

import com.woniuxy.wuye.cash.utils.ConditionVo;
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
     * @param
     * @return
     */
    public String getByCondition(ConditionVo conditionVo){
//        conditionVo.setProjectName("1");
//        conditionVo.setClientName("吕");
//        conditionVo.setHouseName("1");
//        conditionVo.setFeesItem("项");
//        conditionVo.setNum("2");
//        conditionVo.setStyle("1");
//        conditionVo.setStatus("1");
//        conditionVo.setStartTime("2019-10-10");
//        conditionVo.setEndTime("2019-11-11");
        return new SQL(){{
            SELECT("tb_paid_bills.*,tb_client.client_name");
            FROM("tb_paid_bills,tb_client");
            /*if(conditionVo.getProjectName()!=null){
                WHERE("project_name like concat('%',#{projectName},'%')");
            }*/if(conditionVo.getClientName()!=null&&conditionVo.getClientName()!=""){
                WHERE("client_name  like concat('%',#{clientName},'%')");
            }if(conditionVo.getHouseName()!=null&&conditionVo.getHouseName()!=""){
                WHERE("house_name like concat('%',#{houseName},'%')");
            }if(conditionVo.getFeesItem()!=null&&conditionVo.getFeesItem()!=""){
                WHERE("fees_items=#{feesItem}");
            }if(conditionVo.getNum()!=null&&conditionVo.getNum()!=""){
                WHERE("num  like concat('%',#{num},'%')");
            }if(conditionVo.getAcceptUser()!=null&&conditionVo.getAcceptUser()!=""){
                WHERE("accept_user  like concat('%',#{acceptUser},'%')");
            }if(conditionVo.getStyle()!=null&&conditionVo.getStyle()!=""){
                WHERE("get_fees_style=#{style}");
            }if(conditionVo.getStatus()!=null&&conditionVo.getStatus()!=""){
                WHERE("pay_status=#{status}");
            }if(conditionVo.getStartTime()!=null&&conditionVo.getStartTime()!=""){
                WHERE("accept_time >= #{startTime}");
            }if(conditionVo.getEndTime()!=null&&conditionVo.getEndTime()!=""){
                WHERE("accept_time <= #{endTime}");
            }
            WHERE("is_delete=0 AND house_owner=client_id");
        }}.toString();
    }
}
