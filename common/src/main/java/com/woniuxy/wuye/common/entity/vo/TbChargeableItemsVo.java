package com.woniuxy.wuye.common.entity.vo;

import com.woniuxy.wuye.common.entity.TbChargeableItems;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class TbChargeableItemsVo {
    private TbChargeableItems tbChargeableItems;
    private Integer page;
}
