package com.woniuxy.wuye.cash.map;

import com.woniuxy.wuye.common.entity.TbDepositedFees;
import com.woniuxy.wuye.common.entity.TbDepositedHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Description:    预存记录表操作
 * @Author: baobo
 * @Date: 2022/10/19
 **/
public interface TbDepositedHistoryMapper {
    //增

    /**
     * 新增预存记录
     * @param tbDepositedHistory
     * @return
     */
    @Insert("inset into tb_deposited_history(deposited_user,deposited_fees,time,offset_item,accept_style,accept_fees,accept_account,real_accept_fees,pay_user,accept_user,receipt_number,invoice_number,note,is_delete,tb_deposited_fees_id) " +
            "values(#{depositedUser.clientId},#{depositedFees},#{time},#{offsetItem},#{acceptStyle},#{acceptFees},#{acceptAccount},#{realAcceptFees},#{payUser},#{acceptUser},#{receiptNumber},#{invoiceNumber},#{note},#{isDelete},#{tbDepositedFeesId.id});")
    int add(TbDepositedHistory tbDepositedHistory);
    //删

    /**
     * 逻辑删除
     */
    @Update("update tb_deposited_history set is_delete=1")
    void delete(Integer status);
    //改

    /**
     * 改变预存记录的状态，0表示未删除，1表示已删除，可
     * @param status
     */
    @Update("update tb_deposited_history set is_delete=#{status}")
    void update(Integer status);

    /**
     * 根据预存金额总表的id查预存记录
     * @param tbDepositedFeesId
     */
    @Select("select * from tb_deposited_history where tb_deposited_fees_id=#{tbDepositedFeesId}")
    List<TbDepositedHistory> getByTbDepositedFeesId(Integer tbDepositedFeesId);
}
