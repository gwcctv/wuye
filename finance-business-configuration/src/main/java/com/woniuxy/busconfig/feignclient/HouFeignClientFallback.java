package com.woniuxy.busconfig.feignclient;



import com.woniuxy.wuye.common.entity.vo.HouseVo;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author author
 * 熔断降级
 */
@Component
public class HouFeignClientFallback implements HouFeignClient {
    @Override
    public ResponseEntity getAllHouse( HouseVo houseVo) {
        return new ResponseEntity("500", "查询错误", "null");
    }
}
