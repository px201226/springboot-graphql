package com.example.graphql.domain.input;

import com.example.graphql.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
