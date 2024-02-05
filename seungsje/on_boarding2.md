# 42.gg 2회차

## **jpa entity class 만들기**

- JPA란
    
    Java Persistence Api의 약자로 Java DTO(data transfer object)에게 없어지지 않고 오랫동안 지속되는 영속성(persistence)을 부여해준다는 의미
    
    데이터를 DB상에 영구적으로 저장해주는 API인데, SQL문을 개발자가 만들지 않기 때문에 생산성과 유지보수의 능률 및 성능적인 이점도 얻을 수 있다.
    
- entity란?
    
    DB에서 영속적으로 저장된 데이터를 자바 객체로 매핑하여 인스턴스의 형태로 존재하는 데이터를 말한다.
    
- 어노테이션(annotation)이란?
    
    자바언어에서 제공하는 메타데이터의 형태로 클래스, 메소드, 변수, 파라미터 등의 선언에 추가해서 추가적인 정보를 제공한다. 컴파일, 클래스 로딩, 런타임에 해석된다.
    

## @Entity (JPA 찍먹)

DB테이블과 매핑하는 클래스를 엔티티라고 한다.

엔티티는 기본적으로 @Entity어노테이션을 적어 스프링 부트가 엔티티 빈(Bean | 스프링 IoC(inversion of Control) 컨테이너가 관리하는 객체를 의미) 으로 등록하게 만들고 @Table어노테이션에 테이블 이름을 명시하여 그 이름의 테이블과 매핑한다.

테이블의 컬럼은 @Cloumn(테이블에서 각 항목 또는 속성을 나타내는 세로열, 테이블의 한 필드)어노테이션을 통해 매핑하는데, name을 별도로 지정하지 않으면 디폴트값인 필드명으로 컬럼을 검색하게 되고, @Id어노테이션을 필수로 하나의 필드에 적용해서 PK(primary key | 기본키는 데이터베이스의 각 레코드(행)을 식별하는 역할 중복되지 않으며 고유한 값을 가져야함 )임을 명시해야한다.

객체지향 프로그래밍에서 사용하는 클래스와 객체가 관계형 데이터베이스의 테이블과 레코드로 변환하게 되는 과정을 ORM(Object-Relational Mapping)이라고 한다.

## Post entity class 생성 db에 해당

클래스명과 테이블 명이 다를경우 @Table 어노테이션을 사용하여 매핑 할 테이블 이름을 지정할 수 있다.

## Post 클래스와 매핑되는 table insert query문 만들기 (post table 생성)

jpa를 사용하면 일반적으로 엔티티 매니저또는 스프링 데이터 jpa의 CrudRepository 혹은 JpaRepository 인터페이스를 사용하여 데이터베이스 작업을 수행하는데, 직접 insert 쿼리문을 작성한다면

**`INSERT INTO post (title, content) VALUES ('제목', '내용');`**

으로 jpa 엔티티 클래스를 만들고 데이터베이스 테이블과 매핑할 수있다.

## 매핑이 잘되었는지 validate 옵션으로 확인(ddl auto로 table 생성 x)

jpa 설정에서 ddl-auto 옵션을 validate로 설정하면 자동으로 테이블을 생성하지 않고, 엔티티와 기존 테이블이 제대로 매핑되었는지만 검사한다.

그래서 데이터베이스에서CREATE TABLE로 알맞는 테이블을 생성해야한다.

또한 properties 설정에서`spring.jpa.hibernate.ddl-auto=validate`을 주어서 테이블과 엔티티간의 매핑을 검증한다.

실습

빌드 그래들

`implementation 'org.springframework.boot:spring-boot-starter-data-jpa'`

- Entity의 필드를 조회해야할 경우 @Getter는 무조건 필요
- @NoArgsConstructor
    
    기본 생성자를 만들어 준다.
    
    JPA가 기본적으로 기본 생성자를 요구
    
    @Entity가 기본 생성자를 만들어줘서 사실 안써도 된다 하지만 영속성을 지키기 위해서는 혹시 모를 개발자의 실수를 막기 위해 접근 제한자를 설정하는게 좋은데, 이때 @NoArgsConstructor를 사용하여 Protected로 설정할 수 있다.
    
    private이 아닌 이유 : JPA가 접근할 수 있는 최고가 Protected 라서
    

```java
@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder  //  선언한 클래스의 빌더 패턴을 가지는 클래스를 생성
@Entity  //  User라는 객체와 DB 테이블을 매핑
@Table(name = "user")  //  테이블 이름을 지정, 선언 안할시 클래스 이름으로 드감
public class User { 
		@Id // 변수 PK선언
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값이 없어도 자동으로 할당
    private Long id;

    @Column(nullable = true) // 테이블의 컬럼 설정 값을 명시
    private String name;
}
```

- @AllArgsContructor
    
    전체 필드에 대한 생성자를 만들어준다.
    
    JPA에서는 Setter를 쓰지 않는다(영속성을 잃을까봐). 대신 빌더 패턴이라는걸 사용하는데, @Builder는 전체 필드에 대한 값을 필요로 하기 때문에 생성자가 필요하다.
    
    @NoArgsContructor가 있어도 접근제한자때문에 에러가 발생할 수 있다.
    
    근데 @Entity도 생성자가 존재하면 기본 생성자를 생성 안하기 때문에
    
    @NoArgsContructor로 기본 생성자를 생성하고 영속성을 지키기 위해 Protected 설정을 하고
    
    @AllArgsContructor로 전체 필드에 대한 생성자를 생성하여 @Builder를 사용할 수 있게 하고
    
    @Entity를 선언하면 된다.
    
- **@Entity**
    
    객체(클래스)와 테이블을 매핑
    
    @Table의 name을 설정하지 않으면 클래스 이름을 기준으로 매핑
    
- **@Table**
    
    객체와 매핑할 테이블을 직접 지정
    
    속성
    
    - Name : 매핑할 테이블 이름 (Default -> @Entity 이름 사용)
    - Catalog : catalog 기능이 있는 DB에서 catalog를 매핑
    - Schema : schema 기능이 있는 DB에서 schema를 매핑
    - uniqueConstraints : DDL 생성 시 유니크 제약조건을 만들어줌. 스키마 자동 생성 기능을 사용해서 DDL 구문을 만들 때만 사용
    
- **@Id**
    
    해당 필드를 기본키(PK)로 지정합니다.
    
- **@GeneratedValue**
    
    기본키 생성 설정, 자동 생성 기능이 있다.
    
    ```java
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    ```
    

- **@Column**
    
     객체 필드를 테이블 컬럼에 매핑
    
    속성 중 대표적으로 name, nullable을 사용
    
    - name : 필드와 매핑할 테이블 컬럼 이름 설정
    - nullable : null값 허용 여부를 설정 (true / false | Default = true)

- @Autowired
    
    필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입
    
    생성자, setter, 필드에 사용 가능
    

## **@RestController** GET 매핑 POST 매핑 DELETE 매핑 PUT 매핑

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts") // 이 경로를 기본으로 하는 요청을 처리합니다.
public class PostController {

    @Autowired
    private PostRepository postRepository; // JPA를 위한 리포지토리

    // CREATE: POST 요청을 처리
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    // READ: GET 요청을 처리, 모든 포스트 조회
    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // READ: GET 요청을 처리, 단일 포스트 조회
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
    }

    // UPDATE: PUT 요청을 처리, 포스트 업데이트
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        return postRepository.save(post);
    }

    // DELETE: DELETE 요청을 처리, 포스트 삭제
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        postRepository.delete(post);
    }
}
```

이런식으로 REST함을 지키면서 코딩한게 RESTful하다.

리팩토링한 코드는 git에 올림

빈(Bean)은 스프링 컨테이너가 관리하는 자바 객체를 뜻한다.

## EX01 DB 공부

참고 자료

[https://opentutorials.org/course/3883](https://opentutorials.org/course/3883)

데이터 모델링

말의 불신 (각자가 서로 이해한바를 이야기하면서 crosscheck하기)

OVENapp

업무파악 → 개념적 데이터 모델링 → 논리적 데이터 모델링 → 물리적 데이터 모델링

개념적 데이터 모델링 : 엔티티 → 속성 → 식별자

논리적 데이터 모델링 : 1대1 1대다 다대다 순으로 만들면 쉬움

1대1 : FK가 의존성에 따라 다름 (의존하는 쪽이 FK)

1대다 : 1쪽의 PK가 다 쪽의 FK로 들어간다.

다대다 : 매핑 테이블을 작성해서 둘 다의 PK를 FK로 받는다.

정규화 normalization

제 3 정규화까지 산업에서 사용, 6정규화까지는 학술적

제 1 정규화 : atomic column || 각 행이 한개의 값만 가질것.

제 2 정규화 : No partial dependencies || 부분 종속성이 없어야한다.

제 3 정규화 : No transitive dependencies || 이행적 종속성이 없어야 한다. || 한 표 안에 기준이 두개면 안됨.

역정규화 denormalization

정규화에서 쓰기 성능을 올렸으나 읽기 성능이 저하됨을 해결하기위해 역 정규화를 최후의 수단으로 사용한다.

하지만 봐도 잘 모르며, data stack에서 실 사용 시간을 보고 수정해보는것이 나아 보이므로, 추후 추가 예정

[https://opentutorials.org/course/3161](https://opentutorials.org/course/3161)

MySQL(Structured Query Language)

표(table)의 집합 → 스키마(schema) - 서로 연관된 정보를 저장

스키마의 집합 → 데이터베이스 서버(를 관리하는게 MySQL)

세로 줄 (row, record, 행)

가로 줄 (column, 열)

mysql -u root(사용자이름) -p (mysql파일)

데이터베이스(스키마) 생성  `CREATE DATABASE 데이터베이스이름;`

데이터베이스(스키마) 삭제 DROP DATABASE 데이터베이스이름;

데이터베이스(스키마) 목록보기 SHOW DATABASES;

데이터베이스 사용하기 USE 데이터베이스이름;

```java
CREATE TABLE 테이블이름(
		id INT(최대값)
)
```

INSERT INTO table_name(열 이름 나열) VALUES(값 나열)

DESC table = 테이블의 구조를 설명(describe)

Select * From t

SELECT 컬럼명, 컬럼명

FROM 테이블명

WHERE 컬럼명 = '값'

ORDER BY 컬럼명 <ASC/DESC>

LIMIT <숫자>

UPDATE 테이블명

SET 컬럼명 = '변경할 값, 컬럼명 = '변경할 값'

WHERE 컬럼명 = '값'

DELETE FROM 테이블명 WHERE 컬럼값='값';