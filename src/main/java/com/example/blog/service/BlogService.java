package com.example.blog.service;

import com.example.blog.client.kakao.KakaoFeignClient;
import com.example.blog.dto.BlogResponseDto;
import com.example.blog.dto.kakao.KakaoDto;
import com.example.blog.entity.Keyword;
import com.example.blog.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final KakaoFeignClient kakaoFeignClient;
    private final KeywordRepository keywordRepository;

    public BlogResponseDto findBlogByKeword(String query, String sort, Integer page, Integer size) {
        KakaoDto kakaoDto = kakaoFeignClient.findBlogByKeword(query, sort, page, size);
        return new BlogResponseDto();
    }

    @Transactional
    public void keywordSave(String keyword) {
        keywordRepository.save(keyword);
    }

    public List<Keyword> findKeyWordTop10() {
        return keywordRepository.findKeyWordTop10();
    }
}
