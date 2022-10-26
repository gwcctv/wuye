package com.woniuxy.batchservice.web;

import com.woniuxy.batchservice.service.TbCycleService;
import com.woniuxy.wuye.common.entity.TbCycle;
import com.woniuxy.wuye.common.exceptions.NoIdInSqlException;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 周期业务接口
 */
@RequestMapping("cycle")
@RestController
@Transactional(rollbackFor = Exception.class)
public class TbCycleController {
    @Autowired
    TbCycleService tbCycleService;

    /**
     * 多条件分页查询
     */
    @RequestMapping("getByPage")
    public PageBean<TbCycle> getByConditionByPage(@RequestBody TbCycle tbCycle, int page) {
        if (tbCycle.getStartTime() != null && !tbCycle.getStartTime().equals("")) {
            String[] time = tbCycle.getStartTime().split("-");
            tbCycle.setStartYear(time[0]);
            tbCycle.setStartMonth(time[1]);
            tbCycle.setStartDay(time[2]);
        }
        if (tbCycle.getEndTime() != null && !tbCycle.getEndTime().equals("")) {
            String[] time = tbCycle.getEndTime().split("-");
            tbCycle.setEndYear(time[0]);
            tbCycle.setEndMonth(time[1]);
            tbCycle.setEndDay(time[2]);
        }
      PageBean<TbCycle>tbCyclePageBean= tbCycleService.getByConditionByPage(tbCycle, page);
        List<TbCycle> tbCycles=tbCyclePageBean.getData();
        tbCycles.forEach(r->{
            if(r.getProduceStatus().equals("0")){
                r.setProduceStatus("生成失败");
            }else {
                r.setProduceStatus("生成成功");
            }
        });
        return tbCycleService.getByConditionByPage(tbCycle, page);
    }

    /**
     * 添加周期业务
     */
    @PostMapping("add")
    public ResponseEntity addCycle(@RequestBody TbCycle tbCycle) throws ParseException {
        try {
            String[] startTime = tbCycle.getStartTime().split("-");
            tbCycle.setStartYear(startTime[0]);
            tbCycle.setStartMonth(startTime[1]);
            tbCycle.setStartDay(startTime[2]);
            LocalDate date = LocalDate.parse(tbCycle.getStartTime());
            if (date.isAfter(LocalDate.now())) {
                tbCycle.setProduceStatus("0");
                tbCycle.setFailureProduceReason("起始日期晚于今天");
            } else {
                tbCycle.setProduceStatus("1");
            }

            date = date.plusMonths(tbCycle.getFeecycle());
            String[] endTime = date.toString().split("-");
            tbCycle.setEndYear(endTime[0]);
            tbCycle.setEndMonth(endTime[1]);
            tbCycle.setEndDay(endTime[2]);
            tbCycle.setProduceName("魏锦鹏");

            tbCycle.setNumber("11111111111");
            System.out.println("");
            tbCycle.setProduceTime(LocalDateTime.now().toString());
            tbCycleService.save(tbCycle);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.FAILURE;

        }

        return new ResponseEntity<>("200","ok",tbCycle);
    }

    /**
     * 周期业务根据ID删除
     */
    @RequestMapping("delete")
    public ResponseEntity deleteById( @RequestParam("idsString") String idsString) throws NoIdInSqlException {
      try {
          String[] idsS = idsString.split(",");
          int[] ids = new int[idsS.length];
          //判断是否删除的参数
          Boolean is = true;
          for (int i = 0; i < idsS.length; i++) {
              ids[i] = Integer.parseInt(idsS[i]);
          }
          if (ids.length == 1) {
              is = tbCycleService.removeById(ids[0]);
          } else {
              for (int id : ids) {
                  is = tbCycleService.removeById(id);
                  if (is == false) {
                      throw new NoIdInSqlException();
                  }
              }
          }
          if (is == false) {
              throw new NoIdInSqlException();
          }
      }catch (Exception e){
          e.printStackTrace();
          return ResponseEntity.FAILURE;
      }
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("addCycle")
    public ResponseEntity addCycle(Integer id) {
        TbCycle tbCycle = tbCycleService.getById(id);
        int feecycle = tbCycle.getFeecycle();
        feecycle = feecycle + 1;
        tbCycle.setFeecycle(feecycle);
        tbCycleService.updateById(tbCycle);
        return ResponseEntity.SUCCESS;

    }
}
