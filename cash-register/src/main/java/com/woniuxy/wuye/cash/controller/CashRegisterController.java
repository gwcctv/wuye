package com.woniuxy.wuye.cash.controller;

import com.woniuxy.wuye.cash.map.TbDepositedFeesMapper;
import com.woniuxy.wuye.cash.openfeign.HouseOpenFeign;
import com.woniuxy.wuye.cash.service.CashRegisterService;
import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.common.entity.TbDepositedFees;
import com.woniuxy.wuye.common.entity.TbHouse;
import com.woniuxy.wuye.common.entity.TbUnpaidBills;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/20
 **/
@RestController
@RequestMapping("/cashregister")
public class CashRegisterController {
    @Autowired
    private CashRegisterService cashRegisterService;
//    @Autowired
//    private HouseOpenFeign  houseOpenFeign;
    /**
     * 多条件分页查询所有
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/unpaidbills/querypagecondition")
    public ResponseEntity queryUnpaidBillsPageCondition(Integer pageNum,Integer pageSize,ConditionVo conditionVo){
        PageBean<TbUnpaidBills> pageBean = cashRegisterService.selectUnpaidBillsPageByCondition(pageNum, pageSize,conditionVo);
        return new ResponseEntity("200","ok",pageBean);
    }


    /**
     * 分页查询预存表数据
     * @param pageNum
     * @param pageSize
     * @param conditionVo
     * @return
     */
    @RequestMapping("/depositedfees/querypagecondition")
    public ResponseEntity queryDepositedFeesPageByCondition(Integer pageNum, Integer pageSize,ConditionVo conditionVo){
//        PageBean<TbDepositedFees> tbDepositedFeesPageBean = cashRegisterService.selectDepositedFeesPageByCondition(pageNum, pageSize, conditionVo);
//        //得到我的数据，通过项目id和用户id调用房产的微服务，得到数据添加进数据中
//        for (TbDepositedFees tbDepositedFees : tbDepositedFeesPageBean.getData()) {
//            Integer clientId = tbDepositedFees.getDepositedUser().getClientId();
//            Integer projectId = tbDepositedFees.getProject().getProjectId();
//            //调用房产的服务
//            String getNames="";
//            ResponseEntity objects = houseOpenFeign.getHouseNames(clientId, projectId);
//            List<TbHouse> houseNames = (List<TbHouse>)objects.getData();
//            for (TbHouse house : houseNames) {
//                getNames+=house.getBuildingNumber()+"幢"+house.getUnit()+house.getLayer()+house.getHouseNumber()+",";
//            }
//            //设置相关房产名
//            tbDepositedFees.setHouseNames(getNames.substring(0,getNames.length()-2));
//        }
        return new ResponseEntity("200","ok",null);
    }
}
