package com.woniuxy.batchservice.jilianutils.service.imp;

import com.woniuxy.batchservice.jilianutils.entity.*;
import com.woniuxy.batchservice.jilianutils.mapper.HouseMapper;
import com.woniuxy.batchservice.jilianutils.mapper.ProjectMapper;
import com.woniuxy.batchservice.jilianutils.service.JilianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JilianServiceImp implements JilianService {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    HouseMapper houseMapper;

    @Override
    public List<Project> getJilLianProject() {
        List<Project> projects = projectMapper.getAll();
        Iterator<Project> projectIterator = projects.iterator();
        while (projectIterator.hasNext()) {
            Project project = projectIterator.next();
            List<House> houses = houseMapper.getByProjectId(project.getValue());
            //该项目下面的楼栋
            Set<LouDong> louDongs = chuLiHouse(houses);
            project.setChildren(louDongs);
        }
        return projects;
    }

    public Set<LouDong> chuLiHouse(List<House> houses) {
        Set<LouDong> louDongs = new HashSet<>();
//筛选该项目有哪些楼栋
        for (House house : houses) {
            LouDong louDong = new LouDong();
            louDong.setLabel(house.getBuildingNumber());
            louDong.setValue(house.getBuildingId());
            louDongs.add(louDong);

        }
//筛选每栋有哪些单元门
        louDongs.forEach(r -> {
            Set<DanYuanMen> danYuanMen = new HashSet<>();
            for (House house : houses) {
                if (house.getBuildingId() == r.getValue()) {
                    DanYuanMen danYuanMen1 = new DanYuanMen();
                    danYuanMen1.setLabel(house.getUnit());
                    danYuanMen.add(danYuanMen1);
                }
            }
            r.setChildren(danYuanMen);
        });
//筛选过每个单元门的住户
        louDongs.forEach(r -> {
            r.getChildren().forEach(l -> {
                List<FangJianNumber> fangJianNumbers = new ArrayList<>();
                houses.forEach(h -> {
                    if (h.getUnit().equals(l.getLabel()) && h.getBuildingId() == r.getValue()) {
                        FangJianNumber fangJianNumber = new FangJianNumber();
                        fangJianNumber.setLabel(h.getHouseNumber());
                        fangJianNumber.setValue(h.getHouseId());
                        List<ZhuHu>zhuHus=new ArrayList<>();
                        ZhuHu zhuHu=new ZhuHu();
                        zhuHu.setValue(h.getClientId());
                        zhuHu.setLabel(h.getClientName());
                        zhuHus.add(zhuHu);
                        fangJianNumber.setChildren(zhuHus);
                        fangJianNumbers.add(fangJianNumber);
                    }
                });
                l.setChildren(fangJianNumbers);
            });


        });


        return louDongs;
    }
}
