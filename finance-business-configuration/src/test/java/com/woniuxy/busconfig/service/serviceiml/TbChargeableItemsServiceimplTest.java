package com.woniuxy.busconfig.service.serviceiml;

import com.woniuxy.busconfig.service.TbChargeableItemsService;
import com.woniuxy.wuye.common.entity.TbChargeableItems;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TbChargeableItemsServiceimplTest {
    @Autowired
    TbChargeableItemsService tbChargeableItemsService;
    @Test
    public void getByPage(){
        TbChargeableItems tbChargeableItems = new TbChargeableItems();
        tbChargeableItemsService.getByPage(tbChargeableItems,1).getData().forEach(System.out::println);
    }
}
