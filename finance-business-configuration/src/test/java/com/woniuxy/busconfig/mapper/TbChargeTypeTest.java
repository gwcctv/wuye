package com.woniuxy.busconfig.mapper;

import com.woniuxy.wuye.common.entity.TbChargeType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class TbChargeTypeTest {
@Autowired
private TbChargeTypeMapper tbChargeTypeMapper;
    @Test
    void getChargeType() {

       String name ="驰";
        List<TbChargeType> chargeType = tbChargeTypeMapper.getChargeType(name);
        chargeType.forEach(System.out::println);

    }

}
