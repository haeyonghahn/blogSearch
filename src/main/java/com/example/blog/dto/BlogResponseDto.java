package com.example.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BlogResponseDto {

    private List<BlogDocument> blogDocuments;
}
