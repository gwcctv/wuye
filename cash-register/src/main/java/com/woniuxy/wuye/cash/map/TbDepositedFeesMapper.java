package com.woniuxy.wuye.cash.map;

import com.woniuxy.wuye.cash.map.provider.TbDepositedFeesProvider;
import com.woniuxy.wuye.common.entity.TbDepositedFees;
import org.apache.ibatis.annotations.*;

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
            "deposited_user," +
            "deposited_total," +
            "already_offset_fees," +
            "already_refund_fees," +
            "remainder_deposited," +
            "recent_deposited_time," +
            "recent_offset_time" +
            ") " +
            "values(" +
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
     * 多条件查询
     * @param tbDepositedFees
     * @return
     */
    @SelectProvider(value = TbDepositedFeesProvider.class,method = "getByCondition")
    TbDepositedFees getByCondition(TbDepositedFees tbDepositedFees);

}
