package com.example.blog.client.naver;

import com.example.blog.client.kakao.KakaoConfiguration;
import com.example.blog.dto.kakao.KakaoDto;
import com.example.blog.dto.naver.NaverDto;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@FeignClient(name = "naver", url = "https://openapi.naver.com", configuration = NaverConfiguration.class)
public interface NaverFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/search/blog.json")
    NaverDto findBlogByKeword(
            @RequestParam @NotNull String query,
            @RequestParam(required = false, defaultValue = "sim") String sort,
            @RequestParam(required = false, defaultValue = "1") Integer start,
            @RequestParam(required = false, defaultValue = "10") Integer display);
}
