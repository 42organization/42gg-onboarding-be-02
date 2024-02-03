package onboarding2.be2.controller;

import onboarding2.be2.dto.RequestDto;
import onboarding2.be2.dto.ResponseDto;
import onboarding2.be2.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseDto createPost(@RequestBody RequestDto requestDto){
        return postService.createPost(requestDto);
    }

    @GetMapping("/{postId}")
    public ResponseDto findPost(@PathVariable("postId") Long postId){
        return postService.findPost(postId);
    }

    @GetMapping
    public List<Long> findAllPostIds(){
        return postService.findAllPostIds();
    }

    @PutMapping("/{postId}")
    public ResponseDto updatePost(@PathVariable("postId") Long postId, @RequestBody RequestDto requestDto){
        return postService.updatePost(postId, requestDto);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
    }
}
