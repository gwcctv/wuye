package com.woniuxy.batchservice.automake;

import com.woniuxy.batchservice.dao.TbCheckReduceMapper;
import com.woniuxy.batchservice.dao.TbCycleMapper;
import com.woniuxy.batchservice.service.TbCycleService;
import com.woniuxy.wuye.common.entity.TbCheckReduce;
import com.woniuxy.wuye.common.entity.TbCycle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Component
public class AutoMakeUtils {
    @Autowired
    TbCycleService tbCycleService;
    @Autowired
    TbCycleMapper tbCycleMapper;
    @Autowired
    TbCheckReduceMapper tbCheckReduceMapper;
    /**
     * 通过筛选出来的周期业务找出对应的减免账单
     */

    public List<TbCycle>  getReduceByList() {
        List<TbCycle> tbCycles = selectInListByCondition();
        Iterator<TbCycle> tbCycleIterator = tbCycles.iterator();
        TbCheckReduce tbCheckReduce = new TbCheckReduce();
        while (tbCycleIterator.hasNext()) {
            TbCycle tbCycle = tbCycleIterator.next();

            tbCheckReduce.setHouseId(tbCycle.getHouseId());
            tbCheckReduce.setFeetypeId(tbCycle.getFeetypeId());
            //判断是账单减免
            tbCheckReduce.setJudge("0");
            List<TbCheckReduce> tbCheckReduceList = tbCheckReduceMapper.getByCondition(tbCheckReduce);
            //判断是滞纳金减免
            tbCheckReduce.setJudge("1");
            tbCheckReduce.setFeetypeId(null);
            List<TbCheckReduce> tbCheckReduceListForLateMoney = tbCheckReduceMapper.getByCondition(tbCheckReduce);
            if (tbCheckReduceList != null || tbCheckReduceList.size() != 0) {
                tbCycle.setTbCheckReduceList(tbCheckReduceList);
                tbCycle.setTbCheckReduceListForLateMoney(tbCheckReduceListForLateMoney);
            }
        }

        return tbCycles;
    }


    /**
     * 筛选出符合日期的周期任务
     */

    public List<TbCycle> selectInListByCondition() {
        TbCycle tbCycle = new TbCycle();
        String dateTime = LocalDate.now().toString();
        String year = dateTime.split("-")[0];
        int yearNum = Integer.parseInt(year);
        tbCycle.setStartYear(year);

        String month = dateTime.split("-")[1];
        String day = dateTime.split("-")[2];

//        tbCycle.setStartDay(day);
//        tbCycle.setStartMonth(month);
        List<TbCycle> tbCycles = tbCycleMapper.getByCondition(tbCycle);
        Iterator<TbCycle> tbCycleIterator = tbCycles.iterator();
        if (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11")) {
            if (day.equals("30")) {

                while (tbCycleIterator.hasNext()) {
                    TbCycle tbCycle1 = tbCycleIterator.next();
                    if (!tbCycle1.getStartDay().equals("30") && !tbCycle1.getStartDay().equals("31")) {
                        tbCycleIterator.remove();
                    }
                }
            } else {
                commonRemove(day, tbCycleIterator);
            }
        } else if (month.equals("2") && yearNum % 4 == 0 && yearNum % 100 != 0) {
            if (day == "29") {
                while (tbCycleIterator.hasNext()) {
                    TbCycle tbCycle1 = tbCycleIterator.next();
                    if (!tbCycle1.getStartDay().equals("30") && !tbCycle1.getStartDay().equals("31") && !tbCycle1.getStartDay().equals("29")) {
                        tbCycleIterator.remove();
                    }
                }
            } else {
                commonRemove(day, tbCycleIterator);
            }
        } else if (month.equals("2")) {
            if (day == "28") {
                while (tbCycleIterator.hasNext()) {
                    TbCycle tbCycle1 = tbCycleIterator.next();
                    if (!tbCycle1.getStartDay().equals("30") && !tbCycle1.getStartDay().equals("31") && !tbCycle1.getStartDay().equals("29") && !tbCycle1.getStartDay().equals("28")) {
                        tbCycleIterator.remove();
                    }
                }
            } else {
                commonRemove(day, tbCycleIterator);
            }
        } else {
            commonRemove(day, tbCycleIterator);
        }

        return tbCycles;

    }

    /**
     * 根据当天几号 简单的逻辑移除
     */
    public void commonRemove(String day, Iterator<TbCycle> iterator) {
        while (iterator.hasNext()) {
            TbCycle tbCycle1 = iterator.next();
            if (!tbCycle1.getStartDay().equals(day)) {
                iterator.remove();
            }
        }
    }
}
