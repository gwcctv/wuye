package com.woniuxy.batchservice.jilianutils.mapper;

import com.woniuxy.batchservice.jilianutils.entity.Project;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectMapper {
   @Select("SELECT project_id id,project_name NAME FROM tb_project")
   @Results({
        @Result(column = "id",property = "value"),
        @Result(column = "Name",property = "label")
   })
    List<Project> getAll();
}
