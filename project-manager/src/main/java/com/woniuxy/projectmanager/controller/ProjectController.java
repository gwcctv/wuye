package com.woniuxy.projectmanager.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.woniuxy.projectmanager.service.ProjectService;
import com.woniuxy.projectmanager.vo.ProjectVo;
import com.woniuxy.wuye.common.entity.TbProject;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    /**
     * 项目列表 分页，默认首页
     * @param projectVo
     * @return
     */
    //@CrossOrigin
    @PostMapping("/list")
    public ResponseEntity list(@RequestBody ProjectVo projectVo){
        PageBean<TbProject> byCondition =
                projectService.getByCondition(projectVo.getTbProject(), projectVo.getPageSize(),projectVo.getPage());
        return new ResponseEntity("200","ok",byCondition);
    }

    /**
     * 得到所有项目名
     * @return
     */
    @RequestMapping("/getName")
    public ResponseEntity projectName(){
        List<TbProject> all = projectService.getAll();
//        List<String> projectNames=new ArrayList<>();
//        for(TbProject p:all){
//         projectNames.add(p.getProjectName());
//        }
        return new ResponseEntity("200","ok",all);
    }

    /**
     * 增加项目
     * @param tbProject
     * @return
     */
    @RequestMapping("/add")
    public ResponseEntity add(@RequestBody TbProject tbProject){
        projectService.insert(tbProject);
        return ResponseEntity.SUCCESS;
    }

    /**
     * 删除项目
     * @param projectId
     * @return
     */
    @RequestMapping("/delete/{projectId}")
    public  ResponseEntity delete(@PathVariable int projectId){
        projectService.delete(projectId);
        return  ResponseEntity.SUCCESS;
    }

    /**
     * 点击修改按钮，弹窗出现，展示点击项目的各字段
     * @param projectId
     * @return
     */
    @RequestMapping("/update/{projectId}")
    public ResponseEntity update(@PathVariable int projectId){
        TbProject byId = projectService.getById(projectId);
        return new ResponseEntity("200","ok",byId);
    }

    /**
     * 执行修改操作
     * @param tbProject
     * @return
     */
    @RequestMapping("/doupdate")
    public  ResponseEntity doUpdate(@RequestBody TbProject tbProject){
        projectService.update(tbProject);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("/name")
    public int name(@RequestParam String name){
        int byName = projectService.getByName(name);
        return byName;
    }
}
