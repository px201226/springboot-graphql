package com.example.graphql.comment;

import com.example.graphql.post.Post;
import com.example.graphql.user.User;
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
