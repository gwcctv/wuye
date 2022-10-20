package com.woniuxy.busconfig.mapper;

import com.woniuxy.wuye.common.entity.TbDocumentConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TbDocumentConfigurationMapperTest {
    @Autowired
  private   TbDocumentConfigurationMapper tbDocumentConfigurationMapper;
    @Test
    public void getByCondition(){
        TbDocumentConfiguration tbDocumentConfiguration =new TbDocumentConfiguration();
       // tbDocumentConfiguration.setProjectName("XD6r");
        tbDocumentConfiguration.setReceivingUnit("西北大学");
        tbDocumentConfigurationMapper.getTbDocumentConfiguration(tbDocumentConfiguration).forEach(System.out::println);

    }
}
