package com.woniuxy.batchservice.automake;

import com.woniuxy.batchservice.feign.FinanceBusinessConfiguration;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.entity.TbCycle;
import com.woniuxy.wuye.common.entity.TbUnpaidBills;
import com.woniuxy.wuye.common.entity.vo.TbFeesStandardConfigurationVo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("automake")
public class Automake {
    @Autowired
    AutoMakeUtils autoMakeUtils;

    @Autowired
    FinanceBusinessConfiguration financeBusinessConfiguration;
    public void test(){
        List<TbCycle> tbCycles=autoMakeUtils.getReduceByList();
        if(tbCycles.size()==0||tbCycles==null){
            return;
        }
        TbCycle tbCycle=new TbCycle();
        for(int i=0;i<tbCycles.size();i++){
            tbCycle=tbCycles.get(i);
            TbUnpaidBills tbUnpaidBills=new TbUnpaidBills();
            String houseName=tbCycle.getProjectName()+"/"+tbCycle.getBuildingNumber()+"/"+tbCycle.getUnit()+"/"+tbCycle.getLayer()+"/"+tbCycle.getHouseNumber();
            //房子全称 项目名/楼号/单元/楼层/门号
            tbUnpaidBills.setHouseName(houseName);
            //账单开始时间
            tbUnpaidBills.setBillStartTime(LocalDate.now().toString());
            //账单截至时间
            tbUnpaidBills.setBillEndTime(LocalDate.now().plusMonths(1l).toString());
            //收费项目名称
            tbUnpaidBills.setFeesItem(tbCycle.getItemName());
            //客户id
            tbUnpaidBills.setHouseOwner(new TbClient().builder().clientId(tbCycle.getClientId()).build());

            financeBusinessConfiguration.getByPage(null);

        }

    }
}
