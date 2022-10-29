package com.woniuxy.busconfig.service.serviceiml;

import com.woniuxy.busconfig.service.TbMeasureService;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.utils.PageBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.DocFlavor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TbMeasureServiceTest {
    @Autowired
    private TbMeasureService tbMeasureService;
    @Test
    public void getPage(){
        tbMeasureService.getByPage(new TbMeasure(),1).getData().forEach(System.out::println);
    }
    @Test
    public void add(){
        TbMeasure tbMeasure = new TbMeasure();
        tbMeasure.setMeasureName("bbb");
        tbMeasure.setMeasureNum("88888");
        tbMeasure.setMeasureType("aaa");
        tbMeasure.setLastRead(String.valueOf(LocalDateTime.now()));
        tbMeasure.setMachineType("jjj");
        tbMeasure.setMoneyFrom("uuuu");
        tbMeasure.setMagnification("ggggg");
        tbMeasure.setSituation("y");
        tbMeasure.setMagnification("1");
        tbMeasure.setWastage("1");
        tbMeasure.setProjectName(1);
        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        tbMeasure.setRelevantHouse(list);
        tbMeasureService.save(tbMeasure);
    }

    @Test
    public void testgetByPage(){
        PageBean<TbMeasure> pageBean= tbMeasureService.getByPage(new TbMeasure(),1);
        List<TbMeasure> list =pageBean.getData();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1;j <list.size();j++) {
                if(list.get(i).getId()==list.get(j).getId()){
                    list.get(i).setAllName(list.get(i).getAllName()+","+list.get(j).getAllName());
                    list.remove(j);
                    j--;
                }

            }
        }
    }
}
