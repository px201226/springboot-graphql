package com.example.graphql.graphql;

import com.example.graphql.domain.User;
import com.example.graphql.domain.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Component
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserRepository userRepository;

    public List<User> userList(){
        System.out.println("userList method call");
        return userRepository.findAll();
    }

}
