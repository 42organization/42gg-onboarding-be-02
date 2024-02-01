package gg.crud.controller;

import gg.crud.dto.PostDto;
import gg.crud.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    // 글 등록
    @PostMapping("/posts")
    public String createPost(@RequestBody PostDto postDto) {
        // @RequestBody 어노테이션 : http request의 본문 내용(JSON)을 자바 객체로 변환해줌
        return postService.createPost(postDto);
    }

    // 모든 글 조회
    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return postService.findAllPosts();
    }

}
