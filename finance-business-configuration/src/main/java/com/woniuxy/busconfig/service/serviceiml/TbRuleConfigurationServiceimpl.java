package com.woniuxy.busconfig.service.serviceiml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.busconfig.mapper.RuleAndProjectMapper;
import com.woniuxy.busconfig.mapper.TbRuleConfigurationMapper;
import com.woniuxy.busconfig.service.TbRuleConfigurationService;
import com.woniuxy.wuye.common.entity.RuleAndProject;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.entity.TbProjectfsc;
import com.woniuxy.wuye.common.entity.TbRuleConfiguration;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 规则配置表类
 * @魏锦鹏
 */
@Service
public class TbRuleConfigurationServiceimpl extends ServiceImpl<TbRuleConfigurationMapper, TbRuleConfiguration> implements TbRuleConfigurationService {
   @Autowired
   private TbRuleConfigurationMapper tbRuleConfigurationMapper;
   @Autowired
   private RuleAndProjectMapper ruleAndProjectMapper;
    @Override
    public PageBean<TbRuleConfiguration> getTbRuleConfiguration(TbRuleConfiguration tbRuleConfiguration, int page) {
        PageBean<TbRuleConfiguration> pageBean = new PageBean<>();
        pageBean.setPageSzie(4);//分页大小
        pageBean.setCurrPage(page);    //设置当前页数
        Page p = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbRuleConfiguration> list =tbRuleConfigurationMapper.getTbRuleConfiguration(tbRuleConfiguration);
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }

    @Override
    public void addTbRuleConfiguration(TbRuleConfiguration tbRuleConfiguration) {
        List<Integer> projectIds = tbRuleConfiguration.getProjectIds();
        tbRuleConfigurationMapper.insert(tbRuleConfiguration);
        for (Integer projectId : projectIds) {
            RuleAndProject ruleAndProject = new RuleAndProject();
            ruleAndProject.setRoleId(tbRuleConfiguration.getId());
            ruleAndProject.setProjectId(projectId);
            ruleAndProjectMapper.insert(ruleAndProject);
        }

    }
}
