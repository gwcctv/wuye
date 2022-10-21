package com.woniuxy.busconfig.service.serviceiml;

import com.woniuxy.busconfig.service.TbMeasureService;
import com.woniuxy.wuye.common.entity.TbMeasure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TbMeasureServiceTest {
    @Autowired
    private TbMeasureService tbMeasureService;
    @Test
    public void getPage(){
        tbMeasureService.getByPage(new TbMeasure(),1).getData().forEach(System.out::println);
    }
}
