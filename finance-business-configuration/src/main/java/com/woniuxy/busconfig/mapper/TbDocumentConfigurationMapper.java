package com.woniuxy.busconfig.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.busconfig.provider.TbDocumentConfigurationSqlProvider;
import com.woniuxy.busconfig.provider.TbMeasureSqlProvider;
import com.woniuxy.wuye.common.entity.TbDocumentConfiguration;
import com.woniuxy.wuye.common.entity.TbMeasure;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
/**
 * 单据配置表接口
 * @魏锦鹏
 */
public interface TbDocumentConfigurationMapper extends BaseMapper<TbDocumentConfiguration> {

    @SelectProvider(value = TbDocumentConfigurationSqlProvider.class,method = "getByCondition")
    List<TbDocumentConfiguration> getTbDocumentConfiguration(TbDocumentConfiguration TbDocumentConfiguration);
}

