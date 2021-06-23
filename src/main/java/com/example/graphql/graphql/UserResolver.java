package com.example.graphql.graphql;

import com.example.graphql.domain.*;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
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
