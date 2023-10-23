package com.example.sechung.post.service;

import com.example.sechung.post.service.dto.PostDto;
import org.springframework.stereotype.Service;

/**
 * PostService.
 *
 * <p>
 *  PostService 인터페이스
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/23
 */
public interface PostService {

    PostDto getPostById(Long id);
}
