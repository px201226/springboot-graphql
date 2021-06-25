package com.example.graphql.post;

import com.example.graphql.post.Post;
import com.example.graphql.post.PostRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
@Component
public class PostQueryResolver implements GraphQLQueryResolver {

    private final PostRepository postRepository;

    public List<Post> posts(DataFetchingEnvironment environment){
        return postRepository.findAll();
    }
}
