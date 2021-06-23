package com.example.graphql.graphql.query;

import com.example.graphql.domain.Post;
import com.example.graphql.domain.User;
import com.example.graphql.domain.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
