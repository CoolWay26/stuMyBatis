package com.coolway.dao;

import com.coolway.bean.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    Student queryStudentById(String id);
    List<Student> queryStudentByMap(HashMap map);
    Map queryStudentMapById(String id);
}
