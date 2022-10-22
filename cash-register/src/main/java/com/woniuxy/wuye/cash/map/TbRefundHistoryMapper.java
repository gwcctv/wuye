package com.woniuxy.wuye.cash.map;

import com.woniuxy.wuye.common.entity.TbDepositedFees;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * @Description:    退款记录表操作
 * @Author: baobo
 * @Date: 2022/10/19
 **/
public interface TbRefundHistoryMapper {
    //增

    /**
     * 新增退款记录
     * @param tbDepositedFees
     * @return
     */
    @Insert("insert into tb_refund_history(refund_number,refund_fees,paid_bills_num,refund_user,refund_time,refund_reason,is_delete) " +
            "values(#{refundNumber},#{refundFees},#{paidBillsNum},#{refundUser},#{refundTime},#{refundReason},#{isDelete})")
    int add(TbDepositedFees tbDepositedFees);
    //删

    /**
     * 根据id逻辑删除退款记录
     * @param id
     */
//    @Update("update tb_refund_history set is_delete=1 where id=#{id}")
//    void delete(Integer id);
    //改
//    void update();
    //查
//    void getById();
}
