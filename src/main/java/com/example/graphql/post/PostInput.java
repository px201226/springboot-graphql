package com.example.graphql.post;

import com.example.graphql.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostInput {

    private String title;
    private Long userId;

    public Post toEntity(User user){
        return Post.builder()
                .title(title)
                .user(user)
                .build();
    }
}
