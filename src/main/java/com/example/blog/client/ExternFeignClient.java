package com.example.blog.client;

import java.util.Map;

public interface ExternFeignClient {
    Map<String, Object> findBlogByKeword(String query, String sort, Integer start, Integer size);
}
