package com.example.controller;

import com.example.pojo.Dept;
import com.example.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {
    @Qualifier("deptServiceImpl")
    @Autowired
    // @Resource
    private DeptServiceImpl deptService;

    @GetMapping("/depts")
    public List<Dept> query() throws Exception {
        List<Dept> deptList = deptService.list();

        return deptList;
    }
}
