package com.example.graphql.user;

import com.example.graphql.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {

    private String name;
    private String email;

    public User toEntity(){
        return User.builder()
                .email(email)
                .name(name)
                .build();
    }
}
