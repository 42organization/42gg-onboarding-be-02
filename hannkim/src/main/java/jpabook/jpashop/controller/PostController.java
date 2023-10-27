package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Post;
import jpabook.jpashop.dto.PostRequestDto;
import jpabook.jpashop.dto.PostResponseDto;
import jpabook.jpashop.dto.SuccessResponseDto;
import jpabook.jpashop.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PostController {
  @Autowired
  private PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/mapping/post/{postId}")
  public ResponseEntity<PostResponseDto> findPost(@PathVariable String postId) {
    return postService.findOne(Long.parseLong(postId));
  }

  @PostMapping("mapping/post")
  public ResponseEntity<PostResponseDto> addPost(@RequestBody @Valid PostRequestDto postBody) {
    return postService.save(postBody);
  }

  @DeleteMapping("mapping/post/{postId}")
  public ResponseEntity<SuccessResponseDto> deletePost(@PathVariable String postId) {
    return postService.delete(Long.parseLong(postId));
  }

  @PutMapping("mapping/post")
  public ResponseEntity<SuccessResponseDto> updatePost(@RequestBody @Valid PostRequestDto postBody) {
    return postService.update(postBody);
  }

}
