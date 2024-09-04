package com.example.service;

import com.example.pojo.Dept;

import java.io.IOException;
import java.util.List;

public interface DeptService {
    List<Dept> list() throws IOException;
}
