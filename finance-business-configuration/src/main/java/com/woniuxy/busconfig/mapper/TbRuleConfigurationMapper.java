package com.woniuxy.busconfig.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.busconfig.provider.TbMeasureSqlProvider;
import com.woniuxy.busconfig.provider.TbRuleConfigurationSqlProvider;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.entity.TbRuleConfiguration;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface TbRuleConfigurationMapper extends BaseMapper<TbRuleConfiguration> {
    @SelectProvider(value = TbRuleConfigurationSqlProvider.class,method = "getByCondition")
    List<TbRuleConfiguration> getTbRuleConfiguration(TbRuleConfiguration tbRuleConfiguration);
}
