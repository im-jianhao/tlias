package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageBean;

import java.time.LocalDate;

public interface EmpService {
    PageBean query(EmpQueryParam empQueryParam);

    void add(Emp emp);
}
