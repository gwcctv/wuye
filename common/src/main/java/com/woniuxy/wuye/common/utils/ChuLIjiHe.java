package com.woniuxy.wuye.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ChuLIjiHe {
    /**
     * 此方法针对界面展示一个类型展示多个项目
     * 名称             项目
     * w               A、B、C
     * X               A、C
     *
     *
     *
     *        参数 zhuJianName：主键名
     *            nameBiaoZhuJianName 项目这个表中的主键列名
     *            nameBiaoZhuJianNames 展示项目A、B、C主键这个List集合属性名字
     *            name项目这个列名
     *            names展示项目A、B、C主这个List集合属性名字
     * */
    public static  <T> List<T> get(List<T> ts ,String zhuJianName,String nameBiaoZhuJianName,String nameBiaoZhuJianNames,String name,String names) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        for(int i=0;i<ts.size();i++){
            Class c=ts.get(i).getClass();
            //获取实例对象
            Object obj=ts.get(i);
            //获取属性ID
            Field fieldId= c.getDeclaredField(zhuJianName);
            fieldId.setAccessible(true);
            Integer id= (Integer) fieldId.get(obj);
            Field fieldProjectName=c.getDeclaredField(name);
            fieldProjectName .setAccessible(true);
            //项目名属性值
            Object oProjectName=fieldProjectName.get(obj);
            Field filedListProjectNames=c.getDeclaredField(names);
            filedListProjectNames.setAccessible(true);
            //获取之前list中的projectNames 这个list属性值
            List<String> projectNames= (List<String>) filedListProjectNames.get(obj);
            if(projectNames==null){
                projectNames=new ArrayList<>();
            }
            projectNames.add((String)oProjectName );
            //获取之前list中的projectIds 这个list属性
            Field filedProjectIds=c.getDeclaredField(nameBiaoZhuJianNames);
            filedProjectIds. setAccessible(true);
            List<Integer> projectIds=(List<Integer>) filedProjectIds.get(obj);
            if(projectIds==null){
                projectIds=new ArrayList<>();
            }
            //获取projectId属性值
            Field fieldProjectId=c.getDeclaredField(nameBiaoZhuJianName);
            fieldProjectId.setAccessible(true);
            projectIds.add((Integer)fieldProjectId.get(obj) );
            filedProjectIds.set(obj,projectIds);
            for(int j=i+1;j<ts.size();j++){
                Class c1=ts.get(j).getClass();
                Object obj1=ts.get(j);
                Field fieldId1= c1.getDeclaredField(zhuJianName);
                fieldId1.setAccessible(true);
                if(fieldId1.get(obj1)==id){
                    Field fieldProjectName1=c1.getDeclaredField(name);
                    fieldProjectName1 .setAccessible(true);
                    Object oProjectName1=fieldProjectName1.get(obj1);
                    //projectNames添加属性
                    projectNames.add((String)oProjectName1 );
                    //属性赋值
                    filedListProjectNames.set(obj,projectNames);
                    Field fieldProjectId1=c1.getDeclaredField(nameBiaoZhuJianName);
                    fieldProjectId1.setAccessible(true);
                    projectIds.add((Integer)fieldProjectId1.get(obj1) );
                    filedProjectIds.set(obj,projectIds);
                    ts.remove(j);
                    j--;
                }
            }
        }
        return  ts;
    }
}
