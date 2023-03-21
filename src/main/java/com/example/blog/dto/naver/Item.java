package com.example.blog.dto.naver;

import lombok.Getter;

@Getter
public class Item {
    private String title;
    private String link;
    private String description;
    private String bloggername;
    private String bloggerlink;
    private String postdate;

    public Item(String title, String link, String description, String bloggername, String bloggerlink, String postdate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.bloggername = bloggername;
        this.bloggerlink = bloggerlink;
        this.postdate = postdate;
    }
}
