package com.woniuxy.batchservice.automake;

import com.woniuxy.batchservice.feign.FinanceBusinessConfiguration;
import com.woniuxy.batchservice.feign.HouseManager;
import com.woniuxy.batchservice.service.TbCheckReduceService;
import com.woniuxy.batchservice.service.TbCycleService;
import com.woniuxy.wuye.common.entity.*;
import com.woniuxy.wuye.common.entity.vo.TbFeesStandardConfigurationVo;

import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("test")
@RestController
public class Automake {
    @Autowired
    AutoMakeUtils autoMakeUtils;

    @Autowired
    FinanceBusinessConfiguration financeBusinessConfiguration;
    @Autowired
    TbCheckReduceService tbCheckReduceService;

    @Autowired
    TbCycleService tbCycleService;
    @Autowired
    HouseManager houseManager;
@RequestMapping("test")
    public void test() {
        List<TbCycle> tbCycles = autoMakeUtils.getReduceByList();
        if (tbCycles.size() == 0 || tbCycles == null) {
            return;
        }
        List<TbUnpaidBills> tbUnpaidBillsList=new ArrayList<>();

        TbCycle tbCycle = new TbCycle();
        for (int i = 0; i < tbCycles.size(); i++) {
            tbCycle = tbCycles.get(i);
            TbUnpaidBills tbUnpaidBills = new TbUnpaidBills();
            String houseName = tbCycle.getProjectName() + "/" + tbCycle.getBuildingNumber() + "/" + tbCycle.getUnit() + "/" + tbCycle.getLayer() + "/" + tbCycle.getHouseNumber();
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
            //获取收费标准的名称
            TbFeesStandardConfiguration feesStandard = financeBusinessConfiguration.getByCondition(new TbFeesStandardConfigurationVo()
                    .builder().tbFeesStandardConfiguration(new TbFeesStandardConfiguration()
                            .builder().feesItem(tbCycle.getFeetypeId()).
                            projectId(tbCycle.getProjectId())
                            .build()).build()).getData().get(0);

            tbUnpaidBills.setFeesStandard(feesStandard.getStandardName());
            //设置删除状态 初始值为0
            tbUnpaidBills.setIsDelete(0);
            //设置滞纳金  初始账单为0
            tbUnpaidBills.setLateFees("0");
            //单价
            tbUnpaidBills.setPrice(feesStandard.getPrice().toString());
            //滞纳金减免
            BigDecimal total = new BigDecimal(0);
            if (tbCycle.getTbCheckReduceListForLateMoney().size() == 0 || tbCycle.getTbCheckReduceListForLateMoney() == null) {
                tbUnpaidBills.setLateFeesRelief("0");
            } else {
                TbCheckReduce tbCheckReduce = new TbCheckReduce();

                for (int j = 0; j < tbCycle.getTbCheckReduceListForLateMoney().size(); j++) {
                    tbCheckReduce = tbCycle.getTbCheckReduceListForLateMoney().get(j);
                    String price = tbCheckReduce.getReducePrice();
                    //0为固定金额 1为固定比例
                    String way = tbCheckReduce.getReduceWay();
                    if (way.equals("0")) {
                        BigDecimal p = new BigDecimal(price);
                        total = total.add(p);
                    } else {
                        int bili = Integer.parseInt(price);
                        total = total.add(new BigDecimal("0"));
                    }
                    int satus=Integer.parseInt(tbCheckReduce.getStatus());
                    satus=satus-1;
                    tbCheckReduce.setStatus(""+satus);
                    tbCheckReduceService.updateById(tbCheckReduce);
                }
            }
            tbUnpaidBills.setLateFeesRelief(total.toString());

            //账单据号
            tbUnpaidBills.setNum("numnumnumnum");
            if(tbCycle.getFeetypeId()==1){
           Double area=     houseManager.getById(tbCycle.getHouseId()).getArea();
                //计费数量
                tbUnpaidBills.setNumber(area+"");
            }else {
                //计费数量
                tbUnpaidBills.setNumber("1");
            }

            //冲抵金额
            tbUnpaidBills.setOffset("0");

            //项目名称
            tbUnpaidBills.setProjectName(tbCycle.getProjectName());

            //账单减免金额
            BigDecimal total1 = new BigDecimal(0);
            if (tbCycle.getTbCheckReduceList().size() == 0 || tbCycle.getTbCheckReduceList() == null) {
                tbUnpaidBills.setRelief("0");
            } else {
                TbCheckReduce tbCheckReduce = new TbCheckReduce();

                for (int k = 0; k < tbCycle.getTbCheckReduceList().size(); k++) {
                    tbCheckReduce = tbCycle.getTbCheckReduceList().get(k);
                    String price = tbCheckReduce.getReducePrice();
                    //0为固定金额 1为固定比例
                    String way = tbCheckReduce.getReduceWay();
                    if (way.equals("0")) {
                        BigDecimal p = new BigDecimal(price);
                        total1 = total1.add(p);
                    } else {
                        int bili = Integer.parseInt(price);
                        total1 = total1.add(feesStandard.getPrice().multiply(new BigDecimal(bili)));
                    }
                    int satus=Integer.parseInt(tbCheckReduce.getStatus());
                    satus=satus-1;
                    tbCheckReduce.setStatus(""+satus);
                    tbCheckReduceService.updateById(tbCheckReduce);
                }
            }

            tbUnpaidBills.setRelief(total1.toString());
//应收金额

            BigDecimal received = feesStandard.getPrice().multiply(new BigDecimal(tbUnpaidBills.getNumber()));
            if (received.compareTo(new BigDecimal(0)) == -1) {
                tbUnpaidBills.setReceived("0");
            } else {
                tbUnpaidBills.setReceived(received.toString());
            }
            //未收金额
            tbUnpaidBills.setNotReceived(tbUnpaidBills.getReceived());
            //应收日期
            tbUnpaidBills.setShouldReceivedTime(LocalDate.now().plusMonths(1l).toString());
            //是否作废
            tbUnpaidBills.setStatus(0);
            //关联收款单
            tbUnpaidBills.setTbPaidBillsId(null);

            int feecycle= tbCycle.getFeecycle();
            feecycle=feecycle-1;
            tbCycle.setFeecycle(feecycle);
            tbCycleService.updateById(tbCycle);


            tbUnpaidBillsList.add(tbUnpaidBills);
        }
    System.out.println("33333");
    }

}
