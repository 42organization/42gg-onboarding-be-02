package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
  @Id @GeneratedValue
  private Long id;

  private String username;

  @Embedded
  private Address address;

  // 연관관계 주인이 아닐 경우 mappedBy
  // Order Table에 있는 member field에 의해 mapping 되었다는 의미
  @OneToMany(mappedBy = "member")
  private List<Order> orders = new ArrayList<>();
}
