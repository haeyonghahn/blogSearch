package com.example.blog.dto;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
public class BlogRequestDto {
    @NotNull @NotBlank
    private String query;
    private String sort;
    @Range(min = 1, max = 50)
    private Integer page;
    @Range(min = 1, max = 50)
    private Integer size;
}
