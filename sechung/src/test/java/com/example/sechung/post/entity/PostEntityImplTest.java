package com.example.sechung.post.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.example.sechung.global.error.exception.ServiceException;
import com.example.sechung.post.entity.type.BoardType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * PostEntityImplTest.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/22
 */
@DisplayName("PostEntityImpl 테스트")
class PostEntityImplTest {
  @Test
  @DisplayName("Null 값이 존재할 경우 Exception 발생")
  void validateBuilderFailedByNull() {
    //Arrange
    //Act
    //Assert
    assertThrows(ServiceException.class, () -> PostEntityImpl.builder().build());

    assertThrows(ServiceException.class, () -> PostEntityImpl.builder().content("").build());
    assertThrows(ServiceException.class, () -> PostEntityImpl.builder().title("").build());
    assertThrows(ServiceException.class, () -> PostEntityImpl.builder().type(BoardType.FREE).build());

    assertThrows(ServiceException.class, () -> PostEntityImpl.builder().content("").title("").build());
    assertThrows(ServiceException.class, () -> PostEntityImpl.builder().content("").type(BoardType.FREE).build());
    assertThrows(ServiceException.class, () -> PostEntityImpl.builder().title("").type(BoardType.FREE).build());
  }

  @Test
  @DisplayName("인자가 모두 존재할 경우 빌더 정상적으로 생성")
  void validateBuilderSuccess() {
    //Arrange
    //Act
    //Assert
    assertDoesNotThrow(() -> PostEntityImpl.builder().content("").title("").type(BoardType.FREE).build());
  }
}