package org.example.booksmanagementsystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.booksmanagementsystem.model.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-21
 * Time: 10:31
 */
@Mapper
public interface UserMapper {

    @Select("select user_name , password from user_info where user_name = #{userName}")
    User selectUserByUserName(String userName);

    @Insert("insert into user_info (user_name,password) values (#{userName},#{password})")
    Integer insertUser(User user);
}
