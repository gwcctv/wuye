package com.woniuxy.busconfig.mapper;

import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FeesStandardConfigurationMapperTest {
   @Autowired
  private  TbFeesStandardConfigurationMapper tbFeesStandardConfigurationMapper;
   @Test
   public  void getByCondition(){
       TbFeesStandardConfiguration tbFeesStandardConfiguration=new TbFeesStandardConfiguration();
       //tbFeesStandardConfiguration.setProjectName("U5U");
       tbFeesStandardConfiguration.setStandardName("覃哲瀚");
       tbFeesStandardConfigurationMapper.getTbFeesStandardConfiguration(tbFeesStandardConfiguration).forEach(System.out::println);
   }

}
