package com.woniuxy.projectmanager;

import com.woniuxy.projectmanager.filter.Filter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@MapperScan(basePackages = "com.woniuxy.projectmanager.mapper")
@EnableDiscoveryClient
public class ProjectManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagerApplication.class, args);
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
