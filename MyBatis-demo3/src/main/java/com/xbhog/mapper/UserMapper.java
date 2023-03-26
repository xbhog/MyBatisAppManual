package com.xbhog.mapper;

import com.xbhog.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xbhog
 * @date 2022/6/3
 */
public interface UserMapper {
    List<User> getUserInfo(User user);


}
