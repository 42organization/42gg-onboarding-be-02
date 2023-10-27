package com.example.sechung.global.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * BaseEntity.
 *
 * <p>
 *  BaseEntity 는 모든 엔티티의 상위 클래스가 되어 엔티티들의 공통 매핑 정보를 정의한다.
 *  <br>
 *  여기서는 등록일과 수정일을 정의한다.
 *  <br>
 *  @MappedSuperclass : JPA Entity 클래스들이 BaseTimeEntity 를 상속할 경우 필드들도 컬럼으로 인식하도록 한다.
 *  <br>
 *  @EntityListeners(AuditingEntityListener.class) : BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
 *  <br>
 *  Auditing : JPA 에서 시간에 대해서 자동으로 값을 넣어주는 기능이다.
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/22
 */
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public class BaseEntity {

  /**
   * 등록일.
   * <br>
   * @CreatedDate : Entity 가 생성되어 저장될 때 시간이 자동 저장된다.
   */
  @CreatedDate
  @Column(name = "regDate", updatable = false)
  private LocalDateTime regDate;

  /**
   * 수정일.
   * <br>
   * @LastModifiedDate : 조회한 Entity 의 값을 변경할 때 시간이 자동 저장된다.
   */
  @LastModifiedDate
  @Column(name = "modDate", updatable = true)
  private LocalDateTime modDate;
}
