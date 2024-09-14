package com.tlias.controller;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import com.tlias.pojo.PageBean;
import com.tlias.pojo.Result;
import com.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
