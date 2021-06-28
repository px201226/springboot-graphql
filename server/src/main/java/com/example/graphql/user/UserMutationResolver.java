package com.example.graphql.user;

import com.example.graphql.security.JwtTokenProvider;
import com.example.graphql.user.User;
import com.example.graphql.user.UserRepository;
import com.example.graphql.user.UserInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class UserMutationResolver implements GraphQLMutationResolver {

    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public User addUser(UserInput userInput){
         return userRepository.saveAndFlush(userInput.toEntity());
    }

    public String login(String name, String password){
        System.out.println("dddddd");
        System.out.println(name);
        User user = userService.findByUserName(name);
        String token = jwtTokenProvider.createToken(user.getName(), Collections.emptyList());

        return token;
    }
}
