package gg.onboarding2th.entity;

import gg.onboarding2th.dto.PostRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String content;

    public static Post createPost(String title, String content){
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return post;
    }

    public static Post updatePost(Post post, PostRequestDto requestDto){
        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());
        return post;
    }
}
