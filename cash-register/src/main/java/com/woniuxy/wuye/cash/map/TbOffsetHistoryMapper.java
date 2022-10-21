package com.woniuxy.wuye.cash.map;

import com.woniuxy.wuye.common.entity.TbDepositedFees;
import com.woniuxy.wuye.common.entity.TbOffsetHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Description:    操作冲抵历史记录表
 * @Author: baobo
 * @Date: 2022/10/20
 **/
public interface TbOffsetHistoryMapper {
    //增

    /**
     * 新增冲抵历史记录
     * @param tbOffsetHistory
     * @return
     */
    @Insert("inset into tb_offset_history(offset_number,status,tb_paid_bills_id,offset_fees,offset_time,is_delete) " +
            "values(#{offsetNumber},#{status},#{tbPaidBillsId},#{offsetFees},#{offsetTime},#{isDelete})")
    int add(TbOffsetHistory tbOffsetHistory);
    //删

    /**
     * 根据id逻辑删除冲抵记录
     * 0表示不删除1表示删除
     * @param id
     */
    @Update("update tb_offset_history set is_delete=1 where id=#{id}")
    void isDelete(Integer id,Integer isDelete);
    //改

    /**
     * 根据id改变冲抵记录的状态
     * 状态标识：正常0，冻结1，已失效2，已使用3
     * @param id
     * @param status
     */
    @Update("update tb_offset_history set status=#{status} where id=#{id}")
    void updateStatus(Integer id,String status);
    //查

    /**
     * 根据预存金额表id查询出冲抵记录
     * @param tbDepositedFeesId
     * @return
     */
    @Select("select * from tb_offset_history where tb_deposited_fees_id=#{tbDepositedFeesId}")
    List<TbOffsetHistory> getByTbDepositedFeesId(Integer tbDepositedFeesId);
}
