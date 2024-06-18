package org.bite.recaptcha.mapper;


import org.apache.ibatis.annotations.*;
import org.bite.recaptcha.model.UserInfo;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-17
 * Time: 23:33
 */
@Mapper
public interface UserMapper {

    @Select("select id, username, password, age, gender, phone as phoneNumber, delete_flag as deleteFlag , create_time as createTime, update_time as updateTime " +
            "from userinfo")
    List<UserInfo> getUsers();

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into userinfo (username,password,age) values (#{user.username}, #{user.password},#{user.age})")
//这里很奇怪，因为这些都是私有属性。
    void insertUser(@Param("user") UserInfo userInfo);


    @Results(id = "userMap", value = {
            @Result(column = "phone", property = "phoneNumber"),
    })
    @Select("select * from userinfo")
    List<UserInfo> getAllUsers();

    @ResultMap("userMap")
    @Select("select create_time from userinfo")
    List<UserInfo> getAllCreateTime();
}
