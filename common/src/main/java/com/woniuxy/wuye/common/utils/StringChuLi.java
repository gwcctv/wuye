package com.woniuxy.wuye.common.utils;

public class StringChuLi {
/**
 * 处理1,2,3,4 字符串 变为数字数组
 *
 * */
    public static int[] chuLi(String ids){
        String[] idsString=ids.split(",");
        int[] id=new int[idsString.length];
        for(int i=0;i<idsString.length;i++){
            id[i]=Integer.parseInt(idsString[i]);
        }
        return id;
    }
}
