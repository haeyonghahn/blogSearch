package com.example.blog.client.kakao;

import com.example.blog.constants.Constants;
import com.example.blog.dto.kakao.KakaoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@FeignClient(name = "kakaoFeignClient", url = "${kakao.baseUrl}")
public interface KakaoFeignClient {

    @GetMapping(value = "${kakao.blogSearchUrl}", headers = {"Authorization=KakaoAK ${kakao.key}"})
    KakaoDto findBlogByKeword(
            @RequestParam @NotNull String query,
            @RequestParam(required = false, defaultValue = Constants.ACCURACY) String sort,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
}
