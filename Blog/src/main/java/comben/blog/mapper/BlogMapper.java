package comben.blog.mapper;

import comben.blog.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-27
 * Time: 23:40
 */
@Mapper
public interface BlogMapper {
    @Select("select * from blog where delete_flag = 0")
    public List<Blog> selectAllBlog();

    @Select("select * from blog where delete_flag = 0 and id = #{id}")
    public Blog selectBlogById(Integer id);

    public Integer updateBlog(Blog blog);

    public Integer insertBlog(Blog blog);
}
