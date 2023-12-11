package com.example.demo.infrastructure;

import com.example.demo.domain.BaseEntity;
import com.example.demo.api.queries.BaseQuery;
import com.example.demo.api.queries.QueryHandlerMethod;

import java.util.List;

public interface QueryDispatcher {
    <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
    <U extends BaseEntity> List<U> send(BaseQuery query);
}
