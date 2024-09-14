package com.tlias.mapper;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

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
