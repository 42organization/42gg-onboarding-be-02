package gg.crud.controller;

import gg.crud.dto.PostRequestDto;
import gg.crud.dto.PostResponseDto;
import gg.crud.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    // 글 등록
    @PostMapping("/posts")
    public String createPost(@RequestBody PostRequestDto postRequestDto) {
        // @RequestBody 어노테이션 : http request의 본문 내용(JSON)을 자바 객체로 변환해줌
        return postService.createPost(postRequestDto);
    }

    // 모든 글 조회
    @GetMapping("/posts")
    public List<PostResponseDto> getAllPosts() {
        return postService.findAllPosts();
    }

    // 특정 글 조회
    @GetMapping("/posts/{id}")
    public PostResponseDto getOnePost(@PathVariable Long id) {
        return postService.findOnePost(id);
    }

    // 글 삭제
    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    // 글 수정
    @PutMapping("/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(id, postRequestDto);
    }
}
