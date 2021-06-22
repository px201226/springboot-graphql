package com.example.graphql.graphql.mutation;

import com.example.graphql.domain.*;
import com.example.graphql.domain.input.CommentInput;
import com.example.graphql.domain.input.PostInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMutationResolver implements GraphQLMutationResolver {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public Comment addComment(CommentInput commentInput){
        User user = userRepository.findById(commentInput.getUserId()).orElseThrow(RuntimeException::new);
        Post post = postRepository.findById(commentInput.getPostId()).orElseThrow(RuntimeException::new);
        return commentRepository.save(commentInput.toEntity(user,post));
    }
}
