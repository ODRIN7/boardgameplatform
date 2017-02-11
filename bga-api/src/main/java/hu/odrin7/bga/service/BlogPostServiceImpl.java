package hu.odrin7.bga.service;

import com.google.common.collect.Lists;
import hu.odrin7.bga.domain.blog.BlogPost;
import hu.odrin7.bga.domain.blog.BlogPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPostServiceImpl() {
    }

    @Override
    public void fillData() {
        List<BlogPost> posts = this.getPosts();
        if (posts.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                BlogPost post = new BlogPost("Sample blog post title #" + i, "Sample blog post content #" + i);
                blogPostRepository.save(post);
                log.warn(post.toString());
            }
        }
    }

    @Override
    public List<BlogPost> getPosts() {
        return Lists.newArrayList(blogPostRepository.findAll());
    }

    @Override
    public BlogPost savePost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public BlogPost deletePost(Long postId) {
        BlogPost blogPost = blogPostRepository.findOne(postId);
        if (blogPost != null) {
            blogPostRepository.delete(blogPost);
        }
        return blogPost;
    }
}
