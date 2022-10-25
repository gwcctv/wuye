package com.woniuxy.projectmanager.provider;

import com.woniuxy.wuye.common.entity.TbProject;
import org.apache.ibatis.jdbc.SQL;

/**
 * 多条件修改字段
 */
public class ProjectProvider {
    /**
     * 多条件修改
     * @param tbProject
     * @return
     */
    public String update(TbProject tbProject){
        return new SQL(){
            {
                UPDATE("tb_project");
                if(tbProject.getProjectName()!=null){
                    SET("project_name=#{projectName}");
                }
                if(tbProject.getAffiliation()!=null){
                    SET("affiliation=#{affiliation}");
                }
                if(tbProject.getProjectType()!=null){
                    SET("project_type=#{projectType}");
                }
                if(tbProject.getConstructionDate()!=null){
                    SET("construction_date=#{constructionDate}");
                }
                if(tbProject.getArea()!=null){
                    SET("area=#{area}");
                }
                if(tbProject.getAddress()!=null){
                    SET("address=#{address}");
                }
                if(tbProject.getProjectHead()!=null){
                    SET("project_head=#{projectHead}");
                }
                if(tbProject.getHeadPhone()!=null){
                    SET("head_phone=#{headPhone}");
                }
                if(tbProject.getTakeoverDate()!=null){
                    SET("takeover_date=#{takeoverDate}");
                }
                if(tbProject.getState()!=null){
                    SET("state=#{state}");
                }
                WHERE("project_id=#{projectId}");
            }

        }.toString();
    }

    /**
     * 多条件查询
     * @param tbProject
     * @return
     */
    public String select(TbProject tbProject){
        if(tbProject==null){
            return new SQL(){
                {
                    SELECT("*");
                    FROM("tb_project");
                }
            }.toString();
        }else {
            return new SQL(){
                {
                    SELECT("*");
                    FROM("tb_project");
                    if(tbProject.getProjectId()!=null){
                        WHERE("project_id=#{projectid}");
                    }
                    if(tbProject.getProjectName()!=null&& ! "".equals(tbProject.getProjectName())){
                        WHERE("project_name=#{projectName}");
                    }
                    if(tbProject.getAffiliation()!=null){
                        WHERE("affiliation=#{affiliation}");
                    }
                    if(tbProject.getProjectType()!=null&& !"".equals(tbProject.getProjectType())){
                        WHERE("project_type=#{projectType}");
                    }
                    if(tbProject.getConstructionDate()!=null){
                        WHERE("construction_date=#{constructionDate}");
                    }
                    if(tbProject.getArea()!=null){
                        WHERE("area=#{area}");
                    }
                    if(tbProject.getAddress()!=null){
                        WHERE("address=#{address}");
                    }
                    if(tbProject.getProjectHead()!=null){
                        WHERE("project_head=#{projectHead}");
                    }
                    if(tbProject.getHeadPhone()!=null){
                        WHERE("head_phone=#{headPhone}");
                    }
                    if(tbProject.getTakeoverDate()!=null){
                        WHERE("takeover_data=#{takeoverDate}");
                    }
                    if(tbProject.getState()!=null&&!"".equals(tbProject.getState())){
                        WHERE("state=#{state}");
                    }
                }
            }.toString();
        }
    }
}
