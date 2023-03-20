package com.example.blog.client.kakao;

import com.example.blog.dto.kakao.KakaoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

@FeignClient(name = "kakao", url = "https://openapi.naver.com", configuration = KakaoConfiguration.class)
public interface KakaoFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v2/search/blog")
    KakaoDto findBlogByKeword(
            @RequestParam @NotNull String query,
            @RequestParam(required = false, defaultValue = "accuracy") String sort,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
}
