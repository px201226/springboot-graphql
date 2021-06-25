package com.example.graphql.post;

import com.example.graphql.post.Post;
import com.example.graphql.post.PostRepository;
import com.example.graphql.user.User;
import com.example.graphql.user.UserRepository;
import com.example.graphql.post.PostInput;
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
