package hu.odrin7.bga.service;

import hu.odrin7.bga.domain.blog.BlogPost;

import java.util.List;

/**
 * Created by ODRIN7_asus on 2017. 02. 11..
 */
public interface GameService {

    void fillData();
    List<BlogPost> getPosts();
    BlogPost savePost(BlogPost blogPost);
    BlogPost deletePost(Long postId);
}
