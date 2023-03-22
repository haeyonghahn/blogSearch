package com.example.blog.client.kakao;

import com.example.blog.client.ExternModelMapper;
import com.example.blog.dto.BlogDocumentDto;
import com.example.blog.dto.BlogResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class KakaoModelMapper implements ExternModelMapper {

    private ObjectMapper mapper = new ObjectMapper();

    public BlogResponseDto map(Map<String, Object> map) {
        List<BlogDocumentDto> blogDocumentDtos = new ArrayList<>();
        Map<String, Object> meta = mapper.convertValue(map.get("meta"), Map.class);
        List<Map<String, Object>> documents = mapper.convertValue(map.get("documents"), List.class);

        for(int i = 0; i < documents.size(); i++) {
            BlogDocumentDto blogDocumentDto = BlogDocumentDto.builder()
                    .title((String) documents.get(i).get("title"))
                    .contents((String) documents.get(i).get("contents"))
                    .url((String) documents.get(i).get("url"))
                    .blogname((String) documents.get(i).get("blogname"))
                    .thumbnail((String) documents.get(i).get("thumbnail"))
                    .datetime((String) documents.get(i).get("datetime"))
                    .build();

            blogDocumentDtos.add(blogDocumentDto);
        }
        return BlogResponseDto.builder()
                .totalElements((Integer) meta.get("pageable_count"))
                .blogDocumentDtos(blogDocumentDtos)
                .build();
    }
}
