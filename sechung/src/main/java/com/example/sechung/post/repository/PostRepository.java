package com.example.sechung.post.repository;

import com.example.sechung.post.entity.PostEntityImpl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostRepository.
 *
 * <p>
 *  Data jpa를 사용하는 PostRepository 계층
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/23
 */
public interface PostRepository extends JpaRepository<PostEntityImpl, Long> {

}
