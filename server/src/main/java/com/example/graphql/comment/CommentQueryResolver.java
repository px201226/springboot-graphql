package com.example.graphql.comment;

import com.example.graphql.comment.Comment;
import com.example.graphql.comment.CommentRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
@Component
public class CommentQueryResolver implements GraphQLQueryResolver {

    private final CommentRepository commentRepository;

    public List<Comment> comments(){
        return commentRepository.findAll();
    }
}
