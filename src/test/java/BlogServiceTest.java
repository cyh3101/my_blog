import com.cyh.blog.entity.Blog;
import com.cyh.blog.service.impl.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by cai on 2017/6/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml",
        "classpath:blog-servlet.xml","classpath:spring/springmvc.xml"})
public class BlogServiceTest {
    @Autowired
    private BlogService blogService;

    @Test
    public void testBlogService(){
        List<Blog> blogs = blogService.getAllBlog();
        System.out.println(blogs);
    }
}
