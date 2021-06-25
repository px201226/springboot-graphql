package com.example.graphql.user;

import com.example.graphql.comment.Comment;
import com.example.graphql.graphql.DataLoaderRegistryFactory;
import com.example.graphql.post.Post;
import com.example.graphql.post.PostRepository;
import com.example.graphql.user.User;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Slf4j
@Component
@RequiredArgsConstructor
public class UserResolver implements GraphQLResolver<User> {

    private final PostRepository postRepository;
    private final DataLoaderRegistryFactory dataLoaderRegistryFactory;

    public CompletableFuture<List<Post>> posts(User user, DataFetchingEnvironment environment) {
        DataLoader<Long, List<Post>> dataLoader = environment.getDataLoader(DataLoaderRegistryFactory.POST_DATA_LOADER);
        return dataLoader.load(user.getId());
    }


    public List<Comment> comments(User user){
        log.info(user.toString());
        return user.getComments();
    }

}
