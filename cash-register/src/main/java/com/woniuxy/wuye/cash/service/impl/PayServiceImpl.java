package com.woniuxy.wuye.cash.service.impl;

import com.alipay.api.AlipayApiException;
import com.woniuxy.wuye.cash.map.TbPaidBillsMapper;
import com.woniuxy.wuye.cash.service.PayService;
import com.woniuxy.wuye.cash.utils.AlipayBean;
import com.woniuxy.wuye.cash.utils.AlipayUtil;
import com.woniuxy.wuye.common.entity.TbPaidBills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/23
 **/
/* 支付服务 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired(required = false)
    private TbPaidBillsMapper tbPaidBillsMapper;

    /**
     * 查询实际收款金额，调用收款接口
     * @param num
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String aliPay(String num) throws AlipayApiException {
        //通过收款单据号查询收款单
        TbPaidBills paidBills = tbPaidBillsMapper.getByNum(num);
        AlipayBean alipayBean=new AlipayBean();
        alipayBean.setBody("收款单收款");
        //金额
        alipayBean.setTotal_amount(paidBills.getRealSumFees());
        alipayBean.setSubject("收款");
        alipayBean.setOut_trade_no(num);
        return AlipayUtil.connect(alipayBean);
    }
}
