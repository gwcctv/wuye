package com.woniuxy.busconfig.mapper;

import com.woniuxy.wuye.common.entity.TbReceiveMoneyWay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TbReceiveMoneyWayMapperTest {
    @Autowired
    TbReceiveMoneyWayMapper tbReceiveMoneyWayMapper;

    @Test
    public  void getByCondition(){
        TbReceiveMoneyWay tbReceiveMoneyWay=new TbReceiveMoneyWay();
        tbReceiveMoneyWay.setAccount("罗绍齐");
       List<TbReceiveMoneyWay> tbReceiveMoneyWays= tbReceiveMoneyWayMapper.getByCondition(tbReceiveMoneyWay);
        System.out.println("111");
    }
}
