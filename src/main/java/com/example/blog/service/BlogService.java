package com.example.blog.service;

import com.example.blog.client.kakao.KakaoFeignClient;
import com.example.blog.client.kakao.KakaoModelMapper;
import com.example.blog.dto.BlogResponseDto;
import com.example.blog.dto.KeywordDto;
import com.example.blog.dto.kakao.KakaoDto;
import com.example.blog.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogService {
    private final KakaoFeignClient kakaoFeignClient;
    private final KeywordRepository keywordRepository;

    public BlogResponseDto findBlogByKeword(String query, String sort, Integer page, Integer size) {
        KakaoDto kakaoDto = kakaoFeignClient.findBlogByKeword(query, sort, page, size);
        BlogResponseDto blogResponseDto = new KakaoModelMapper().map(kakaoDto);

        blogResponseDto.setIsEnd(kakaoDto.getMeta().getIsEnd());
        blogResponseDto.setTotalElements(kakaoDto.getMeta().getPageableCount());
        blogResponseDto.setPageSize(size);
        blogResponseDto.setPageNumber(page);
        return blogResponseDto;
    }

    @Transactional
    public void keywordSave(String keyword) {
        keywordRepository.save(keyword);
    }

    public List<KeywordDto> findKeyWordTop10() {
        return keywordRepository.findKeyWordTop10();
    }
}
