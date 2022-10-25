package com.woniuxy.wuye.cash.dao;

import com.woniuxy.wuye.cash.map.TbDepositedFeesMapper;
import com.woniuxy.wuye.cash.map.TbPaidBillsMapper;
import com.woniuxy.wuye.cash.map.TbUnpaidBillsMapper;
import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.cash.utils.WoNiuTimeUtil;
import com.woniuxy.wuye.common.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/22
 **/
@SpringBootTest
public class TbUnpaidBillsMapperTest {
    @Autowired(required = false)
    private TbUnpaidBillsMapper tbUnpaidBillsMapper;
    @Autowired(required = false)
    private TbPaidBillsMapper tbPaidBillsMapper;

    @Test
    public void testAdd() {
        String s = "3";
        TbClient t = new TbClient();
        t.setClientId(2);
        tbPaidBillsMapper.add(new TbPaidBills().builder()
//                .id(1)

                .num(s)
                .houseName(s)
//                .projectName(s)
                .houseOwner(t)
                .shouldFees(s)
                .reliefFees(s)
                .notFees(s)
                .lateFees(s)
                .reliefLateFees(s)
                .offsetFees(s)
                .adviceSumFees(s)
                .isOffset(s)
                .isWipeZero(s)
                .wipeZeroFees(s)
                .realSumFees(s)
                .getFeesStyle(s)
                .feesAccount(s)
                .payUser(s)
                .acceptUser(s)
                .acceptTime(s)
                .acceptNum(s)
                .acceptTime(WoNiuTimeUtil.getNowTime())
                .invoiceNumber(s)
                .note(s)
                .feesItems(s)
                .payStatus(s)
                .build());
    }

    @Test
    public void testDelete() {
        tbPaidBillsMapper.delete(2);
    }

    @Test
    public void testGetById() {
        System.out.println(new Date().toString());
        System.out.println(tbPaidBillsMapper.getById(1));
    }

    @Test
    public void testGetByCondition() {
        ConditionVo conditionVo = new ConditionVo();
//        conditionVo.setProjectName("1");
        conditionVo.setClientName("4");
        conditionVo.setHouseName("3");
        conditionVo.setFeesItem("3");
        conditionVo.setNum("3");
        conditionVo.setStyle("3");
        conditionVo.setStartTime("2019-10-10");
        conditionVo.setEndTime("2025-11-11");
//        conditionVo.setStatus("1");
        System.out.println(tbPaidBillsMapper.getByCondition(conditionVo).get(0));

    }


    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyymmddHHMMss")));
    }
}
