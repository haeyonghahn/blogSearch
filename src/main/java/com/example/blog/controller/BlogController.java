package com.example.blog.controller;

import com.example.blog.dto.BlogRequestDto;
import com.example.blog.dto.BlogResponseDto;
import com.example.blog.dto.KeywordDto;
import com.example.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping(value = "/search")
    public BlogResponseDto search(@Valid BlogRequestDto blogRequestDto) {

        blogService.keywordSave(blogRequestDto.getQuery());
        return blogService.findBlogByKeword(
                blogRequestDto.getQuery(),
                blogRequestDto.getSort(),
                blogRequestDto.getPage(),
                blogRequestDto.getSize());
    }

    @GetMapping("/keyword")
    public List<KeywordDto> keyword() {
        return blogService.findKeyWordTop10();
    }
}
