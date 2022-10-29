package com.woniuxy.busconfig.feignclient;



import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author author
 * 熔断降级
 */
@Component
public class FbcFeignClientFallback implements FbcFeignClient {
    @Override
    public ResponseEntity projectName() {
        return new ResponseEntity("500", "getStudentBySid---fallback", "null");
    }
}
