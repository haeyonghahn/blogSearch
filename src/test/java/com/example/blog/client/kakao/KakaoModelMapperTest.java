package com.example.blog.client.kakao;

import com.example.blog.dto.BlogDocumentDto;
import com.example.blog.dto.BlogResponseDto;
import com.example.blog.dto.kakao.Document;
import com.example.blog.dto.kakao.KakaoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class KakaoModelMapperTest {

    @DisplayName("카카오DTO를 블로그DTO로 매핑 테스트")
    @Test
    public void mapTest() {
        //given
        Document document = Document.builder()
                .title("<b>바닷가재</b>가리비_신길 고오급진 맛집")
                .contents("음식을 먹으러 가기로 했습니다. " +
                        "일전에 아내 임신 전에 온 적이 있는데 단가가 꽤 나가서 못오고 있다가 이번 기회에 다녀왔습니다. " +
                        "신길 <b>바닷가재</b>가리비 입니다. <b>바닷가재</b>가리비, 킹랍스타 오랜 맛집 포스가 물씬 납니다. " +
                        "전화로 예약을 했고요, 아기의자가 있는지 확인해 봤는데 의외로 있더라고요. 주차가 애매할 거...")
                .url("http://weesh.tistory.com/576")
                .blogname("weeshlist")
                .thumbnail(null)
                .datetime("2023-02-10T23:42:56.000+09:00")
                .build();
        List<Document> documents = new ArrayList<>();
        documents.add(document);
        KakaoDto kakaoDto = KakaoDto.builder()
                .documents(documents)
                .build();

        //when
        BlogResponseDto blogResponseDto = new KakaoModelMapper().map(kakaoDto);

        //then
        assertThat(document.getTitle()).isEqualTo(blogResponseDto.getBlogDocumentDtos().get(0).getTitle());
        assertThat(document.getContents()).isEqualTo(blogResponseDto.getBlogDocumentDtos().get(0).getContents());
        assertThat(document.getUrl()).isEqualTo(blogResponseDto.getBlogDocumentDtos().get(0).getUrl());
        assertThat(document.getBlogname()).isEqualTo(blogResponseDto.getBlogDocumentDtos().get(0).getBlogname());
        assertThat(blogResponseDto.getBlogDocumentDtos().get(0).getThumbnail()).isNull();
        assertThat(document.getDatetime()).isEqualTo(blogResponseDto.getBlogDocumentDtos().get(0).getDatetime());
    }
}
