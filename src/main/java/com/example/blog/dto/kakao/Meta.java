package com.example.blog.dto.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Meta {
    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("pageable_count")
    private Integer pageableCount;
    @JsonProperty("is_end")
    private Boolean isEnd;

    public Meta(Integer totalCount, Integer pageableCount, Boolean isEnd) {
        this.totalCount = totalCount;
        this.pageableCount = pageableCount;
        this.isEnd = isEnd;
    }
}
