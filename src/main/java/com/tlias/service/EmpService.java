package com.tlias.service;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import com.tlias.pojo.PageBean;

public interface EmpService {
    PageBean query(EmpQueryParam empQueryParam);

    void add(Emp emp);
}
