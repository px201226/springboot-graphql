package com.example.graphql.comment;

import com.example.graphql.comment.Comment;
import com.example.graphql.post.Post;
import com.example.graphql.user.User;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class CommentResolver implements GraphQLResolver<Comment> {

    public User user(Comment comment){
        return comment.getUser();
    }

    public Post post(Comment comment){
        return comment.getPost();
    }
}
