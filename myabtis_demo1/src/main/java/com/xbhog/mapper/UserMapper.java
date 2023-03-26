package com.xbhog.mapper;

import com.xbhog.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xbhog
 */
public interface UserMapper {
    int insertUser();
    /**
     * 根据id查询用户信息
     */
    List<User> getUserAll();
    User getUserByName(String name);
    User getUserByNameAndPwd(String name,String pwd);
    User checkLogin(Map map);
    int insertUserByUser(User user);
    /*mybatis会把param中的username当作key,String后面的作为value*/
    User getUserByParams(@Param("username") String username);

    int getCount();

//    以MapKey设置的字段为key,map中的key不能重复，所以选择id作为key,

    List<Map<String,Object>> getUserToMap();
    List<User> testMohu(@Param("mohu") String mohu);
    /**
     * 批量删除
     */
    int deleteAll(@Param("ids") String ids);
    /**
     * 动态设置表名
     */
    List<User> getAllByTableName(@Param("tableName") String tableName);
    /**
     * 自增主键获取
     */
    int insertUserKey(User user);

    User getDemo(User user);

    Integer insertAllUser(@Param("users") List<User> users);

    Integer deleteAllUser(@Param("userIds") List<Integer> userIds);

    List<User> getAllUser(@Param("id") Integer id);
}
