package com.example.graphql.graphql;

import graphql.ExecutionResult;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.ExecutionContext;
import graphql.execution.ExecutionStrategyParameters;
import graphql.execution.NonNullableFieldWasNullException;
import graphql.kickstart.spring.web.boot.GraphQLWebAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;


/*
* Reference : https://stackoverflow.com/questions/48037601/lazyinitializationexception-with-graphql-spring#
* */
@Service(GraphQLWebAutoConfiguration.QUERY_EXECUTION_STRATEGY)
public class AsyncTransactionalExecutionStrategy extends AsyncExecutionStrategy {

    @Override
    @Transactional
    public CompletableFuture<ExecutionResult> execute(ExecutionContext executionContext, ExecutionStrategyParameters parameters) throws NonNullableFieldWasNullException {
        return super.execute(executionContext, parameters);
    }
}