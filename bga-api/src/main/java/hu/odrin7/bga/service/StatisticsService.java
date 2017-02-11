package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.blog.BlogPost;

import java.util.List;

public interface StatisticsService {

    void fillData();
    List<BlogPost> getPosts();
    BlogPost savePost(BlogPost blogPost);
    BlogPost deletePost(Long postId);
}
