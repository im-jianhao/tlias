package com.tlias.service;

import com.tlias.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void deleteById(Integer id);

    void insert(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
