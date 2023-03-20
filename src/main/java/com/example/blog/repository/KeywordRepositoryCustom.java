package com.example.blog.repository;

import com.example.blog.entity.Keyword;

import java.util.List;

public interface KeywordRepositoryCustom {
    List<Keyword> findKeyWordTop10();
    void save(String keyword);
}
