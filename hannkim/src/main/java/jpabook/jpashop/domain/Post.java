package jpabook.jpashop.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // hmm..
@AllArgsConstructor
@Builder
public class Post {
  @Id @GeneratedValue
  @Column(name = "post_id")
  private Long id;

  private String title;

  private String contents;

}
