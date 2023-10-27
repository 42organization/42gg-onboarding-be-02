package com.example.sechung.global.error.errorcode;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * ErrorCode.
 *
 * <p>
 *  에러 코드를 정의하는 enum
 *  <br>
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/22
 */
@Getter
public enum ErrorCode {
  UNCHECKED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR , 1, "확인되지 않은 에러", "내부 서버 오류가 발생하였습니다!"),
  FACTORY_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, 101, "팩토리 생성 실패", "내부 서버 오류가 발생하였습니다!"),
  INVALID_POST_ENTITY_VALUE(HttpStatus.BAD_REQUEST , 102, "Post 엔티티 인자값이 잘못됨", "입력 값이 잘못되었습니다!"),
  POST_NOT_FOUND(HttpStatus.NOT_FOUND , 103, "존재하지 않는 Post", "존재하지 않는 게시글입니다!");

  /**
   * httpStatus : HTTP 상태 코드
   */
  private final HttpStatus httpStatus;
  /**
   * errorCode : 프로젝트 에러 코드
   */
  private final int errorCode;
  /**
   * detail : 로깅을 위한 에러 상세 내용
   */
  private final String detail;
  /**
   * clientMessage : 클라이언트에게 보여줄 에러 메시지
   */
  private final String clientMessage;

  ErrorCode(HttpStatus httpStatus, int errorCode, String detail, String clientMessage) {
    this.httpStatus = httpStatus;
    this.errorCode = errorCode;
    this.detail = detail;
    this.clientMessage = clientMessage;
  }
}
