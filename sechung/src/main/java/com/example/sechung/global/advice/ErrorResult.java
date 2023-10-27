package com.example.sechung.global.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ErrorResult.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/23
 */
@AllArgsConstructor
@Data
public class ErrorResult {

  private String msg;
  private int code;
}

