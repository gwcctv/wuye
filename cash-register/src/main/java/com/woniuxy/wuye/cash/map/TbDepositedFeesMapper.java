package com.woniuxy.wuye.cash.map;

import com.woniuxy.wuye.cash.map.provider.TbDepositedFeesProvider;
import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.entity.TbDepositedFees;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:    预存金额总表
 * @Author: baobo
 * @Date: 2022/10/19
 **/
public interface TbDepositedFeesMapper {
    /**
     * 新增费用预存总表
     * @param tbDepositedFees
     * @return
     */
    @Insert("insert into tb_deposited_fees(" +
            "project_id," +
            "deposited_user," +
            "deposited_total," +
            "already_offset_fees," +
            "already_refund_fees," +
            "remainder_deposited," +
            "recent_deposited_time," +
            "recent_offset_time" +
            ") " +
            "values(" +
            "#{project.projectId},"+
            "#{depositedUser.clientId}," +
            "#{depositedTotal}," +
            "#{alreadyOffsetFees}," +
            "#{alreadyRefundFees}," +
            "#{remainderDeposited}," +
            "#{recentDepositedTime}," +
            "#{recentOffsetTime}) ")
    int add(TbDepositedFees tbDepositedFees);
    //删

    /**
     * 根据id逻辑删除
     * @param id
     */
    @Update("update tb_deposited_fees set is_delete=1 where id=#{id}")
    void delete(Integer id);
    //改

    /**
     * 根据id条件修改部分不为空的字段
     * 可修改字段为
     * deposited_total          总金额
     * already_offset_fees      已抵扣金额
     * already_refund_fees      已退款金额
     * remainder_deposited      剩余金额
     * recent_deposited_time    最新预存时间
     * recent_offset_time       最新冲抵时间
     * @param tbDepositedFees
     */
    @UpdateProvider(value = TbDepositedFeesProvider.class,method = "updateByCondition")
    void updateByCondition(TbDepositedFees tbDepositedFees );
    //查

    /**
     * 根据id查单个预存列表
     * @param id
     * @return
     */
    @Select("select * from tb_deposited_fees where id=#{id} and is_delete=0")
    TbDepositedFees getById(Integer id);
    /**
     * 根据id查单个预存列表
     * @param id
     * @return
     */
    @Select("select * from tb_deposited_fees where id=#{id} and project_name=#{pid} and is_delete=0")
    TbDepositedFees getByUidAndPid(Integer id,String pid);

    /**
     * 多条件查询
     * @param   conditionVo
     * @return
     */


    @SelectProvider(value = TbDepositedFeesProvider.class,method = "getByCondition")
    @Results(value = {

            @Result(property = "id",column = "id"),
            @Result(property = "depositedUser.clientId" ,column = "client_id"),
            @Result(property = "depositedUser.clientName" ,column = "client_name"),
            @Result(property = "project.projectId" ,column = "project_id"),
            @Result(property = "project.projectName" ,column = "project_name"),

    })
    List<TbDepositedFees> getByCondition(ConditionVo conditionVo);
//    @Results(id="depositedUserMap",
//    value = {
//            @Result(property = "clientId",column = "client_id")
//    })
//    TbClient getTbClient();
}
