package com.example.service.impl;

import com.example.mapper.EmpLogMapper;
import com.example.pojo.EmpLog;
import com.example.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {
    @Autowired
    private EmpLogMapper empLogMapper;

    /**
     * 员工操作日志-插入
     * @param empLog
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
