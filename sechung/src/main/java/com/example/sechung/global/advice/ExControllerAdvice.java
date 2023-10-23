package com.example.sechung.global.advice;

import static com.example.sechung.global.error.errorcode.ErrorCode.UNCHECKED_ERROR;

import com.example.sechung.global.error.exception.ServiceException;
import com.example.sechung.global.error.exception.ServiceLoggingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ExControllerAdvice.
 *
 * <p>
 * 예외처리를 위한 ControllerAdvice, AOP를 이용하여 예외처리를 하기 위해 사용
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/23
 */
@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class ExControllerAdvice {

  @ExceptionHandler(ServiceException.class)
  public ResponseEntity<ErrorResult> serviceException(ServiceException e) {
    return new ResponseEntity<>(new ErrorResult(e.getMsg(), e.getCode()), e.getStatus());
  }

  @ExceptionHandler(ServiceLoggingException.class)
  public ResponseEntity<ErrorResult> serviceErrorException(ServiceLoggingException e) {
    return new ResponseEntity<>(new ErrorResult(e.getMsg(), e.getCode()), e.getStatus());
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResult> runtimeException(
      RuntimeException e) {
    log.error("Error Unchecked: {} - {}", UNCHECKED_ERROR.getErrorCode(),
        UNCHECKED_ERROR.getDetail());
    return new ResponseEntity<>(
        new ErrorResult(UNCHECKED_ERROR.getClientMessage(), UNCHECKED_ERROR.getErrorCode()),
        UNCHECKED_ERROR.getHttpStatus());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResult> exception(Exception e) {
    log.error("Error Unchecked: {} - {}", UNCHECKED_ERROR.getErrorCode(),
        UNCHECKED_ERROR.getDetail());
    return new ResponseEntity<>(
        new ErrorResult(UNCHECKED_ERROR.getClientMessage(), UNCHECKED_ERROR.getErrorCode()),
        UNCHECKED_ERROR.getHttpStatus());
  }
}

