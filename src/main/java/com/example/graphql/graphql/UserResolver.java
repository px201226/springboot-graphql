package com.example.graphql.graphql;

import com.example.graphql.domain.*;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class UserResolver implements GraphQLResolver<User> {

    private final PostRepository postRepository;

    public List<Post> posts(User user) {
        return user.getPosts();
    }


    public List<Comment> comments(User user){
        return user.getComments();
    }

}
