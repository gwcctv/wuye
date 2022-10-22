package com.woniuxy.busconfig.service.serviceiml;

import com.woniuxy.busconfig.service.TbRuleConfigurationService;
import com.woniuxy.wuye.common.entity.TbRuleConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TbRuleConfigurationServiceTest {
    @Autowired
    TbRuleConfigurationService tbRuleConfigurationService;
    @Test
    public void add(){
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        TbRuleConfiguration tbRuleConfiguration = new TbRuleConfiguration();
        tbRuleConfiguration.setRuleName("小蜗牛");
        tbRuleConfiguration.setRuleDescription("niupi");
        tbRuleConfiguration.setRuleSituation("y");
        tbRuleConfiguration.setProjectIds(list);
        tbRuleConfigurationService.addTbRuleConfiguration(tbRuleConfiguration);
    }
}
