package com.woniuxy.projectmanager.service;

import com.woniuxy.projectmanager.mapper.ProjectMapper;
import com.woniuxy.wuye.common.entity.TbProject;
import com.woniuxy.wuye.common.utils.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@SuppressWarnings("all")
@Slf4j
public class ProjectServiceTest {

    @Autowired
    ProjectService projectService;
    @Test
    void test1(){
        TbProject tbProject=new TbProject();
        tbProject.setProjectName("yang");
        tbProject.setProjectType("公寓");
        tbProject.setState("暂停");
        projectService.insert(tbProject);
    }
    @Test
    void test2(){
        projectService.delete(23);
    }
    @Test
    void test3(){
        TbProject tbProject=new TbProject();
        tbProject.setProjectId(24);
        tbProject.setProjectName("yang");
        tbProject.setProjectType("公寓");
        tbProject.setState("haofang");
        projectService.update(tbProject);
    }
    @Test
    void test4(){
        TbProject tbProject=new TbProject();
        //tbProject.setProjectId(24);
        tbProject.setProjectName("yang");
        tbProject.setProjectType("公寓");
        //tbProject.setState("haofang");
        List<TbProject> byCondition = projectService.getByCondition(tbProject);
        byCondition.forEach(System.out::println);
    }
    @Test
    void test5(){
        PageBean<TbProject> byPage = projectService.getByPage(2, 1);
        System.out.println(byPage.getData());
        log.debug("bypage{}"+byPage);
    }
    @Test
    void test6(){
        TbProject tbProject=new TbProject();
        //tbProject.setProjectId(24);
        tbProject.setProjectName("yang");
        tbProject.setProjectType("公寓");
        PageBean<TbProject> byPage = projectService.getByCondition(tbProject,2, 1);
        System.out.println(byPage.getData());

    }
}
