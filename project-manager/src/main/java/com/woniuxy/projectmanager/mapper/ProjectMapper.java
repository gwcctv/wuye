package com.woniuxy.projectmanager.mapper;

import com.woniuxy.projectmanager.provider.ProjectProvider;
import com.woniuxy.wuye.common.entity.TbProject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectMapper {
    /**
     * 增加项目
     * @param tbProject
     */
    @Insert("insert into tb_project(project_name,project_type, affiliation, construction_date,area,address,project_head,head_phone," +
            "takeover_date,state ) values (#{projectName},#{projectType},#{affiliation},#{constructionDate},#{area},#{address},#{projectHead}," +
            "#{headPhone},#{takeoverDate},#{state})")
    void insert(TbProject tbProject);
    /**
     * 删除项目
     */
    @Delete("delete from tb_project where project_id=#{id}")
    void  delete (Integer id);
    /**
     * 多条件修改
     */
    @UpdateProvider(value = ProjectProvider.class,method = "update")
    void updeta(TbProject tbProject);
    /**
     *查询所有项目
     */
    @Select("select * from tb_project")
    List<TbProject> getAll();

    /**
     * 多条件查询
     * @param tbProject
     * @return
     */
    @SelectProvider(value = ProjectProvider.class ,method = "select")
    List<TbProject> getByCondition(TbProject tbProject);

    /**
     * 根据id找项目
     * @param id
     * @return
     */
    @Select("select * from tb_project where project_id=#{id}")
    TbProject getById(Integer id);
    @Select("select project_id from tb_project where project_name=#{name}")
    int getByName(String name);
}
