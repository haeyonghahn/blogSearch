package com.example.blog.dto.kakao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class KakaoDto {
    public Meta meta;
    public List<Document> documents;
}
