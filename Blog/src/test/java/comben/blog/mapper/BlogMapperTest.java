package comben.blog.mapper;

import comben.blog.model.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-28
 * Time: 0:25
 */
@SpringBootTest
class BlogMapperTest {
    @Autowired
    private BlogMapper blogMapper;

    @Test
    void selectAllBlog() {
        List<Blog> blogs = blogMapper.selectAllBlog();
        System.out.println(blogs);
    }

    @Test
    void selectBlogById() {
        Blog blog = blogMapper.selectBlogById(1);
        System.out.println(blog);
    }

    @Test
    void updateBlog() {
        Blog blog = new Blog();
        blog.setId(1);
        blog.setDeleteFlag(1);
        System.out.println(blogMapper.updateBlog(blog));
    }

    @Test
    void insertBlog() {
        Blog blog = new Blog();
        blog.setTitle("ben");
        blog.setContent("I am here, always");
        System.out.println(blogMapper.insertBlog(blog));
    }
}