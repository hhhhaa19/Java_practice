package comben.blog.controller;

import comben.blog.model.Blog;
import comben.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-28
 * Time: 1:21
 */
@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping("/getList")
    public List<Blog> getList() {
        return blogService.selectAllBLogList();
    }

    @RequestMapping("/getBlogDetail")
    public Blog getBlogDetail(Integer blogId) {
        log.info("getBlogDetail blogId:{}", blogId);
        return blogService.selectBlogById(blogId);
    }

}
