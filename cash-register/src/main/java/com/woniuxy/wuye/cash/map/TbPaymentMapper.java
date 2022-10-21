package com.woniuxy.wuye.cash.map;

import com.woniuxy.wuye.common.entity.TbDepositedFees;
import com.woniuxy.wuye.common.entity.TbPayment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Description:    付款表操作
 * @Author: baobo
 * @Date: 2022/10/19
 **/
public interface TbPaymentMapper {
    //增
    @Insert("insert into tb_payment(payment_numer,payment_fees,payment_style,payment_account,accept_user_id,accept_bank,accept_account,fees_item,start_time,end_time,should_pay,real_pay,remainder,pay_status,create_time,is_delete) " +
            "values(#{paymentNumer},#{paymentFees},#{paymentStyle},#{paymentAccount},#{acceptUserId.id},#{acceptBank},#{acceptAccount},#{feesItem},#{startTime},#{endTime},#{},#{shouldPay},#{realPay},#{remainder},#{payStatus},#{createTime},#{isDelete})")
    int add(TbPayment tbPayment);
    //删

    /**
     * 根据id逻辑删除付款单
     * @param id
     */
    @Update("update tb_payment set is_delete=1 where id=#{id}")
    void delete(Integer id);
    //改

    /**
     * 根据id改变付款单的支付状态
     * @param id
     * @param payStatus
     */
    @Update("update tb_payment set pay_status=#{payStatus} where id=#{id}")
    void update(Integer id,String payStatus);
    //查

    /**
     * 多条件查询付款单
     * @param tbPayment
     * @return
     */
    @SelectProvider()
    List<TbPayment> getById(TbPayment tbPayment);
}
