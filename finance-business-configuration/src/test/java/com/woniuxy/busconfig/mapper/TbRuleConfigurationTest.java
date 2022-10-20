package com.woniuxy.busconfig.mapper;

import com.woniuxy.wuye.common.entity.TbRuleConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TbRuleConfigurationTest {
    @Autowired
    TbRuleConfigurationMapper tbRuleConfigurationMapper;
    @Test
    public void select(){
        TbRuleConfiguration tbRuleConfiguration = new TbRuleConfiguration();
       // tbRuleConfiguration.setProjectName("XD6r");
        tbRuleConfiguration.setRuleName("东南经贸大学");
        tbRuleConfigurationMapper.getTbRuleConfiguration(tbRuleConfiguration).forEach(System.out::println);
    }
}
