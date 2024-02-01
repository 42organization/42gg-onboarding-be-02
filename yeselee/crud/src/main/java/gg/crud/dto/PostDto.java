package gg.crud.dto;

import gg.crud.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDto {
    private String title;
    private String body;
    private String author;

    public PostDto(Post post) {
        this.title = post.getTitle();
        this.body = post.getBody();
        this.author = post.getAuthor();
    }
}
