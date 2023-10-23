package com.example.sechung.post.controller;

import com.example.sechung.post.controller.dto.ResponsePostDto;
import com.example.sechung.post.service.PostService;
import com.example.sechung.post.service.dto.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PostController.
 *
 * <p>
 * PostController 간단한 CRUD
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/23
 */
@RestController
@RequestMapping("/post")
public class PostController {

  private final PostService postService;
  private final ModelMapper modelMapper;

  public PostController(@Qualifier("postServiceImpl") PostService postService,
      ModelMapper modelMapper) {
    this.postService = postService;
    this.modelMapper = modelMapper;
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResponsePostDto> getPostById(@PathVariable Long id) {
    PostDto postDto = postService.getPostById(id);
    ResponsePostDto responsePostDto = modelMapper.map(postDto, ResponsePostDto.class);
    return ResponseEntity.ok(responsePostDto);
  }

}
