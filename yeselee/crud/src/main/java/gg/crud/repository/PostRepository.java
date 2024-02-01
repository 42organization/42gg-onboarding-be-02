package gg.crud.repository;

import gg.crud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository 인터페이스에서 제공하는 기본적인 CRUD 기능 사용 가능
public interface PostRepository extends JpaRepository<Post, Long> {
}
