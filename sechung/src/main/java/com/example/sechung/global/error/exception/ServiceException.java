package com.example.sechung.global.error.exception;

import com.example.sechung.global.error.errorcode.ErrorCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * ServiceException.
 *
 * <p>
 *  서비스에서 발생하는 예외
 * </p>
 *
 * @author : middlefitting
 * @see ErrorCode
 * @since : 2023/10/22
 */
@Getter
@Slf4j
public class ServiceException extends RuntimeException {

  /**
   * msg : 클라이언트에게 보여줄 에러 메시지
   */
  private final String msg;
  /**
   * code : 프로젝트 에러 코드
   */
  private final int code;
  /**
   * status : HTTP 상태 코드
   */
  private final HttpStatus status;


  /**
   * <p>
   *  에러 코드를 받아서 ServiceException을 생성한다.
   *  <br>
   *  해당 생성자가 호출될때 로깅을 수행한다.
   *  <br>
   *  로깅은 errorCode에 정의된 detail을 출력하여 발생 원인을 파악할 수 있게 한다.
   * </p>
   *
   * @param errorCode 에러 코드
   * @return ServiceException
   * @throws
   */

  public ServiceException(ErrorCode errorCode) {
    this.msg = errorCode.getClientMessage();
    this.code = errorCode.getErrorCode();
    this.status = errorCode.getHttpStatus();
    log.error("Error occurred: {} - {}", errorCode.getErrorCode(), errorCode.getDetail());
  }
}
