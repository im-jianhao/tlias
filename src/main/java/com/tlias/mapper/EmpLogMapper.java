package com.tlias.mapper;

import com.tlias.pojo.EmpLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpLogMapper {
    void insert(EmpLog empLog);
}
