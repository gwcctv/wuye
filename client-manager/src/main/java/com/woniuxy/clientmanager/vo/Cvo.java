package com.woniuxy.clientmanager.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author li
 * @data 2022/10/27{} 14:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cvo {
    private String projectName;
    private int page;
    private int size;
}
