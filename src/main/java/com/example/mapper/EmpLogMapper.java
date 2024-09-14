package com.example.mapper;

import com.example.pojo.EmpLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpLogMapper {
    void insert(EmpLog empLog);
}
