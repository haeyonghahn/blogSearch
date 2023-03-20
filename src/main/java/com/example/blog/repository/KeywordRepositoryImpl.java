package com.example.blog.repository;

import com.example.blog.entity.Keyword;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public class KeywordRepositoryImpl implements KeywordRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    public KeywordRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public List<Keyword> findKeyWordTop10() {
        return null;
    }

    @Override
    public void save(String keyword) {

    }
}
