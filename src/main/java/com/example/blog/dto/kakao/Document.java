package com.example.blog.dto.kakao;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Document {
    private String title;
    private String contents;
    private String url;
    private String blogname;
    private String thumbnail;
    private String datetime;

    public Document(String title, String contents, String url, String blogname, String thumbnail, String datetime) {
        this.title = title;
        this.contents = contents;
        this.url = url;
        this.blogname = blogname;
        this.thumbnail = thumbnail;
        this.datetime = datetime;
    }
}
