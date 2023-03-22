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
    @Range(min = 1, max = 50, message = "페이지 번호는 1~50 사이의 값이어야 합니다.")
    private Integer page;
    @Range(min = 1, max = 80, message = "한 페이지에 보여질 문서 수는 1~80 사이의 값이어야 합니다.")
    private Integer size;
}
