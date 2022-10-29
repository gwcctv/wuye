package com.woniuxy.busconfig.feignclient;



import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient( value = "project-manager",url = "localhost:8001",fallback = FbcFeignClientFallback.class)
//@RequestMapping("/student")
public interface FbcFeignClient {
    /**
     *
     * 调用project-manager服务得到所有项目名
     * @return
     */
    @RequestMapping("/project/getName")
    public ResponseEntity projectName();

}
