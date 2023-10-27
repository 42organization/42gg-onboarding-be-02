package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PostRepository {
  @PersistenceContext
  private EntityManager em;

  public void save(Post post) {
    em.persist(post);
  }

  public Post findOne(Long id) {
    return em.find(Post.class, id);
  }

  public List<Post> findAll() {
    return em.createQuery("select p from Post p", Post.class)
      .getResultList();
  }

  public List<Post> findByTitle(String title) {
    return em.createQuery("select p from Post p where p.title = :title", Post.class)
      .setParameter("title", title)
      .getResultList();
  }

  // delete
  public void delete(Post post) {
    em.remove(post);
  }

  // update
  public Post update(Post post) {
    return em.merge(post);
  }

}
