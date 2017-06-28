import com.cyh.blog.entity.Blog;
import com.cyh.blog.service.impl.BlogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cyh3101 on 2017/6/18.
 */
public class BlogTest extends  BaseTest{
    @Autowired
    private BlogService blogService;

    @Test
    public void testGetBlogByTitle(){
        Blog blog = this.blogService.getBlogByTitle("tset");
        System.out.println(blog.toString());
    }

    @Test
    public void testGetBlogList(){
        List<Blog> blogs = this.blogService.getAllBlog();
        if(blogs != null && !blogs.isEmpty()){
            Iterator it = blogs.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
        }
    }
}
