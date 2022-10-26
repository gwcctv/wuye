package com.woniuxy.wuye.cash.config;

import com.woniuxy.wuye.cash.filter.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/25
 **/
@Configuration
public class FilterConfigWuYe {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new Filter());
        //添加过滤器的路径
        bean.addUrlPatterns("/*");
        //bean.setFilter();
        bean.setOrder(Integer.MIN_VALUE);
        return bean;

    }
}
