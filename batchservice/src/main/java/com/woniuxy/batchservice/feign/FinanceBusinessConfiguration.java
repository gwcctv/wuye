package com.woniuxy.batchservice.feign;

import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import com.woniuxy.wuye.common.entity.vo.TbFeesStandardConfigurationVo;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "finance-business-configuration",url = "localhost:8858")
public interface FinanceBusinessConfiguration {
    @RequestMapping(value = "sfbzpzb/getByCondition")
    public  PageBean<TbFeesStandardConfiguration> getByCondition(@RequestBody TbFeesStandardConfigurationVo tbFeesStandardConfigurationVo);

    @RequestMapping(value = "sfxm/getById")
    public TbChargeableItems getById(Integer id);
}
