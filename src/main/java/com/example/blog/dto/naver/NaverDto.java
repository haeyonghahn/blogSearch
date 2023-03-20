package com.example.blog.dto.naver;

import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class NaverDto {
    private Date lastBuildDate;
    private Integer total;
    private Integer start;
    private Integer display;

    private List<Item> items;
}
