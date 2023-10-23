package jpabook.jpashop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Post {
  @Id @GeneratedValue
  @Column(name = "post_id")
  private Long id;

  private String title;

  private String contents;

}