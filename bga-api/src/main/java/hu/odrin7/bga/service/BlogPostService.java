package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.blog.BlogPost;
import hu.odrin7.bga.domain.user.User;

import java.util.List;

public interface BlogPostService {

    void fillData();
    List<BlogPost> getPosts();
    BlogPost savePost(BlogPost blogPost);
    BlogPost deletePost(Long postId);

}
