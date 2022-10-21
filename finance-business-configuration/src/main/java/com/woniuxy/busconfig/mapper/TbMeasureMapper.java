package com.woniuxy.busconfig.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.busconfig.provider.TbFeesStandardConfigurationSqlProvider;
import com.woniuxy.busconfig.provider.TbMeasureSqlProvider;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import com.woniuxy.wuye.common.entity.TbMeasure;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
/**
 * 计量表接口
 * @魏锦鹏
 */
public interface TbMeasureMapper extends BaseMapper<TbMeasure> {

    @SelectProvider(value = TbMeasureSqlProvider.class,method = "getByCondition")
    List<TbMeasure> getTbMeasure(TbMeasure TbMeasure);
}
