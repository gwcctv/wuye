package com.woniuxy.batchservice.feign;

import com.woniuxy.wuye.common.entity.TbUnpaidBills;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cash-register",url = "localhost:8091",path = "cashregister")
public interface CashRegister {
@RequestMapping("/unpaidbills/addunpaidbills")
    public ResponseEntity addUnpaidBills(@RequestBody TbUnpaidBills tbUnpaidBills);
}
