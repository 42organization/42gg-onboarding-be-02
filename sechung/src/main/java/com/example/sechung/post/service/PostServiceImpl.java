package com.example.sechung.post.service;

import com.example.sechung.global.error.errorcode.ErrorCode;
import com.example.sechung.global.error.exception.ServiceException;
import com.example.sechung.post.entity.PostEntityImpl;
import com.example.sechung.post.repository.PostRepository;
import com.example.sechung.post.service.dto.PostDto;
import com.example.sechung.post.service.dto.PostUpdateDto;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PostServiceImpl.
 *
 * <p>
 * 기본 PostService 구현체
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/23
 */
@Service("postServiceImpl")
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final ModelMapper modelMapper;

  public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
    this.postRepository = postRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public PostDto getPostById(Long id) {
    PostEntityImpl postEntity = getOrThrow404(postRepository.findById(id));
    return modelMapper.map(postEntity, PostDto.class);
  }

  @Override
  public void createPost(PostUpdateDto dto) {
    PostEntityImpl postEntity = PostEntityImpl.builder()
        .title(dto.getTitle())
        .content(dto.getContent())
        .type(dto.getType())
        .build();
    postRepository.save(postEntity);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void updatePost(PostUpdateDto dto, Long id) {
    PostEntityImpl postEntity = getOrThrow404(postRepository.findById(id));
    postEntity.updatePost(dto.getTitle(), dto.getContent(), dto.getType());
  }

  @Override
  public void deletePost(Long id) {
    PostEntityImpl postEntity = getOrThrow404(postRepository.findById(id));
    postRepository.delete(postEntity);
  }

  private PostEntityImpl getOrThrow404(Optional<PostEntityImpl> postEntity) {
    return postEntity.orElseThrow(() -> new ServiceException(ErrorCode.POST_NOT_FOUND));
  }
}