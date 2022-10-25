package com.woniuxy.wuye.common.entity.vo;

import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import lombok.*;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Builder
public class TbFeesStandardConfigurationVo {
 private TbFeesStandardConfiguration tbFeesStandardConfiguration;
 private Integer page;
}
