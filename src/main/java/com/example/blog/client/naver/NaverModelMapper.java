package com.example.blog.client.naver;

import com.example.blog.client.ExternModelMapper;
import com.example.blog.dto.BlogDocumentDto;
import com.example.blog.dto.BlogResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NaverModelMapper implements ExternModelMapper {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public BlogResponseDto map(Map<String, Object> map) {
        List<BlogDocumentDto> blogDocumentDtos = new ArrayList<>();
        Map<String, Object> meta = mapper.convertValue(map, Map.class);
        List<Map<String, Object>> items = mapper.convertValue(meta.get("items"), List.class);

        for(int i = 0; i < items.size(); i++) {
            BlogDocumentDto blogDocumentDto = BlogDocumentDto.builder()
                    .title((String) items.get(i).get("title"))
                    .contents((String) items.get(i).get("description"))
                    .url((String) items.get(i).get("link"))
                    .blogname((String) items.get(i).get("blogname"))
                    .thumbnail((String) items.get(i).get("bloggerlink"))
                    .datetime((String) items.get(i).get("datetime"))
                    .build();

            blogDocumentDtos.add(blogDocumentDto);
        }
        return BlogResponseDto.builder()
                .totalPosts((Integer) meta.get("total"))
                .blogDocumentDtos(blogDocumentDtos)
                .build();
    }
}
