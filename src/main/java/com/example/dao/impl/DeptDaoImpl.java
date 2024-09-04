package com.example.dao.impl;

import com.example.dao.DeptDao;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class DeptDaoImpl implements DeptDao {
    public List<String> list() throws IOException {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        List<String> readLines = IOUtils.readLines(stream, "UTF-8");

        return readLines;
    }

}
