package com.gg.demo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CRUD")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    public Post(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public Post() {

    }
}
