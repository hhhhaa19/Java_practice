package org.ben.mybatisxml.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-18
 * Time: 23:20
 */
@Mapper
public interface UserMapper {
    @Select("select count(id) from userinfo")
    public Integer count();
}
