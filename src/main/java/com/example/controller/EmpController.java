package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result<PageBean> query(EmpQueryParam empQueryParam) {
        log.info("分页参数：{}", empQueryParam);
        PageBean pageBean = empService.query(empQueryParam);
        return Result.success(pageBean);
    }

    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("员工新增参数：{}", emp);
        empService.add(emp);
        return Result.success();
    }
}
