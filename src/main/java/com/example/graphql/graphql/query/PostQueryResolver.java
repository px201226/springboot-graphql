package com.example.graphql.graphql.query;

import com.example.graphql.domain.Post;
import com.example.graphql.domain.PostRepository;
import com.example.graphql.domain.User;
import com.example.graphql.domain.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
@Component
public class PostQueryResolver implements GraphQLQueryResolver {

    private final PostRepository postRepository;

    public List<Post> posts(){
        return postRepository.findAll();
    }
}
