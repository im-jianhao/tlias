package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Mapper
public interface EmpMapper {
    // @Select("select count(*) from emp")
    // Integer count();


    /**
     * 分页查询员工列表
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    List<Emp> query(EmpQueryParam empQueryParam);

    void insert(Emp emp);
}
