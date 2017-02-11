package hu.odrin7.bga.Controller;


import hu.odrin7.bga.domain.blog.BlogPost;
import hu.odrin7.bga.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController
@RequestMapping("/posts")
public class BlogPostRestController {

    @Autowired
    private BlogPostService blogPostService;

    public BlogPostRestController() {
    }

    @PostConstruct
    public void fillData() {
        blogPostService.fillData();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<BlogPost> getPosts() {
       return blogPostService.getPosts();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BlogPost savePost(@RequestBody BlogPost blogPost) {
       return blogPostService.savePost(blogPost);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    public BlogPost deletePost(@PathVariable("postId") Long postId) {
      return blogPostService.deletePost(postId);
    }

}
