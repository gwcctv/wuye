package com.woniuxy.batchservice.jilianutils.entity;

import lombok.Data;

import java.util.List;

@Data
public class FangJianNumber {
    Integer value;
    String label;
  List<ZhuHu> children;
}
