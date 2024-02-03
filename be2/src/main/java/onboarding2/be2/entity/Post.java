package onboarding2.be2.entity;

import jakarta.persistence.*;
import lombok.*;
import onboarding2.be2.dto.ResponseDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder  //  선언한 클래스의 빌더 패턴을 가지는 클래스를 생성
@Entity  //  User 객체와 DB 테이블을 매핑
public class Post {
    @Id // 변수 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값이 없어도 자동으로 할당
    private Long id;
    @Column(nullable = false) // 테이블의 컬럼 설정 값을 명시
    private String title;
    @Column(nullable = false)
    private String text;

    public ResponseDto toResponseDto() {
        return new ResponseDto(this.id, this.title, this.text);
    }
}