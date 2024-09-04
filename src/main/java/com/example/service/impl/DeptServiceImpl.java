package com.example.service.impl;

import com.example.dao.impl.DeptDaoImpl;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDaoImpl deptDao;

    public List<Dept> list() throws IOException {
        //获取原始数据
        List<String> list = deptDao.list();
        //组装Dept
        List<Dept> deptList = list.stream().map(line -> {
            String[] split = line.split(",");
            Integer id = Integer.parseInt(split[0]);
            LocalDateTime localDateTime = LocalDateTime.parse(split[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return Dept.builder().id(id).name(split[1]).updateTime(localDateTime).build();
        }).collect(Collectors.toList());

        return deptList;
    }
}
