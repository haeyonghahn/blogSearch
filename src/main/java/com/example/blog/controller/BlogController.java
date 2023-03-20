package com.example.blog.controller;

import com.example.blog.dto.BlogResponseDto;
import com.example.blog.entity.Keyword;
import com.example.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
@Slf4j
public class BlogController {
    private final BlogService blogService;

    @GetMapping(value = "/search", produces = "application/json;charset=UTF-8")
    public BlogResponseDto search(
            @RequestParam @NotNull String query,
            @RequestParam(required = false, defaultValue = "accuracy") String sort,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        blogService.keywordSave(query);
        return blogService.findBlogByKeword(query, sort, page, size);
    }

    @GetMapping("/keyword")
    public List<Keyword> keyword() {
        return blogService.findKeyWordTop10();
    }
}
