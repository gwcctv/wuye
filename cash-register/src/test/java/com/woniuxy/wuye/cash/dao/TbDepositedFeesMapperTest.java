package com.woniuxy.wuye.cash.dao;

import com.woniuxy.wuye.cash.map.TbDepositedFeesMapper;
import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.entity.TbDepositedFees;
import com.woniuxy.wuye.common.entity.TbProject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/22
 **/
@SpringBootTest
public class TbDepositedFeesMapperTest {
    @Autowired
    private TbDepositedFeesMapper tbDepositedFeesMapper;
    @Test
    public  void testAdd(){
        String s="1";
        TbProject p=new TbProject();
        p.setProjectId(1);
        TbClient t=new TbClient();
        t.setClientId(1);
        tbDepositedFeesMapper.add(new TbDepositedFees().builder().id(1).
                project(p).
                depositedUser(t).
                depositedTotal(s).
                alreadyRefundFees(s).
                alreadyOffsetFees(s).
                remainderDeposited(s).
                recentDepositedTime(s).
                recentOffsetTime(s).
                houseNames(s).
                isDelete(1).build());
    }
    @Test
    public  void testUpdateByCondition(){
        String s="7";
        TbProject p=new TbProject();
        p.setProjectId(7);
        TbClient t=new TbClient();
        t.setClientId(7);
            tbDepositedFeesMapper.updateByCondition(new TbDepositedFees().builder().id(1).
                    project(p).
                    depositedUser(t).
                    depositedTotal(s).
                    alreadyRefundFees(s).
                    alreadyOffsetFees(s).
                    remainderDeposited(s).
                    recentDepositedTime(s).
                    recentOffsetTime(s).
                    houseNames(s).
                    isDelete(1).build());
    }
    @Test
    public  void testGetById(){
        System.out.println(tbDepositedFeesMapper.getById(1));
    }
    @Test
    public  void testGetByCondition(){
        ConditionVo conditionVo=new ConditionVo();
        conditionVo.setProjectName("X");
        conditionVo.setClientName("吕");
        conditionVo.setStartTime("2020-01-01 14:59:10");
//        conditionVo.setEndTime("1970-01-16 14:59:10");
        System.out.println(tbDepositedFeesMapper.getByCondition(conditionVo));
    }
}
