package com.example.sechung.global.error.exception;

import com.example.sechung.global.error.errorcode.ErrorCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * ServiceIllegalArgumentException.
 *
 * @author : middlefitting
 * @description:
 * @since : 2023/08/24
 */
@Getter
@Slf4j
public class DefaultServiceException extends RuntimeException {

  private final String msg;
  private final int code;
  private final HttpStatus status;

  public DefaultServiceException(ErrorCode errorCode) {
    this.msg = errorCode.getClientMessage();
    this.code = errorCode.getErrorCode();
    this.status = errorCode.getHttpStatus();
    log.error("Error occurred: {} - {}", errorCode.getErrorCode(), errorCode.getDetail());
  }
}
