package com.example.graphql.graphql;

import com.example.graphql.domain.Comment;
import com.example.graphql.domain.Post;
import com.example.graphql.domain.PostRepository;
import com.example.graphql.domain.User;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


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
