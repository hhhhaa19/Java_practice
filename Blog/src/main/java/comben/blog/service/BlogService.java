package comben.blog.service;

import comben.blog.mapper.BlogMapper;
import comben.blog.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-28
 * Time: 1:22
 */
@Service
public class BlogService {
    @Autowired
    BlogMapper blogMapper;

    public List<Blog> selectAllBLogList() {
        return blogMapper.selectAllBlog();
    }

    public Blog selectBlogById(Integer id) {
        return blogMapper.selectBlogById(id);
    }
}
