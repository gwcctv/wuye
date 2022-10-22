package com.woniuxy.wuye.cash.map;

import com.woniuxy.wuye.cash.map.provider.TbUnpaidBillsProvider;
import com.woniuxy.wuye.common.entity.TbDepositedFees;
import com.woniuxy.wuye.common.entity.TbUnpaidBills;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:    未支付账单操作
 * @Author: baobo
 * @Date: 2022/10/19
 **/

public interface TbUnpaidBillsMapper {
    /**
     * 新增未支付单
     * @param tbDepositedFees
     * @return
     */
    //增
    @Insert("insert into tb_unpaid_bills(num,house_name,house_owner,fees_item,fees_standard,bill_start_time,bill_end_time,number,price,received,relief,offset,not_received,late_fees,late_fees_relief,should_received_time,status,tb_paid_bills_id,is_delete) " +
            "values(#{num},#{houseName},#{houseOwner},#{feesItem},#{feesStandard},#{billStartTime},#{billEndTime},#{number},#{price},#{received},#{relief},#{offset},#{notReceived},#{lateFees},#{lateFeesRelief},#{shouldReceivedTime},#{status},#{tbPaidBillsId},#{isDelete})")
    int add(TbDepositedFees tbDepositedFees);
    //删

    /**
     * 根据id逻辑删除未收款单
     * @param id
     */
    @Update("update tb_unpaid_bills set is_delete=1 where id=#{id}")
    void delete(Integer id);
    //改

    /**
     *根据id修改为收款单的状态
     * @param id
     * @param status
     */
    @Update("update tb_unpaid_bills set status=#{status} where id=#{id}")
    void update(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * 条件更新未支付账单数据
     * @param tbUnpaidBills
     */
    @UpdateProvider(value = TbUnpaidBillsProvider.class,method = "updateByCondition")
    void updateByCondition(TbUnpaidBills tbUnpaidBills);

    /**
     * 查询所有未支付账单
     * @return
     */
    @SelectProvider(value = TbUnpaidBillsProvider.class,method ="getByCondition")
    List<TbUnpaidBills> getByCondition(TbUnpaidBills tbUnpaidBills);

    /**
     * 根据id查询未支付账单
     * @param id
     */
    @Select("select * from tb_unpaid_bills where is_delete=0")
    TbUnpaidBills getById(Integer id);
}
