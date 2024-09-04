package com.example.controller;

import java.sql.*;

public class JDBC {
    public void test() throws Exception {
        //1. 准备工作
        //1.1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //1.2、获取数据库链接对象Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tlias", "root", "root");

        //1.3、获取执行sql语句的对象preparedStatement
        // PreparedStatement preparedStatement = connection.prepareStatement("select * from dept where username = ?");
        // preparedStatement.setString(1, "admin");
        // preparedStatement.executeQuery();
        //
        // preparedStatement.close();
        // connection.close();

        //1.3、获取执行sql语句的对象Statement
        Statement statement = connection.createStatement();
        //2. 执行SQL
        // statement.execute("insert into dept values(null,'test','test')");
        ResultSet resultSet = statement.executeQuery("select * from dept");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int id = resultSet.getInt("id");
        }
        //3. 释放资源
        statement.close();
        connection.close();
    }
}
