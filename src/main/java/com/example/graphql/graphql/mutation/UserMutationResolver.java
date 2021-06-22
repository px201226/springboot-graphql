package com.example.graphql.graphql.mutation;

import com.example.graphql.domain.User;
import com.example.graphql.domain.UserRepository;
import com.example.graphql.domain.input.UserInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMutationResolver implements GraphQLMutationResolver {

    private final UserRepository userRepository;

    public User addUser(UserInput userInput){
         return userRepository.saveAndFlush(userInput.toEntity());
    }
}
