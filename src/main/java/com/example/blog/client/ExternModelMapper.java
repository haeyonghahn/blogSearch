package com.example.blog.client;

import com.example.blog.dto.BlogResponseDto;

import java.util.Map;

public interface ExternModelMapper {
    BlogResponseDto map(Map<String, Object> map);
}
