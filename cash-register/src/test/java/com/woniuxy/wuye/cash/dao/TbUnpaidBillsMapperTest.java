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

    @Test
    public void testAdd() {
        String s = "1";
        TbClient t = new TbClient();
        t.setClientId(1);
        tbUnpaidBillsMapper.add(new TbUnpaidBills().builder()
//                .id(1)

                .num(s)
                .houseName(s)
                .projectName(s)
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
    @Test
    public void testDelete(){
        tbUnpaidBillsMapper.delete(2);
    }
    @Test
    public void testGetByCondition() {
        ConditionVo conditionVo=new ConditionVo();
//        conditionVo.setProjectName("1");
//        conditionVo.setClientName("吕");
//        conditionVo.setHouseName("1");
//        conditionVo.setFeesItem("项");
//        conditionVo.setStartTime("2019-10-10");
//        conditionVo.setEndTime("2019-11-11");
//        conditionVo.setShouldGetTimeStart("2022-11-01");
//        conditionVo.setShouldGetTimeEnd("2022-11-09");
        System.out.println(tbUnpaidBillsMapper.getByCondition(conditionVo).get(0));

    }
    @Test
    public void testGetById() {
        System.out.println(new Date().toString());
        tbUnpaidBillsMapper.getById(2);
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyymmddHHMMss")));
    }
}
