package com.example.blog.client.kakao;

import com.example.blog.client.ExternFeignClient;
import com.example.blog.constants.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.Map;

@FeignClient(name = "kakaoFeignClient", url = "${kakao.baseUrl}")
public interface KakaoFeignClient extends ExternFeignClient {

    @GetMapping(value = "${kakao.blogSearchUrl}", headers = {"Authorization=KakaoAK ${kakao.key}"})
    Map<String, Object> findBlogByKeword(
            @RequestParam @NotNull String query,
            @RequestParam(required = false, defaultValue = Constants.ACCURACY) String sort,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
}
