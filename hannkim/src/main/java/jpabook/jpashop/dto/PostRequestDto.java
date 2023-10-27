package jpabook.jpashop.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostRequestDto {
  private Long id;

  @NotEmpty(message = "title is empty")
  private String title;

  @NotEmpty(message = "contents is empty")
  private String contents;
}
