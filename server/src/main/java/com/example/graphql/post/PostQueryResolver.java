package com.example.graphql.post;

import com.example.graphql.post.Post;
import com.example.graphql.post.PostRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.List;


@RequiredArgsConstructor
@Component
public class PostQueryResolver implements GraphQLQueryResolver {

    private final PostRepository postRepository;

    @PreAuthorize("permitAll")
    public List<Post> posts(DataFetchingEnvironment environment){
        DataFetchingFieldSelectionSet selectionSet = environment.getSelectionSet();
        if(selectionSet.contains("comments")){
            return postRepository.findAll(fetchComments());
        }else{
            return postRepository.findAll();
        }
    }

    @PreAuthorize("permitAll")
    public Post findByPostId(Long postId){
        return postRepository.findById(postId).orElseThrow(RuntimeException::new);
    }


    private Specification fetchComments(){
        return ((root, query, criteriaBuilder) -> {
            Fetch f = root.fetch("comments", JoinType.LEFT);
            Join join = (Join) f;
            return join.getOn();
        });
    }
}
