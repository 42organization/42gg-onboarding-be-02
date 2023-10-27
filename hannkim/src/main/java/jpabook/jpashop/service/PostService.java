package jpabook.jpashop.service;

import jpabook.jpashop.domain.Post;
import jpabook.jpashop.dto.PostRequestDto;
import jpabook.jpashop.dto.PostResponseDto;
import jpabook.jpashop.dto.SuccessResponseDto;
import jpabook.jpashop.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  @Autowired
  private PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  // CHECK body에 담으면 build 필요 없나...?
  public ResponseEntity<PostResponseDto> findOne(Long id) {
    Post post = postRepository.findOne(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new PostResponseDto(post.getId(), post.getTitle(), post.getContents()));
  }

  public ResponseEntity<PostResponseDto> save(PostRequestDto postBody) {
    Post post = Post.builder()
        .title(postBody.getTitle())
        .contents(postBody.getContents())
        .build();
    postRepository.save(post);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new PostResponseDto(post.getId(), post.getTitle(), post.getContents()));
  }

  public ResponseEntity<SuccessResponseDto> delete(Long id) {
    Post post = postRepository.findOne(id);
    postRepository.delete(post);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new SuccessResponseDto(post.getId() + " 게시글이 삭제되었습니다."));
  }

  public ResponseEntity<SuccessResponseDto> update(PostRequestDto postBody) {
    Post post = Post.builder()
        .id(postBody.getId())
        .title(postBody.getTitle())
        .contents(postBody.getContents())
        .build();
    postRepository.update(post);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new SuccessResponseDto(post.getId() + " 게시글이 수정되었습니다."));
  }

}
