package com.example.blog.service;

import com.example.blog.dto.BlogResponseDto;
import com.example.blog.dto.KeywordDto;

import java.util.List;

public interface BlogService {
    BlogResponseDto findBlogByKeword(String query, String sort, Integer page, Integer size);
    void keywordSave(String keyword);
    List<KeywordDto> findKeyWordTop10();
}
