package com.example.graphql.domain.input;

import com.example.graphql.domain.Comment;
import com.example.graphql.domain.Post;
import com.example.graphql.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentInput {

    private String title;
    private Long userId;
    private Long postId;

    public Comment toEntity(User user, Post post){
        return Comment.builder()
                .post(post)
                .user(user)
                .title(title)
                .build();
    }
}
