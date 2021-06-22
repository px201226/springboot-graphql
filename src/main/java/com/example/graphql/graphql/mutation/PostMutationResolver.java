package com.example.graphql.graphql.mutation;

import com.example.graphql.domain.Post;
import com.example.graphql.domain.PostRepository;
import com.example.graphql.domain.User;
import com.example.graphql.domain.UserRepository;
import com.example.graphql.domain.input.PostInput;
import com.example.graphql.domain.input.UserInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostMutationResolver implements GraphQLMutationResolver {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Post addPost(PostInput postInput){
        User user = userRepository.findById(postInput.getUserId()).orElseThrow(RuntimeException::new);
        return postRepository.save(postInput.toEntity(user));
    }
}
