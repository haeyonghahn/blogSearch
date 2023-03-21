package com.example.blog.client.kakao;

import com.example.blog.dto.BlogDocumentDto;
import com.example.blog.dto.BlogResponseDto;
import com.example.blog.dto.kakao.Document;
import com.example.blog.dto.kakao.KakaoDto;

import java.util.ArrayList;
import java.util.List;

public class KakaoModelMapper {

    public BlogResponseDto map(KakaoDto kakaoDto) {
        List<BlogDocumentDto> blogDocumentDtos = new ArrayList<>();

        for(Document document : kakaoDto.getDocuments()) {
            BlogDocumentDto blogDocumentDto = BlogDocumentDto.builder()
                    .title(document.getTitle())
                    .contents(document.getContents())
                    .url(document.getUrl())
                    .blogname(document.getBlogname())
                    .datetime(document.getDatetime())
                    .build();

            blogDocumentDtos.add(blogDocumentDto);
        }
        return BlogResponseDto.builder()
                .blogDocumentDtos(blogDocumentDtos)
                .build();
    }
}
