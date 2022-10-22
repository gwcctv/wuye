package com.woniuxy.buildingmanager.controller;

import com.woniuxy.buildingmanager.service.BuildingService;
import com.woniuxy.buildingmanager.vo.BuildingVo;

import com.woniuxy.wuye.common.entity.TbBuilding;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    BuildingService buildingService;
    @Autowired
    ProjectFeign projectFeign;

    /**
     * 多条件分页查询。默认首页，条件为空
     * @param buildingVo
     * @return
     */
    @RequestMapping("/list")
    public ResponseEntity list(@RequestBody BuildingVo buildingVo){
        PageBean<TbBuilding> byCondition =
                buildingService.getByCondition(buildingVo.getTbBuilding(), buildingVo.getPageSize(),buildingVo.getPage());
        return new ResponseEntity("200","ok",byCondition);
    }

    /**
     * 增加楼栋
     * @param tbBuilding
     * @return
     */
    @RequestMapping("/add")
    public ResponseEntity add(@RequestBody TbBuilding tbBuilding){
        //前端增加项目名，然后数据库中增加的是项目id
        //增加楼栋肯定有他的所属项目名，所以这里不进行非空判断
        String projectName = tbBuilding.getProjectName();
        //然后通过项目名查出项目主键
        int projectId = projectFeign.getByName(projectName);
        tbBuilding.setProjectId(projectId);
        buildingService.insert(tbBuilding);
        return ResponseEntity.SUCCESS;
    }

    /**
     * 通过id删除楼栋
     * @param buildingId
     * @return
     */
    @RequestMapping("/delete/{buildingId}")
    public ResponseEntity delete(@PathVariable int buildingId){
        buildingService.delete(buildingId);
        return ResponseEntity.SUCCESS;
    }

    /**
     * 点击修改，弹窗显示先展示修改列的全部数据
     * @param buildingId
     * @return
     */
    @RequestMapping("/update/{buildingId}")
    public ResponseEntity update(@PathVariable int buildingId){
        TbBuilding tbBuilding=new TbBuilding();
        tbBuilding.setBuildingId(buildingId);
        List<TbBuilding> byCondition = buildingService.getByCondition(tbBuilding);
        return new ResponseEntity("200","ok",byCondition);
    }

    /**
     * 执行修改操作
     * @param tbBuilding
     * @return
     */
    @RequestMapping("/doupdate")
    public  ResponseEntity doUpdate(@RequestBody TbBuilding tbBuilding){
        //这里注意修改的buidlingId
        buildingService.update(tbBuilding);
        return ResponseEntity.SUCCESS;
    }

}
