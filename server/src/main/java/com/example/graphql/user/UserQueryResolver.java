package com.example.graphql.user;

import com.example.graphql.security.JwtTokenProvider;
import com.example.graphql.user.User;
import com.example.graphql.user.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@Component
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserRepository userRepository;

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> findByUserId(Long id){
        return userRepository.findById(id);
    }


}
