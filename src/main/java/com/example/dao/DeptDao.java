package com.example.dao;

import java.io.IOException;
import java.util.List;

public interface DeptDao {
    List<String> list() throws IOException;
}
