package com.woniuxy.busconfig.service.serviceiml;

import com.woniuxy.busconfig.service.TbFeesStandardConfigurationService;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TbFeesStandardConfigurationServiceimplTest {
    @Autowired
    private TbFeesStandardConfigurationService tbFeesStandardConfigurationService;
    @Test
    public void add(){
        TbFeesStandardConfiguration tbFeesStandardConfiguration = new TbFeesStandardConfiguration();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        tbFeesStandardConfiguration.setStandardName("小文鹏");
        tbFeesStandardConfiguration.setFeesItem(1);
        tbFeesStandardConfiguration.setStandardNum("8888888");
        tbFeesStandardConfiguration.setBillingMethod("固定金额");
        tbFeesStandardConfiguration.setPrice(new BigDecimal(200));
        tbFeesStandardConfiguration.setSituation("y");
        tbFeesStandardConfiguration.setProjectNameList(integers);
        tbFeesStandardConfigurationService.addTbFeesStandardConfiguration(tbFeesStandardConfiguration);
    }
    @Test
    public void getByPage(){
        List<String> names =new ArrayList<>();
        TbFeesStandardConfiguration tbFeesStandardConfiguration = new TbFeesStandardConfiguration();
       List<TbFeesStandardConfiguration> pageList = tbFeesStandardConfigurationService.getByPage(tbFeesStandardConfiguration, 1).getData();
        System.out.println("---------------");
       System.out.println(pageList.getClass().getName());
        System.out.println("---------------");
//        for (int i = 0; i < pageList.size(); i++) {
//            for (int j = i+1; j < pageList.size(); j++) {
//                if(pageList.get(i).getId()==pageList.get(j).getId()){
//                    pageList.get(i).setProjectName(pageList.get(i).getProjectName()+","+pageList.get(j).getProjectName());
//               pageList.remove(j);
//               j--;
//                }
//            }
//        }
//pageList.forEach(System.out::println);
    }
    @Test
    public void delete(){
        Integer id =12;
        tbFeesStandardConfigurationService.deleteTbFeesStandardConfiguration(12);

    }
}
