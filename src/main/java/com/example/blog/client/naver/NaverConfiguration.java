package com.example.blog.client.naver;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NaverConfiguration {

    @Bean(name = "naverRequestInterceptor")
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-Naver-Client-Id", "UPKYlH4XrYj9El4ukcJd");
            requestTemplate.header("X-Naver-Client-Secret", "HfygOL38xT");
        };
    }
}
