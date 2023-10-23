package com.example.sechung.post.service;

import com.example.sechung.global.error.errorcode.ErrorCode;
import com.example.sechung.global.error.exception.ServiceException;
import com.example.sechung.post.entity.PostEntityImpl;
import com.example.sechung.post.repository.PostRepository;
import com.example.sechung.post.service.dto.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    PostEntityImpl postEntity = postRepository.findById(id)
        .orElseThrow(() -> new ServiceException(ErrorCode.POST_NOT_FOUND));
    return modelMapper.map(postEntity, PostDto.class);
  }
}