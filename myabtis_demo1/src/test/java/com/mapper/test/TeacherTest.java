package com.mapper.test;

import com.xbhog.mapper.TeacherMapper;
import com.xbhog.mapper.UserMapper;
import com.xbhog.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TeacherTest {
    @Test
    public void demo() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建sql连接工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建session连接,设置true,默认提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //反射获取类对象
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher t1 = new Teacher(null, "aaa");
        mapper.insertDemo(t1);
        System.out.println(t1);
    }
}
