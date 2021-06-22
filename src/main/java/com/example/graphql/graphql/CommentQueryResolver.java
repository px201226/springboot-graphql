package com.example.graphql.graphql;

import com.example.graphql.domain.Comment;
import com.example.graphql.domain.CommentRepository;
import com.example.graphql.domain.User;
import com.example.graphql.domain.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Component
public class CommentQueryResolver implements GraphQLQueryResolver {

    private final CommentRepository commentRepository;

    public List<Comment> comments(){
        return commentRepository.findAll();
    }
}
