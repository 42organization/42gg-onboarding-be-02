package gg.onboarding2th.repository;

import gg.onboarding2th.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
