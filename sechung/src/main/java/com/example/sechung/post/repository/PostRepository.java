package com.example.sechung.post.repository;

import com.example.sechung.post.entity.PostEntity;
import com.example.sechung.post.entity.PostEntityImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

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
@NoRepositoryBean
public interface PostRepository<ENTITY extends PostEntity> extends JpaRepository<ENTITY, Long> {

}
