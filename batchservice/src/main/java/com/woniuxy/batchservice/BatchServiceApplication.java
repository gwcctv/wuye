package com.woniuxy.batchservice;

import com.woniuxy.batchservice.filter.Filter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@MapperScan( {"com.woniuxy.batchservice.dao","com.woniuxy.batchservice.jilianutils.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BatchServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchServiceApplication.class,args);

    }
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
