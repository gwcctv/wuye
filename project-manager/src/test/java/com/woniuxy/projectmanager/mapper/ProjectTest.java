package com.woniuxy.projectmanager.mapper;

import com.woniuxy.wuye.common.entity.TbProject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProjectTest {
    @Autowired
    ProjectMapper projectMapper;

    @Test
    void test1(){
        TbProject tbProject=new TbProject();
        tbProject.setProjectName("wang");
        projectMapper.insert(tbProject);
    }
    @Test
    void test2(){
        projectMapper.delete(21);
    }
    @Test
    void test3(){
        TbProject tbProject=new TbProject();
        tbProject.setProjectId(22);
        tbProject.setProjectType("住宅");
        tbProject.setState("过期");
        projectMapper.updeta(tbProject);
    }
    @Test
    void test4() {
        TbProject tbProject = new TbProject();
        //tbProject.setProjectId(22);
        tbProject.setProjectType("住宅");
        tbProject.setState("过期");
        List<TbProject> byCondition = projectMapper.getByCondition(tbProject);
        byCondition.forEach(System.out::println);
    }
    @Test
    void test5() {
        TbProject byId = projectMapper.getById(22);
        System.out.println(byId);
    }

}
