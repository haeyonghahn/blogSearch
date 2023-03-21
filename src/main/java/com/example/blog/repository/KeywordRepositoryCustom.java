package com.example.blog.repository;

import com.example.blog.dto.KeywordDto;

import java.util.List;

public interface KeywordRepositoryCustom {
    void save(String keyword);
    List<KeywordDto> findKeyWordTop10();

}
