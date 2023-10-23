package com.example.sechung.post.service.dto;

import com.example.sechung.post.entity.type.BoardType;
import javax.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * PostDto.
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
public class PostDto {
  private Long id;
  private String title;
  private String content;
  private BoardType type;
}
