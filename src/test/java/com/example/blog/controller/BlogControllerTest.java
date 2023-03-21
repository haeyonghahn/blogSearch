package com.example.blog.controller;

import com.example.blog.constants.Constants;
import com.example.blog.controller.BlogController;
import com.example.blog.dto.BlogRequestDto;
import com.example.blog.dto.KeywordDto;
import com.example.blog.service.BlogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BlogController.class)
public class BlogControllerTest {

    @MockBean
    BlogService blogService;
    @Autowired
    MockMvc mockMvc;

    @DisplayName("블로그 검색 테스트")
    @Test
    void search() throws Exception {
        //given
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("query", "이효리");
        param.add("sort", Constants.ACCURACY);
        param.add("page", "1");
        param.add("size", "10");

        //when
        ResultActions resultActions = mockMvc.perform(get("/blog/search")
                .params(param)
                .contentType(MediaType.APPLICATION_JSON));

        //then
        resultActions.andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("인기 검색어 목록 테스트")
    @Test
    void keyword() throws Exception {
        //given
        KeywordDto keywordDto = KeywordDto.builder()
                .keyword("이효리")
                .count(1)
                .date(new Date())
                .build();

        List<KeywordDto> list = Arrays.asList(keywordDto);

        when(blogService.findKeyWordTop10()).thenReturn(list);

        //when then
        mockMvc.perform(get("/blog/keyword"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"keyword\":\"이효리\",\"count\":1}]"))
                .andDo(print());
    }
}
