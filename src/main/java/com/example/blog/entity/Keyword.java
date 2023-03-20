package com.example.blog.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    public void changeCount(int count) {
        this.count = count;
    }
}
