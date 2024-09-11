package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Slf4j
@RestController
public class DeptController {

    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result<List<Dept>> query() {
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 使用HttpServletRequest接收参数
     @DeleteMapping("/depts") public Result delete(HttpServletRequest request) {
     String id = request.getParameter("id");
     int i = Integer.parseInt(id);
     System.out.println(i);
     return Result.success(i);
     }
     */

    /**
     * 使用@RequestParam接收参数
     @DeleteMapping("/depts") public Result delete(@RequestParam(name = "id") Integer id) {
     System.out.println(id);
     return Result.success(id);
     }
     */

    /**
     * 部门删除接口
     */
    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        System.out.println(id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 部门新增接口
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        System.out.println(dept);
        deptService.insert(dept);
        return Result.success();
    }

    /**
     * 部门查询接口
     */
    @GetMapping("/depts/{id}")
    public Result<Dept> getById(@PathVariable Integer id) {
        System.out.println(id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 部门修改接口
     */
    @PutMapping("/depts")
    public Result<Dept> update(@RequestBody Dept dept) {
        System.out.println(dept);
        deptService.update(dept);
        return Result.success();
    }
}
