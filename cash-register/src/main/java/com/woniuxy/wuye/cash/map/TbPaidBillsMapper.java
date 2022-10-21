package com.woniuxy.wuye.cash.map;

import com.woniuxy.wuye.cash.map.provider.TbPaidBillsProvider;
import com.woniuxy.wuye.common.entity.TbDepositedFees;
import com.woniuxy.wuye.common.entity.TbPaidBills;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Description:    收款单表操作
 * @Author: baobo
 * @Date: 2022/10/19
 **/
public interface TbPaidBillsMapper {
    //增
    @Insert("insert into tb_paid_bills(num,house_name,house_owner,should_fees,relief_fees,not_fees,late_fees,relief_late_fees,offset_fees,advice_sum_fees,is_offset,is_wipe_zero,real_sum_fees,get_fees_style,fees_account,pay_user,accept_user,accept_time,accept_num,invoice_number,note,fees_items,pay_status,is_delete) " +
            "values(#{num},#{houseName},#{houseOwner.clientId},#{shouldFees},#{reliefFees},#{notFees},#{lateFees},#{reliefLateFees},#{offsetFees},#{adviceSumFees},#{isOffset},#{isWipeZero},#{realSumFees},#{getFeesStyle},#{feesAccount},#{payUser},#{acceptUser},#{acceptTime},#{acceptNum},#{invoiceNumber},#{note},#{feesItems},#{payStatus},#{isDelete})")
    int add(TbPaidBills tbPaidBills);
    //删

    /**
     * 根据id逻辑删除收款单，点击取消后
     * @param id
     */
    @Update("update tb_paid_bills set is_delete=1 where id=#{id}")
    void delete(Integer id);
    //改
    @Update("update tb_paid_bills set pay_status=#{payStatus} where id=#{id}")
    void updatePayStatus(Integer id,String payStatus);
    //查
    /**
     * 根据id查找收款单
     * @param id
     */
    @Select("select * from tb_paid_bills where id=#{id} and is_delete=0")
    TbPaidBills getById(Integer id);

    /**
     * 多条件查询收款单
     * @param tbPaidBills
     * @return
     */
    @SelectProvider(value = TbPaidBillsProvider.class,method = "getByCondition")
    List<TbPaidBills> getByCondition(TbPaidBills tbPaidBills);
}
