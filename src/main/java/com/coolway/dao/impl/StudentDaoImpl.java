package com.coolway.dao.impl;

import com.coolway.bean.Student;
import com.coolway.dao.StudentDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    SqlSession sqlSession;
    SqlSessionFactory sqlSessionFactory;

    //构造接收一个sqlSessionFactory，用来创建每个方法属于自己的sqlSession
    public StudentDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Student queryStudentById(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = sqlSession.selectOne("queryStudentById", id);
        sqlSession.close();
        return student;
    }

    public List<Student> queryStudentByMap(HashMap map) {
        if (map.size()>0) {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            List<Student> studentList = sqlSession.selectOne("queryStudentByMap", map);
            sqlSession.close();

        }
        return null;
    }
}
