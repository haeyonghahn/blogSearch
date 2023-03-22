package com.example.blog.service;

import com.example.blog.client.kakao.KakaoFeignClient;
import com.example.blog.client.kakao.KakaoModelMapper;
import com.example.blog.client.naver.NaverFeignClient;
import com.example.blog.client.naver.NaverModelMapper;
import com.example.blog.constants.Constants;
import com.example.blog.dto.BlogResponseDto;
import com.example.blog.dto.KeywordDto;
import com.example.blog.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final KakaoFeignClient kakaoFeignClient;
    private final NaverFeignClient naverFeignClient;
    private final KeywordRepository keywordRepository;
    private final CircuitBreakerFactory circuitBreakerFactory;

    @Override
    public BlogResponseDto findBlogByKeword(String query, String sort, Integer page, Integer size) {
        BlogResponseDto blogResponseDto = null;

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        Map<String, Object> kakaoData = circuitBreaker.run(() ->
                kakaoFeignClient.findBlogByKeword(query, sort, page, size),
                throwable -> new HashMap<>());

        if(kakaoData.containsKey("error_code")) {
            Map<String, Object> naverData = naverFeignClient.findBlogByKeword(query, Constants.SIM, page, size);
            blogResponseDto = new NaverModelMapper().map(naverData);
        } else {
            blogResponseDto = new KakaoModelMapper().map(kakaoData);
        }
        blogResponseDto.setPostPerPage(size);
        return blogResponseDto;
    }

    @Transactional
    @Override
    public void keywordSave(String keyword) {
        keywordRepository.save(keyword);
    }

    @Override
    public List<KeywordDto> findKeyWordTop10() {
        return keywordRepository.findKeyWordTop10();
    }
}
