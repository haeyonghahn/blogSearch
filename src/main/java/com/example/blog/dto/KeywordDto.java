package com.example.blog.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class KeywordDto {
    private String keyword;
    private long count;
    private Date date;

    @QueryProjection
    public KeywordDto(String keyword, long count, Date date) {
        this.keyword = keyword;
        this.count = count;
        this.date = date;
    }
}
