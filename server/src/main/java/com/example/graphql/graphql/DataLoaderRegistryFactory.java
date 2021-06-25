package com.example.graphql.graphql;

import com.example.graphql.post.Post;
import com.example.graphql.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.MappedBatchLoader;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataLoaderRegistryFactory {

    public static final String POST_DATA_LOADER = "POST_DATA_LOADER";

    private static final Executor executor = Executors
            .newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private final PostRepository postRepository;

    public DataLoaderRegistry newDataLoaderRegistry() {
        DataLoaderRegistry registry = new DataLoaderRegistry();
        registry.register(POST_DATA_LOADER, createPostListDataLoader());
        return registry;
    }


    public DataLoader<Long, List<Post>> createPostListDataLoader() {
        MappedBatchLoader<Long, List<Post>> dataLoader = userId ->
                CompletableFuture.supplyAsync(() -> {
                    List<Post> posts = postRepository.findAll();
                    Map<Long, List<Post>> groupByUserId = posts.stream().collect(Collectors.groupingBy(p->p.getUserId()));
                    return groupByUserId;
                });

        return DataLoader.newMappedDataLoader(dataLoader);
    }

}