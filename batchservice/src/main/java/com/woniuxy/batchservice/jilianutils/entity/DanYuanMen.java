package com.woniuxy.batchservice.jilianutils.entity;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class DanYuanMen {
    Integer value;
    String label;

List<FangJianNumber>children;

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        DanYuanMen that = (DanYuanMen) o;
        return label.equals(that.label);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
