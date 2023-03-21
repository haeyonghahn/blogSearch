package com.example.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keyword {
    @Id @GeneratedValue
    @Column(name = "keyword_id")
    private long id;
    @Column
    private String keyword;
    @Column
    private long count;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Keyword(String keyword, long count, Date date) {
        this.keyword = keyword;
        this.count = count;
        this.date = date;
    }

    public void changeCount(long count) {
        this.count = count + 1;
        this.date = new Date();
    }
}
