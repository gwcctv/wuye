package com.woniuxy.batchservice.automake;

import com.woniuxy.batchservice.dao.TbCheckReduceMapper;

import com.woniuxy.wuye.common.entity.TbCheckReduce;
import com.woniuxy.wuye.common.entity.TbClock;
import com.woniuxy.wuye.common.entity.TbCycle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

public class ClockRuZhangUtils {
    @Autowired
    TbCheckReduceMapper tbCheckReduceMapper;

    /**
     * 通过筛选出来的计量表业务找出对应的减免账单
     */

    public List<TbClock> getReduceByList(List<TbClock> clocks) {

        Iterator<TbClock> tbClockIterator = clocks.iterator();
        TbCheckReduce tbCheckReduce = new TbCheckReduce();
        while (tbClockIterator.hasNext()) {
            TbClock tbClock = tbClockIterator.next();

            tbCheckReduce.setHouseId(tbClock.getHouseId());
            tbCheckReduce.setFeetypeId(tbClock.getFeetypeId());
            //判断是账单减免
            tbCheckReduce.setJudge("0");
            List<TbCheckReduce> tbCheckReduceList = tbCheckReduceMapper.getByCondition(tbCheckReduce);
            //判断是滞纳金减免
            tbCheckReduce.setJudge("1");
            tbCheckReduce.setFeetypeId(null);
            List<TbCheckReduce> tbCheckReduceListForLateMoney = tbCheckReduceMapper.getByCondition(tbCheckReduce);
            if (tbCheckReduceList != null || tbCheckReduceList.size() != 0) {
                tbClock.setTbCheckReduceList(tbCheckReduceList);
                tbClock.setTbCheckReduceListForLateMoney(tbCheckReduceListForLateMoney);
            }
        }

        return clocks;
    }


}
