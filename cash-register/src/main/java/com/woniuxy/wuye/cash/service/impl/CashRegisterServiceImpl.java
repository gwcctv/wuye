package com.woniuxy.wuye.cash.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.wuye.cash.map.TbDepositedFeesMapper;
import com.woniuxy.wuye.cash.map.TbOffsetHistoryMapper;
import com.woniuxy.wuye.cash.map.TbPaidBillsMapper;
import com.woniuxy.wuye.cash.map.TbUnpaidBillsMapper;
import com.woniuxy.wuye.cash.openfeign.HouseOpenFeign;
import com.woniuxy.wuye.cash.service.CashRegisterService;
import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.cash.utils.WoNiuTimeUtil;
import com.woniuxy.wuye.common.entity.*;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.cash.utils.PageBeanUtil;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.util.calendar.BaseCalendar;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/20
 **/
@Service
public class CashRegisterServiceImpl implements CashRegisterService {
    @Autowired(required = false)
    TbUnpaidBillsMapper tbUnpaidBillsMapper;
    @Autowired(required = false)
    private HouseOpenFeign houseOpenFeign;

    @Override
    public PageBean<TbUnpaidBills> selectUnpaidBillsPageByCondition(Integer pageNum, Integer pageSize, ConditionVo conditionVo) {
        //获取封装查询条件

        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<TbUnpaidBills> list = tbUnpaidBillsMapper.getByCondition(conditionVo);

        PageBean<TbUnpaidBills> pageBean = PageBeanUtil.getPageBean(page, list);
        return pageBean;
    }


    @Autowired(required = false)
    private TbDepositedFeesMapper tbDepositedFeesMapper;

    /**
     * 分页查出预存列表
     *
     * @param pageNum
     * @param pageSize
     * @param conditionVo
     * @return
     */
    @Override
    public PageBean<TbDepositedFees> selectDepositedFeesPageByCondition(Integer pageNum, Integer pageSize, ConditionVo conditionVo) {
        //分页查出预存总表记录
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<TbDepositedFees> list = tbDepositedFeesMapper.getByCondition(conditionVo);
        PageBean<TbDepositedFees> tbDepositedFeesPageBean = PageBeanUtil.getPageBean(page, list);
        //得到我的数据，通过项目id和用户id调用房产的微服务，得到数据添加进数据中
        for (TbDepositedFees tbDepositedFees : tbDepositedFeesPageBean.getData()) {
            Integer clientId = tbDepositedFees.getDepositedUser().getClientId();
            Integer projectId = tbDepositedFees.getProject().getProjectId();
            //调用房产的服务
            String getNames = "";
            ResponseEntity objects = houseOpenFeign.getHouseNames(clientId, projectId);
            List<TbHouse> houseNames = (List<TbHouse>) objects.getData();
            for (TbHouse house : houseNames) {
                getNames += house.getBuildingNumber() + "幢" + house.getUnit() + house.getLayer() + house.getHouseNumber() + ",";
            }
            //设置相关房产名
            tbDepositedFees.setHouseNames(getNames.substring(0, getNames.length() - 2));
        }
        return tbDepositedFeesPageBean;
    }

    @Override
    public Integer addUnpaidBills(TbUnpaidBills tbUnpaidBills) {
        return tbUnpaidBillsMapper.add(tbUnpaidBills);
    }

    /**
     * 作废
     * 需要全局事务
     *
     * @param id
     */
    @Override
    public void invalidUnpaidBills(Integer id) {
        //前端传过来未支付账单id，作废处理
        //先将在自己的账单作废，再调用减免账单修改其状态
        //作废自己的账单
        tbUnpaidBillsMapper.update(id, 1);
        //调用减免账单服务的接口修改减免账单的状态
        //TODO
    }

    /**
     * 减免
     * 开启全局事务
     *
     * @param id
     * @param tbCheckReduce
     */
    @Override
    public void billsReduce(Integer id, TbCheckReduce tbCheckReduce) {
        //根据减免账单修改未支付账单的数据
        //todo
        //调用减免账单服务的接口新增一个减免账单
    }

    @Autowired(required = false)
    private TbPaidBillsMapper tbPaidBillsMapper;
    @Autowired(required = false)
    private TbOffsetHistoryMapper tbOffsetHistoryMapper;

    /**
     * 收款
     *
     * @param
     */
    @Transactional
    @Override
    public String crediting(TbPaidBills tbPaidBills) {
        try {
            //应收金额
            BigDecimal receivedTotal=new BigDecimal("0");
            //减免金额
            BigDecimal reliefTotal=new BigDecimal("0");
            //滞纳金
            BigDecimal lateFeesTotal=new BigDecimal("0");
            //滞纳金减免金额
            BigDecimal lateFeesReliefTotal=new BigDecimal("0");
            //冲抵金额
            BigDecimal chongdiTotal=new BigDecimal("0");
            //建议收款总金额
            BigDecimal adviceSumFeesTotal=new BigDecimal("0");
            //查询出未收款单
            Integer[] unPaidBillIds = tbPaidBills.getUnPaidBillIds();
            for (Integer unPaidBillId : unPaidBillIds) {
                TbUnpaidBills unpaidBill = tbUnpaidBillsMapper.getById(unPaidBillId);
                //应收金额
                BigDecimal received = new BigDecimal(unpaidBill.getReceived());
                receivedTotal=receivedTotal.add(received);//
                //减免
                BigDecimal relief = new BigDecimal(unpaidBill.getRelief());

                //计算单个未收账单的总金额
                if (Integer.parseInt(unpaidBill.getRelief()) < 1) {
                    //比例减免
                    received = received.multiply(new BigDecimal("1").subtract(relief));
                    reliefTotal= reliefTotal.add(received.multiply(relief));//
                } else if (Integer.parseInt(unpaidBill.getRelief()) >= 1) {
                    //金额减免
                    received = received.subtract(relief);
                    reliefTotal=reliefTotal.add(relief);//
                }
                //滞纳金
                BigDecimal lateFees = new BigDecimal(unpaidBill.getLateFees());
                lateFeesTotal=lateFeesTotal.add(lateFees);//
                //滞纳金减免
                BigDecimal lateFeesRelief = new BigDecimal(unpaidBill.getLateFeesRelief());
                //减免滞纳金
                if (Integer.parseInt(unpaidBill.getLateFeesRelief()) < 1) {
                    //比例
                    lateFees = lateFees.multiply(new BigDecimal("1").subtract(lateFeesRelief));
                    lateFeesReliefTotal=lateFeesReliefTotal.add(lateFees.multiply(lateFeesRelief));//
                } else if (Integer.parseInt(unpaidBill.getLateFeesRelief()) >= 1) {
                    //固定金额
                    lateFees = lateFees.subtract(lateFeesRelief);
                    lateFeesReliefTotal=lateFeesReliefTotal.add(lateFeesRelief);//
                }
                //得到了冲抵抵消钱的应收金额
                BigDecimal totalFirst = new BigDecimal(unpaidBill.getLateFeesRelief());
                //加上滞纳金
                totalFirst = received.add(lateFees);
                //冲抵

                //判断是否冲抵
                BigDecimal offset = new BigDecimal(unpaidBill.getOffset());
                if ("y".equals(tbPaidBills.getIsOffset())) {
                    //查询出预存金额的多少,根据用户id查和项目名查
                    TbDepositedFees depositedFees = tbDepositedFeesMapper.getByUidAndPid(unpaidBill.getHouseOwner().getClientId(), unpaidBill.getProjectName());
                    //剩余预存
                    BigDecimal remainderDeposited = new BigDecimal(depositedFees.getRemainderDeposited());
                    //判断剩余是否大于0
                    if (remainderDeposited.compareTo(new BigDecimal(0)) > -1) {
                        //大于0
                        //比例冲抵
                        if (Integer.parseInt(unpaidBill.getOffset()) < 1) {
                            //比例冲抵
                            //判断剩余金额是否满足冲抵金额
                            BigDecimal chongdi = totalFirst.multiply(offset);
                            chongdiTotal=chongdiTotal.add(chongdi);//
                            if (remainderDeposited.compareTo(chongdi) > -1) {
                                //冲抵金额小于剩余金额,总额减去冲抵金额chongdiTotal
                                totalFirst = totalFirst.subtract(chongdi);
                                //更新预存表
                                //剩余预存金额更新
                                depositedFees.setRemainderDeposited(remainderDeposited.subtract(chongdi).toString());
                                //更新已抵扣金额
                                depositedFees.setAlreadyOffsetFees(chongdi.add(new BigDecimal(depositedFees.getAlreadyOffsetFees())).toString());
                                //更新最近抵扣时间
                                depositedFees.setRecentOffsetTime(WoNiuTimeUtil.getNowTime());
                                tbDepositedFeesMapper.updateByCondition(depositedFees);
                                //新增抵扣记录
                                TbOffsetHistory tbOffsetHistory = new TbOffsetHistory();
                                //冲抵记录单号
                                tbOffsetHistory.setOffsetNumber("CD" + WoNiuTimeUtil.getNowTimeNumber());
                                //记录状态
                                tbOffsetHistory.setStatus("0");
                                //关联未收款单id
                                tbOffsetHistory.setTbUnPaidBillsId(unpaidBill.getId());
                                //抵扣金额
                                tbOffsetHistory.setOffsetFees(chongdi.toString());
                                //冲抵时间
                                tbOffsetHistory.setOffsetTime(WoNiuTimeUtil.getNowTime());
                                //关联预存总表的id
                                tbOffsetHistory.setTbDepositedFeesId(depositedFees);

                            } else {
                                //冲抵金额不足
                            }
                        } else if (Integer.parseInt(unpaidBill.getOffset()) >= 1) {
                            //固定金额冲抵
                            if (Integer.parseInt(unpaidBill.getOffset()) < 1) {
                                //判断剩余金额是否满足固定金额冲抵
                                BigDecimal chongdi = offset;
                                chongdiTotal=chongdiTotal.add(offset);//
                                if (remainderDeposited.compareTo(chongdi) > -1) {
                                    //冲抵金额小于剩余金额,总额减去冲抵金额
                                    totalFirst = totalFirst.subtract(chongdi);
                                    //更新预存表
                                    //剩余预存金额更新
                                    depositedFees.setRemainderDeposited(remainderDeposited.subtract(chongdi).toString());
                                    //更新已抵扣金额
                                    depositedFees.setAlreadyOffsetFees(chongdi.add(new BigDecimal(depositedFees.getAlreadyOffsetFees())).toString());
                                    //更新最近抵扣时间
                                    depositedFees.setRecentOffsetTime(WoNiuTimeUtil.getNowTime());
                                    tbDepositedFeesMapper.updateByCondition(depositedFees);
                                    //新增抵扣记录
                                    TbOffsetHistory tbOffsetHistory = new TbOffsetHistory();
                                    //冲抵记录单号
                                    tbOffsetHistory.setOffsetNumber("CD" + WoNiuTimeUtil.getNowTimeNumber());
                                    //记录状态
                                    tbOffsetHistory.setStatus("0");
                                    //关联未收款单id
                                    tbOffsetHistory.setTbUnPaidBillsId(unpaidBill.getId());
                                    //抵扣金额
                                    tbOffsetHistory.setOffsetFees(chongdi.toString());
                                    //冲抵时间
                                    tbOffsetHistory.setOffsetTime(WoNiuTimeUtil.getNowTime());
                                    //关联预存总表的id
                                    tbOffsetHistory.setTbDepositedFeesId(depositedFees);

                                } else {
                                    //冲抵金额不足
                                }
                            }
                        }
                    }
                    //现在的钱是，账单减免，冲抵，滞纳金计算完成后的金额
                    //更新未收款单关联得收款单外键
                    tbUnpaidBillsMapper.updateByCondition(unpaidBill);
                }
                adviceSumFeesTotal=totalFirst;//
                //判断是否抹零
                if ("y".equals(tbPaidBills.getIsWipeZero())) {
                    totalFirst = totalFirst.subtract(new BigDecimal(tbPaidBills.getWipeZeroFees()));
                }
                //计算完成，更新收款单
                //自动生成单据号
                tbPaidBills.setNum("PF" + WoNiuTimeUtil.getNowTimeNumber());
                //应收金额
                tbPaidBills.setShouldFees(receivedTotal.toString());
                //减免金额
                tbPaidBills.setReliefFees(reliefTotal.toString());
                //未收金额
                BigDecimal notFeesTotal=receivedTotal.subtract(reliefTotal);
               tbPaidBills.setNotFees(notFeesTotal.toString());
                //滞纳金
                tbPaidBills.setLateFees(lateFeesTotal.toString());
                //滞纳金减免金额
                tbPaidBills.setReliefLateFees(lateFeesReliefTotal.toString());
                //冲抵金额
                tbPaidBills.setOffsetFees(chongdiTotal.toString());
                //建议收款总金额
                tbPaidBills.setAdviceSumFees(adviceSumFeesTotal.toString());
                //实际总收金额
                tbPaidBills.setRealSumFees(totalFirst.toString());
                //支付状态
                tbPaidBills.setPayStatus("支付失败");
                //计算完后新增收款单
                int newId = tbPaidBillsMapper.add(tbPaidBills);
                for (Integer unPaidBill : unPaidBillIds) {
                    tbUnpaidBillsMapper.updatePayBillId(unPaidBill, newId);
                }
                return tbPaidBills.getNum();
            }
        } catch (Exception e) {
            throw new RuntimeException("收钱失败");
        }
        return null;
    }


}