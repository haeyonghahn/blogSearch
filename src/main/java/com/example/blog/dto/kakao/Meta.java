package com.example.blog.dto.kakao;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class Meta {
    private Integer totalCount;
    private Integer pageableCount;
    private Boolean isEnd;

    @Builder
    public Meta(Integer totalCount, Integer pageableCount, Boolean isEnd) {
        this.totalCount = totalCount;
        this.pageableCount = pageableCount;
        this.isEnd = isEnd;
    }
}
