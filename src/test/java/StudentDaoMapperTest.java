import com.coolway.bean.Student;
import com.coolway.dao.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        //创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlsessionFactory
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void queryStudentByIdTest() {
        //获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        //从sqlSession中获取Mapper接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.queryStudentById("20200001");
        System.out.println(student.getName());
        sqlSession.close();
    }

    @Test
    public void queryStudentByMap() {
        //获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        //从sqlSession中获取Mapper接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        HashMap map = new HashMap();
//        map.put("name", "hh");
        map.put("age", 18);
        List<Student> studentList = studentMapper.queryStudentByMap(map);
        if (studentList.size()>0) {
            for (Student student: studentList) {
                System.out.println(student.getName());
            }
        } else {
            System.out.println("没有查询到结果");
        }
    }

    @Test
    public void queryStudentMapById() {
        //获取sqlSession，和spring整合后由spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        //从sqlSession中获取Mapper接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Map map = studentMapper.queryStudentMapById("20200001");
        System.out.println(map.get("name"));
    }
}
