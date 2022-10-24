package com.woniuxy.wuye.common.entity.vo;

import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
public class TbFeesStandardConfigurationVo {
 private TbFeesStandardConfiguration tbFeesStandardConfiguration;
 private Integer page;
}
