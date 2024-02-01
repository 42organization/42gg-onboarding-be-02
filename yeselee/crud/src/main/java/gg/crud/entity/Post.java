package gg.crud.entity;

import gg.crud.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="post")
@NoArgsConstructor
public class Post {
    // 글 id, title, body, author
    @Id // 기본키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private String author;

    //dto 생성자
    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.body = postRequestDto.getBody();
        this.author = postRequestDto.getAuthor();
    }

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.body = postRequestDto.getBody();
        this.author = postRequestDto.getAuthor();
    }
}
