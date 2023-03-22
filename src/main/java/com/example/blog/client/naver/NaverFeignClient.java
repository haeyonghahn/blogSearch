package com.example.blog.client.naver;

import com.example.blog.client.ExternFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.Map;

@FeignClient(name = "naverFeignClient", url = "${naver.baseUrl}")
public interface NaverFeignClient extends ExternFeignClient {

    @GetMapping(value = "${naver.blogSearchUrl}",
            headers = {"X-Naver-Client-Id=${naver.clientId}",
                    "X-Naver-Client-Secret=${naver.clientSecret}"})
    @Override
    Map<String, Object> findBlogByKeword(
            @RequestParam @NotNull String query,
            @RequestParam(required = false, defaultValue = "sim") String sort,
            @RequestParam(required = false, defaultValue = "1") Integer start,
            @RequestParam(required = false, defaultValue = "10") Integer display);
}
