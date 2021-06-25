package com.example.graphql.comment;

import com.example.graphql.comment.Comment;
import com.example.graphql.comment.CommentRepository;
import com.example.graphql.comment.CommentInput;
import com.example.graphql.post.Post;
import com.example.graphql.post.PostRepository;
import com.example.graphql.user.User;
import com.example.graphql.user.UserRepository;
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
