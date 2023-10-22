package com.example.sechung.post.entity;

import com.example.sechung.global.entity.BaseEntity;
import com.example.sechung.post.entity.type.BoardType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

/**
 * PostEntityImpl.
 *
 * <p>
 * PostEntity 를 구현한 클래스
 * <br>
 *
 * @author : middlefitting
 * @Entity : JPA 에서 엔티티를 나타내는 어노테이션.
 * <br>
 * @Table : 엔티티와 매핑할 테이블을 지정한다.
 * <br>
 * @NoArgsConstructor : 기본 생성자를 만들어준다.
 * <br>
 * 기본 생성자가 필요한 이유는 ORM 에서 객체를 생성할 때 리플렉션을 사용하기 때문에 기본 생성자가 필요하다.
 * </p>
 * @see com.example.sechung.global.entity.BaseEntity
 * @since : 2023/10/22
 */
@Entity
@Table(name = "posts")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class PostEntityImpl extends BaseEntity implements PostEntity {

  /**
   * id.
   * <br>
   * @Id : 해당 테이블의 PK 필드를 나타낸다.
   * <br>
   * @GeneratedValue : PK 의 생성 규칙을 나타낸다. Identity 를 사용하면 DB 에서 자동으로 생성해준다.
   *
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * title.
   * <br>
   * 게시글의 제목.
   */
  private String title;

  /**
   * content.
   * <br>
   * 게시글의 내용.
   */
  private String content;

  /**
   * type.
   * <br>
   * 게시글의 타입.
   */
  private BoardType type;
}
