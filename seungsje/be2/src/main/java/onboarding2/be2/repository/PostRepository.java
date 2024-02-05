package onboarding2.be2.repository;
import onboarding2.be2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p.id FROM Post p") // 모든 게시글의 제목만을 선택하는 JPQL
    List<Long> findIdBy();
}
