package com.example.blog.client.naver;

import com.example.blog.dto.naver.NaverDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@FeignClient(name = "naverFeignClient", url = "${naver.baseUrl}")
public interface NaverFeignClient {

    @GetMapping(value = "${blogSearchUrl}",
            headers = {"X-Naver-Client-Id=${naver.clientId}",
                    "X-Naver-Client-Secret=${naver.clientSecret}"})
    NaverDto findBlogByKeword(
            @RequestParam @NotNull String query,
            @RequestParam(required = false, defaultValue = "sim") String sort,
            @RequestParam(required = false, defaultValue = "1") Integer start,
            @RequestParam(required = false, defaultValue = "10") Integer display);
}
