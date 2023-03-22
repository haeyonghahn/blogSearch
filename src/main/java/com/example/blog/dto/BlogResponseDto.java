package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BlogResponseDto {
    private Integer totalElements;
    private Integer pageSize;
    private Integer pageNumber;
    private List<BlogDocumentDto> blogDocumentDtos;
}
