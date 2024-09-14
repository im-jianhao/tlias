package com.tlias.mapper;

import com.tlias.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 声明当前接口是mybatis的持久层接口，框架运行时，会自动为该接口生成一个实现类对象（基于动态代理实现的代理对象），并且交给IOC容器管理
public interface UserMapper {

    // @Select("select * from user")
    public List<User> findAll();
}
