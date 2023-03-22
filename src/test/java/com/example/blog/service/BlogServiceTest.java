package com.example.blog.service;

import com.example.blog.client.kakao.KakaoFeignClient;
import com.example.blog.client.kakao.KakaoModelMapper;
import com.example.blog.constants.Constants;
import com.example.blog.dto.BlogResponseDto;
import com.example.blog.repository.KeywordRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BlogServiceTest {

    @Autowired
    KakaoFeignClient kakaoFeignClient;

    @Autowired
    KeywordRepository keywordRepository;

    @Autowired
    BlogService blogService;

    @DisplayName("블로그 검색 테스트")
    @Test
    void findBlogByKeword() {
        //given
        Map<String, Object> kakaoDto = kakaoFeignClient.findBlogByKeword("이효리", Constants.ACCURACY, 1, 10);
        BlogResponseDto blogResponseDto = new KakaoModelMapper().map(kakaoDto);
        blogResponseDto.setPageSize(1);
        blogResponseDto.setPageNumber(10);

        //when
        BlogResponseDto result = blogService.findBlogByKeword("이효리", Constants.ACCURACY, 1, 10);

        //then
        assertThat(result.getTotalElements()).isEqualTo(blogResponseDto.getTotalElements());
    }
}
