package com.woniuxy.busconfig.feignclient;



import com.woniuxy.wuye.common.entity.vo.HouseVo;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient( value = "house-manager",url = "localhost:8003",fallback = HouFeignClientFallback.class)
//@RequestMapping("/student")
public interface HouFeignClient {
    /**
     *
     * 调用project-manager服务得到所有项目名
     * @return
     */
    @RequestMapping("/house/list")
    public ResponseEntity getAllHouse(@RequestBody HouseVo houseVo);

}
