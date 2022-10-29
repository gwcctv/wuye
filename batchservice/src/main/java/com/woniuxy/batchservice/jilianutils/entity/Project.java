package com.woniuxy.batchservice.jilianutils.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class Project {

    Integer value;

    String label;
    Set<LouDong> children;


}
