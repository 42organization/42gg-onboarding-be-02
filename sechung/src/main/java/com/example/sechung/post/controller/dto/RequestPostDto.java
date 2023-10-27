package com.example.sechung.post.controller.dto;

import com.example.sechung.post.entity.type.BoardType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * RequestPostDto.
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RequestPostDto {
  @NotEmpty
  private String title;
  @NotEmpty
  private String content;
  @NotNull
  private BoardType type;
}
