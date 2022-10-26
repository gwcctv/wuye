package com.woniuxy.batchservice.jilianutils.entity;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class LouDong {
    Integer  value;
    String label;
    Set<DanYuanMen> children;
    @Override
    public int hashCode() {
        return 10;
    }
    @Override
    public boolean equals(Object obj) {
        LouDong louDong=(LouDong)obj;
        return (this.value == louDong.value);
    }
}
