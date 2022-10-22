package com.woniuxy.wuye.cash.dao;

import com.woniuxy.wuye.cash.map.TbDepositedFeesMapper;
import com.woniuxy.wuye.cash.map.TbUnpaidBillsMapper;
import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.entity.TbDepositedFees;
import com.woniuxy.wuye.common.entity.TbProject;
import com.woniuxy.wuye.common.entity.TbUnpaidBills;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/22
 **/
@SpringBootTest
public class TbUnpaidBillsMapperTest {
    @Autowired(required = false)
    private  TbUnpaidBillsMapper tbUnpaidBillsMapper;
    @Test
    public void testAdd(){
        String s="1";
        TbClient t=new TbClient();
        t.setClientId(1);
        tbUnpaidBillsMapper.add(new TbUnpaidBills().builder()
//                .id(1)

                .num(s)
                .houseName(s)
                .houseOwner(t)
                .feesItem(s)
                .feesStandard(s)
                .billStartTime(s)
                .billEndTime(s)
                .number(s)
                .price(s)
                .received(s)
                .relief(s)
                .offset(s)
                .notReceived(s)
                .lateFees(s)
                .lateFeesRelief(s)
                .isDelete(0)
                .shouldReceivedTime(s)
                .status(0)
                .tbPaidBillsId(1)
                .build());
    }

}
