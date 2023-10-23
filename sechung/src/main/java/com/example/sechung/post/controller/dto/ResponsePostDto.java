package com.example.sechung.post.controller.dto;

import com.example.sechung.post.entity.type.BoardType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * ResponsePostDto.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/23
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ResponsePostDto {
    private Long id;
    private String title;
    private String content;
    private BoardType boardType;
}
