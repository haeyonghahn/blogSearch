package com.example.blog.client.kakao;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KakaoConfiguration {

    @Bean(name = "kakaoRequestInterceptor")
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "KakaoAK f0ea4f3b332d3619defec46134d583b2");
        };
    }
}
