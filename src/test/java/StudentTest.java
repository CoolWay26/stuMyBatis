import com.coolway.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        long id = 20200001;

        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 3. 创建SqlSessionFactory对象
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void testQueryUserById() throws Exception {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行查询，获取结果Student
        // 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
        //通过id查询
//        Student student = sqlSession.selectOne("queryStudentById", 20200001l);
//        System.out.println(student.getName());
        //通过name模糊查询
//        List<Student> studentList = sqlSession.selectList("queryStudentByName", "张");
//        for (Student studentTemp : studentList) {
//            System.out.println("\t" + studentTemp.getName());
//        }
        //插入Student
//        Student student = new Student();
//        student.setId("20200008");
//        student.setName("李四");
//        sqlSession.insert("insertStudent", student);
//        //修改数据库的操作要提交事务，否则无效
//        sqlSession.commit();
        //修改Student
//        Student student = sqlSession.selectOne("queryStudentById", "20200001");
//        student.setName("hh");
//        sqlSession.update("updateStudent",student);
//        sqlSession.commit();
        //删除Student
        sqlSession.delete("deleteStudent", "20200008");
        sqlSession.commit();
        // 7. 释放资源
        sqlSession.close();


    }
}
