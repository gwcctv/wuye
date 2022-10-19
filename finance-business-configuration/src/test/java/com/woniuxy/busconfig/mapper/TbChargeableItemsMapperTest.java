package com.woniuxy.busconfig.mapper;

import com.woniuxy.wuye.common.entity.TbChargeableItems;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TbChargeableItemsMapperTest {
    @Autowired
  private   TbChargeableItemsMapper tbChargeableItemsMapper;
    @Test
    public void getTbChargeableItem(){
        TbChargeableItems tbChargeableItems =new TbChargeableItems();
        tbChargeableItems.setItemName("天");
        List<TbChargeableItems> tbChargeableItemByCondition = tbChargeableItemsMapper.getTbChargeableItemByCondition(tbChargeableItems);
    tbChargeableItemByCondition.forEach(System.out::println);
    }
    @Test
    public void updateTbChargeableItem(){
        TbChargeableItems tbChargeableItems =new TbChargeableItems();
        tbChargeableItems.setItemName("肖文鹏");
        tbChargeableItems.setId(1);
        tbChargeableItemsMapper.updateTbChargeableItem(tbChargeableItems);
    }
    @Test
    public void addTbChargeableItem(){
        TbChargeableItems tbChargeableItems =new TbChargeableItems();
        tbChargeableItems.setFeesQuality("啊哈哈哈");
        tbChargeableItems.setItemName("玄烨");
        tbChargeableItems.setPeriodic("n");
        tbChargeableItems.setRemark("不错");
        tbChargeableItems.setItmeTypeId(1);
        tbChargeableItems.setSituation("状态");
        tbChargeableItemsMapper.addTbChargeableItem(tbChargeableItems);
    }
}
