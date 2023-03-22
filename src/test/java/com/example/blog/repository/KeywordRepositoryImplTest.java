package com.example.blog.repository;

import com.example.blog.dto.KeywordDto;
import com.example.blog.entity.Keyword;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class KeywordRepositoryImplTest {

    @Autowired
    EntityManager em;

    @Autowired
    KeywordRepositoryImpl keywordRepository;

    @DisplayName("실시간 검색어 테스트")
    @Test
    void findKeyWordTop10() {
        //given
        Keyword keyword = new Keyword("이효리", 1, new Date());
        em.persist(keyword);

        //when
        List<KeywordDto> findKeyword = keywordRepository.findKeyWordTop10();

        //then
        assertThat(findKeyword.get(0).getKeyword()).isEqualTo(keyword.getKeyword());
    }

    @DisplayName("실시간 검색어 저장 테스트 - 키워드가 존재하지 않을 때")
    @Test
    void save1() {
        //given
        String keyword = "이효리";

        //when
        keywordRepository.save(keyword);
        List<KeywordDto> findKeyword = keywordRepository.findKeyWordTop10();

        //then
        assertThat(findKeyword.get(0).getCount()).isEqualTo(1);
    }

    @DisplayName("실시간 검색어 저장 테스트 - 키워드가 존재할 때")
    @Test
    void save2() {
        //given
        String keyword = "이효리";
        String repeatKeyword = "이효리";

        //when
        keywordRepository.save(keyword);
        keywordRepository.save(keyword);
        List<KeywordDto> findKeyword = keywordRepository.findKeyWordTop10();

        //then
        assertThat(findKeyword.get(0).getCount()).isEqualTo(2);
    }
}
