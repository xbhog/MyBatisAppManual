package com.mapper.test;

import com.xbhog.mapper.UserMapper;
import com.xbhog.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testMybatis(){
        //加载核心配置文件
        try {
            //字符流加载配置
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            //创建sql连接工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //创建session连接,设置true,默认提交事务
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            //反射获取类对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //执行sql
            //int i = mapper.insertUser();
            //手动提交事务
            //sqlSession.commit();
            /*List<User> userAll = mapper.getUserAll();
            userAll.forEach(System.out::println);*/
            //moreArgs(mapper);
            //mapArgs(mapper);
            //insertObject(mapper);
            //getParams(mapper);
            //getCount(mapper);
            //getUserToMap(mapper);
            //mohuTest(mapper);
            //batchDelete(mapper);
            //getDateByTableName(mapper);
            /*User ddd = new User(null, "dfsdf", "11111");
            int i = mapper.insertUserByUser(ddd);
            System.out.println(ddd);*/
            /*User xbhog = mapper.getDemo(new User(null, "xbhog", null,null));
            System.out.println(xbhog);*/
            User user1 = new User(null, "a1", 22, "aaa");
            User user2 = new User(null, "a2", 22, "aaa");
            User user3 = new User(null, "a3", 22, "aaa");
            List<User> users = Arrays.asList(user1, user2, user3);
            //Integer i = mapper.insertAllUser(users);
            List<Integer> userIds = Arrays.asList(10, 11, 12);
            Integer integer = mapper.deleteAllUser(userIds);
            System.out.println(integer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getDateByTableName(UserMapper mapper) {
        List<User> user = mapper.getAllByTableName("user");
        user.forEach(System.out::println);
    }

    private void batchDelete(UserMapper mapper) {
        int i = mapper.deleteAll("1,2,10");
        System.out.println(i);
    }

    private void mohuTest(UserMapper mapper) {
        List<User> xbhog = mapper.testMohu("x");
        System.out.println(xbhog);
    }

    private void getUserToMap(UserMapper mapper) {
        List<Map<String, Object>> userToMap = mapper.getUserToMap();
        System.out.println(userToMap);
    }

    private void getCount(UserMapper mapper) {
        int count = mapper.getCount();
        System.out.println(count);
    }

    private void getParams(UserMapper mapper) {
        User aaa = mapper.getUserByParams("aaa");
        System.out.println(aaa);
    }

    private void insertObject(UserMapper mapper) {
        int i = mapper.insertUserByUser(new User(null, "aaa", 22,null));
        System.out.println(i);
    }

    private void mapArgs(UserMapper mapper) {
        //Map<String, Object> map = Map.of("username","xbhog");
        Map<String, Object> map = new HashMap<>();
        map.put("username","xbhog");
        User user = mapper.checkLogin(map);
        System.out.println(user);
    }

    private void moreArgs(UserMapper mapper) {
        User userByName = mapper.getUserByName("xbhog");
        User userByNameAndPwd = mapper.getUserByNameAndPwd("xbhog", "14646");

        System.out.println(userByName + "----" + userByNameAndPwd);
    }
}
