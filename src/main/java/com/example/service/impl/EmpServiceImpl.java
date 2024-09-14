package com.example.service.impl;

import com.example.mapper.EmpExprMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.*;
import com.example.service.EmpLogService;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageBean query(EmpQueryParam empQueryParam) {
        //获取total
        // Integer total = empMapper.count();
        //获取rows
        // List<Emp> empList = empMapper.query((page - 1) * pageSize, pageSize);

        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> empList = empMapper.query(empQueryParam);
        Page<Emp> p = (Page<Emp>) empList;

        return new PageBean(p.getTotal(), p.getResult());
    }

    /**
     * 员工新增
     * @param emp
     */
    @Transactional
    public void add(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            //插入员工基本信息
            empMapper.insert(emp);
            // 判断empExprList是否为空，如果不为空，则批量插入
            List<EmpExpr> empExprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(empExprList)) {
                empExprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                //插入员工履历
                empExprMapper.insertBatch(empExprList);
            }
        } finally {
            //记录日志
            //开启新事务
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), emp.toString());
            empLogService.insert(empLog);
        }

    }
}
