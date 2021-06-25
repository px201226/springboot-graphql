package com.example.graphql.post;

import com.example.graphql.comment.Comment;
import com.example.graphql.post.Post;
import com.example.graphql.user.User;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class PostResolver implements GraphQLResolver<Post> {

    public User user(Post post){
        return post.getUser();
    }

    public List<Comment> comments(Post post){
        return post.getComments();
    }

}
