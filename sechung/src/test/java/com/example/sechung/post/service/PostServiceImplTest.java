package com.example.sechung.post.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.sechung.global.error.exception.ServiceException;
import com.example.sechung.post.entity.PostEntity;
import com.example.sechung.post.entity.PostEntityImpl;
import com.example.sechung.post.entity.type.BoardType;
import com.example.sechung.post.repository.PostRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * PostServiceImplTest.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/23
 */
@SpringBootTest
class PostServiceImplTest {

  @Mock
  PostRepository postRepository;

  @Autowired
  ModelMapper modelMapper;

//  @InjectMocks
  private PostServiceImpl postService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    postService = new PostServiceImpl(postRepository, modelMapper);
  }

  @Test
  @DisplayName("존재하지 않을경우 ServiceException 발생")
  void getPostByIdNotFound() {
    //Arrange
    when(postRepository.findById(any(Long.class))).thenReturn(Optional.empty());

    //Act
    //Assert
    assertThrows(ServiceException.class, () -> postService.getPostById(1L));
  }

  @Test
  @DisplayName("존재할 경우 PostDto 반환")
  void getPostByIdFound() {
    //Arrange
    PostEntityImpl mockPost = mock(PostEntityImpl.class);
    when(mockPost.getId()).thenReturn(1L);
    when(mockPost.getTitle()).thenReturn("title");
    when(mockPost.getContent()).thenReturn("content");
    when(mockPost.getType()).thenReturn(BoardType.FREE);
    when(postRepository.findById(any(Long.class))).thenReturn(Optional.of(mockPost));

    //Act
    //Assert
    assertDoesNotThrow(() -> postService.getPostById(1L));
  }
}