package comben.blog.mapper;

import comben.blog.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-27
 * Time: 23:36
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where user_name = #{userName} and delete_flag = 0")
    public UserInfo getUserByName(String userName);
    @Select("select * from user where id = #{id} and delete_flag = 0")
    public UserInfo getUserById(Integer id);
}
