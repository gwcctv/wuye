package com.woniuxy.projectmanager.vo;

import com.woniuxy.wuye.common.entity.TbProject;
import lombok.Data;

@Data
public class ProjectVo {
    private TbProject tbProject;

    private Integer pageSize;
    private Integer page;
}
