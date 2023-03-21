package com.example.blog.repository;

import com.example.blog.dto.KeywordDto;
import com.example.blog.dto.QKeywordDto;
import com.example.blog.entity.Keyword;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

import static com.example.blog.entity.QKeyword.keyword1;

public class KeywordRepositoryImpl implements KeywordRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public KeywordRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public List<KeywordDto> findKeyWordTop10() {
        return queryFactory
                .select(new QKeywordDto(keyword1.keyword, keyword1.count, keyword1.date))
                .from(keyword1)
                .orderBy(keyword1.count.desc(), keyword1.date.desc())
                .offset(0)
                .limit(10)
                .fetch();
    }

    @Override
    public void save(String keyword) {
        Keyword findKeyword = queryFactory
                .selectFrom(keyword1)
                .where(keyword1.keyword.eq(keyword))
                .fetchOne();

        if(findKeyword == null) {
              Keyword searchKeyword = new Keyword(keyword, 1, new Date());
              em.persist(searchKeyword);
        } else {
            findKeyword.changeCount(findKeyword.getCount());
            em.persist(findKeyword);
        }
    }
}
