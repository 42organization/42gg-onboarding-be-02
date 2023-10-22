package com.example.sechung.post.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.example.sechung.global.error.exception.ServiceLoggingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * PostEntityFactoryTest.
 *
 * <p>
 *  PostEntityFactory 테스트
 * </p>
 *
 * @author : middlefitting
 * @see com.example.sechung.global.error.exception.ServiceLoggingException
 * @since : 2023/10/22
 */
@DisplayName("PostEntityFactory 테스트")
class PostEntityFactoryTest {
  @Test
  @DisplayName("인스턴스를 생성할 수 없는 경우 예외를 발생시킨다")
  void FailedGetInstanceTest() {
    //Arrange
    PostEntityFactory<PostEntity> postEntityFactory = new PostEntityFactory<>();

    //Act
    //Assert
    assertThrows(ServiceLoggingException.class, () -> postEntityFactory.getNewInstance(PostEntity.class));
  }

  @Test
  @DisplayName("인스턴스를 생성할 수 있는 경우 정상적으로 반환")
  void SuccessGetInstanceTest() {
    //Arrange
    PostEntityFactory<PostEntityImpl> postEntityFactory = new PostEntityFactory<>();

    //Act
    PostEntityImpl postEntity = postEntityFactory.getNewInstance(PostEntityImpl.class);

    //Assert
    assertEquals(PostEntityImpl.class, postEntity.getClass());
    System.out.println(postEntity.getClass());
  }
}