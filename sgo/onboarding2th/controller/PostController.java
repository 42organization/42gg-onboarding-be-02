package gg.onboarding2th.controller;


import gg.onboarding2th.dto.PostRequestDto;
import gg.onboarding2th.dto.PostResponseDto;
import gg.onboarding2th.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto requestDto){
        return postService.createPost(requestDto);
    }

    @PostMapping("/{postId}")
    public ResponseEntity<PostResponseDto> findPost(@PathVariable Long postId){
        return postService.findPost(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostResponseDto> updatePost(@PathVariable Long postId,
                                                      @RequestBody PostRequestDto requestDto){
        return postService.updatePost(postId, requestDto);
    }

    @DeleteMapping("/{postId}")
    public Long deletePost(@PathVariable Long postId){
        return postService.deletePost(postId);
    }
}
