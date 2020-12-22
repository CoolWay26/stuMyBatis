package com.coolway.dao;

import com.coolway.bean.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentDao {
    Student queryStudentById(String id);
    List<Student> queryStudentByMap(HashMap map);
}
