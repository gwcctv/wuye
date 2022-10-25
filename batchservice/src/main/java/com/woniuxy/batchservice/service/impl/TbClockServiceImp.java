package com.woniuxy.batchservice.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.batchservice.dao.TbClockMapper;
import com.woniuxy.batchservice.feign.FinanceBusinessConfiguration;

import com.woniuxy.batchservice.service.TbCheckReduceService;
import com.woniuxy.batchservice.service.TbClockService;
import com.woniuxy.wuye.common.entity.*;
import com.woniuxy.wuye.common.entity.vo.TbFeesStandardConfigurationVo;
import com.woniuxy.wuye.common.utils.PageBean;

import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class TbClockServiceImp extends ServiceImpl<TbClockMapper,TbClock> implements TbClockService{
    @Autowired
    TbClockMapper tbClockMapper;
    @Autowired
    FinanceBusinessConfiguration financeBusinessConfiguration;
    @Autowired
    TbCheckReduceService tbCheckReduceService;
    @Override
    public PageBean<TbClock> getByCondition(TbClock tbClock,int page) {

        PageBean<TbClock> pageBean = new PageBean<>();
        pageBean.setPageSzie(4);//分页大小
        pageBean.setCurrPage(page);    //设置当前页数
        Page p = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbClock> list = tbClockMapper.getByCondition(tbClock);
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
         return pageBean;
    }

    @Override
    public ResponseEntity getByIds(int[] ids) {
        List<TbClock> tbClocks=new ArrayList<>();
        for(int i:ids){
         tbClocks.add(tbClockMapper.getByCondition(new TbClock().builder().id(i).build()).get(0));
        }


        List<TbUnpaidBills> tbUnpaidBillsList=new ArrayList<>();

      TbClock tbClock=new TbClock();
        for (int i = 0; i < tbClocks.size(); i++) {
            tbClock = tbClocks.get(i);
            TbUnpaidBills tbUnpaidBills = new TbUnpaidBills();
            String houseName = tbClock.getProjectName() + "/" + tbClock.getBuildingNumber() + "/" + tbClock.getUnit() + "/" + tbClock.getLayer() + "/" + tbClock.getHouseNumber();
            //房子全称 项目名/楼号/单元/楼层/门号
            tbUnpaidBills.setHouseName(houseName);
            //账单开始时间
            tbUnpaidBills.setBillStartTime(LocalDate.now().toString());
            //账单截至时间
            tbUnpaidBills.setBillEndTime(LocalDate.now().plusMonths(1l).toString());

            //客户id
            tbUnpaidBills.setHouseOwner(new TbClient().builder().clientId(tbClock.getClientId()).build());
            //获取收费标准的名称
            TbFeesStandardConfiguration feesStandard = financeBusinessConfiguration.getByCondition(new TbFeesStandardConfigurationVo()
                    .builder().tbFeesStandardConfiguration(new TbFeesStandardConfiguration()
                            .builder().feesItem(tbClock.getFeetypeId()).
                            projectId(Integer.parseInt(tbClock.getProjectId()))
                            .build()).build()).getData().get(0);

            tbUnpaidBills.setFeesStandard(feesStandard.getStandardName());
            //收费项目名称

            tbUnpaidBills.setFeesItem(financeBusinessConfiguration.getById(tbClock.getFeetypeId()).getItemName());
            //设置删除状态 初始值为0
            tbUnpaidBills.setIsDelete(0);
            //设置滞纳金  初始账单为0
            tbUnpaidBills.setLateFees("0");
            //单价
            tbUnpaidBills.setPrice(feesStandard.getPrice().toString());
            //滞纳金减免
            BigDecimal total = new BigDecimal(0);
            if (tbClock.getTbCheckReduceListForLateMoney().size() == 0 || tbClock.getTbCheckReduceListForLateMoney() == null) {
                tbUnpaidBills.setLateFeesRelief("0");
            } else {
                TbCheckReduce tbCheckReduce = new TbCheckReduce();

                for (int j = 0; j < tbClock.getTbCheckReduceListForLateMoney().size(); j++) {
                    tbCheckReduce = tbClock.getTbCheckReduceListForLateMoney().get(j);
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
            //计费数量
            tbUnpaidBills.setNumber(tbClock.getNumber());
            //冲抵金额
            tbUnpaidBills.setOffset("0");

            //项目名称
            tbUnpaidBills.setProjectName(tbClock.getProjectName());

            //账单减免金额
            BigDecimal total1 = new BigDecimal(0);
            if (tbClock.getTbCheckReduceList().size() == 0 || tbClock.getTbCheckReduceList() == null) {
                tbUnpaidBills.setRelief("0");
            } else {
                TbCheckReduce tbCheckReduce = new TbCheckReduce();

                for (int k = 0; k < tbClock.getTbCheckReduceList().size(); k++) {



                    tbCheckReduce = tbClock.getTbCheckReduceList().get(k);
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

            BigDecimal received = feesStandard.getPrice().multiply(new BigDecimal(tbClock.getNumber()));
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

            tbUnpaidBillsList.add(tbUnpaidBills);
        }
        System.out.println("33333");


        return null;
    }
}
