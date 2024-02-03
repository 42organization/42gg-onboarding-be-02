# 자바 스프링 5회차

## **과제 09: 예외 처리**

### 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)

try ~ catch - 다른 작업으로 유도

```jsx
try {
     예외가 생길 가능성이 있는 코드 작성
} catch(예외발생 클래스명 e){
     예외처리 코드
}
마지막에 finally를 추가하기도 함(try건 catch건 다 써짐)
```

발생한 예외에 해당하는 인스턴스가 만들어지고

catch 블럭의 참조변수의 자료형과 만들어진 인스턴스를 instanceof 연산자로 비교하며 찾고,  찾으면 catch를 실행, 아니면 jvm에게 인도

throws - 호출한 쪽(부모)에게 위임

```jsx
void method() throws Exception{
	// 메서드 내용
}

예외처리를 떠넘기면 반드시 불렀던 곳에서는 Try catch로 막아야함
```

throw - 명확한 의미의 예외로 처리(비즈니스 로직)

```jsx
class Main {
    public static void main(String args[]) {
        try {
            Exception e = new Exception("my exception\n");
            throw e;
        } catch (Exception e) {
            System.out.println("catch" + e.getMessage() + "\n");
            e.printStackTrace();
        }
        System.out.println("program close\n");
    }
}
```

사용자가 직접 예외를 발생시키고 싶은 곳에 throw XXXException(); 을 통해 예외를 발생시키고 throws를 통해 위임하는것

finally

finally 블럭은 예외의 발생여부에 상관없이 실행되야할 코드를 포함시킬 목적으로 사용된다

try-catch문의 끝에 선택적으로 덧붙여 사용할 수 있다

예외 발생시 try-catch-finally

예외 미발생시 try-finally

```jsx
try {
	// 예외가 발생할 가능성이 있는 code
} catch (Exception1 e1) {
	// 예외에 따른 행동 요령
} finally {
	// 일단 실행되는 code
}
```

try-catch 문의 변형으로

주로 입출력에 사용되는 클래스 중에서는 사용 후 꼭 닫아주어야 한다

하지만 finally 블럭에 close() 를 하려면 그에 따른 예외 처리를 위해

추가적인 try-catch 문이 들어가 가독성이 떨어지는데, 그 부분을 해결하기 위해 try 블럭의 () 안에 리소스를 선언시 자동으로 close()를 해주는 식으로 나왔다

(try-with-resources)

```jsx
try (FileInputStream fis = new fileInputStream("score.dat");
	 DataInputStream dis = new DatainputStream(fis)) {
     while(true) {
     	score = dis.readInt();
        System.out.println(score);
        sum += score;
     }
} catch (EOFException e) {
	System.out.println("점수의 총합은" + sum +"입니다.");
} catch (IOException ie) {
	ie.printStackTrace();
}
```

### 자바가 제공하는 예외 계층 구조

![Untitled](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%89%E1%85%B3%E1%84%91%E1%85%B3%E1%84%85%E1%85%B5%E1%86%BC%205%E1%84%92%E1%85%AC%E1%84%8E%E1%85%A1%20f825f2bf1225411ba7c502b76f76a10a/Untitled.png)

모든 예외 클래스는 Throwable 클래스를 상속받는다.

개발로직은 Exception만 처리하면 된다.

### Exception과 Error의 차이는?

Error(오류)는 시스템 비정상적인 상황에서 생겼을때 발생.

이는 시스템레벨에서 발생하기때문에 심각한 수준의 오류이며, 개발자가 미리 예측하여 처리할 수 없기에 오류에 대한 처리는 신경쓰지 않음

Exception(예외)는 비정상적인 상황을 예측해서 처리하는 것.

구현된 로직에서 예외를 예측하고 예외처리를 신경써야한다.

### RuntimeException과 RE가 아닌 것의 차이는?

- Compile Exception(Checked Exception)
    
    예외처리 필수
    
    컴파일 단계
    
    IOException  :  파일, 소켓 등 읽기 쓰기 관련 예외처리
    
    SQLException : DB관련 예외처리
    
    ClassNotFoundException : 런타임할때 클래스 없는 예외처리
    
    try ~ catch || throw 문으로 처리(안할시 컴파일 에러)
    
    장점 : 예외를 누락하지 않게끔 컴파일러가 잡아줘서 안전함
    
    단점 : 다 처리해야하니까 귀찮으며 의존관계가 생김
    
- RuntimeException(Unchecked Exception)
    
    Unchecked Exception은 RuntimeException 을 상속
    
    필수는 아님
    
    런타임 단계
    
    복구가 불가능함(프로그램이 꺼짐)
    
    NullPointerException IndexOutOfBoundException // ArithmeticException(정수를 0으로 나눔) // IllegalArgumentException(잘못된 인수를 메소드에 전달) // InvalidFormatException(데이터 형식이 유효하지 않은 상황) // NumberFormatException(문자열을 숫자로 변환하려고 시도했지만 형식이 유효하지 않은 경우)
    
    처리방법(Exception 에러메세지를 출력)
    

### 커스텀한 예외 만드는 방법

throw는 Exception을 던질때 예외내용을 주지 않는다.

그래서 Exception을 커스터마이징해서 그 안에 메세지를 담아서 넘긴다.

throw는 개발자가 직접 예외를 발생시키기위해 사용하지만, 추가적으로 Exception 재정의해서 사용하기도 한다(Custom Exception)

처리전략

CheckedException

- 기본원칙은 언체크 예외를 사용하자.
- CheckedException는 비즈니스 로직상 의도적으로 던지는 예외로만(try ~ catch & throws) 사용하자.
- throws Exception 사용 x => 구체적인 체크 예외로 밖으로 던지는 방식(try ~ catch & throws)으로 하자.
    
    시스템 예외는 Controller, Service 클래스에서는 대부분 복구가 불가능하고 처리할 수 없는 체크 예외이다. 따라서 다음과 같이 처리해주어야 한다.
    
    ```jsx
    void method() thorws SQLException, ConnectionException {...}
    ```
    

UnCheckedException

- 타임 예외를 사용하면 중간에 기술이 변경되어도 해당 예외를 사용하지 않는 controller, service에서는 코드를 변경하지 않아도 된다.
- 그래서 스프링에서도 기본적으로 런타임 예외처리를 제공한다.

```java
throw new ArithmeticException("Division by zero");
```

- 예외를 공통으로 처리하는 ExceptionHandler를 만들어서 처리

**exception 스택 트레이스 e.printStackTrace();**

```jsx
public void call() {
	try {
    	runSQL();
    } catch (SQLException e) {
    	e.printStackTrace();            // e.printStackTrace()으로 확인하기 편하다.
    	throw new RuntimeException(e);	// => RuntimeException()(x) 기존 예외(e) 넣기
    }
기존 예외인 e를 같이 넣어서 e(exception)의 printStackTrace에서 예외들을 다 확인할 수 있다.
```

## **과제 10: 멀티쓰레드 프로그래밍**

프로세스(process) 실행중인 프로그램

프로그램을 수행하는데 필요한 데이터, 메모리 등 자원과 쓰레드로 구성되어 있다.

프로세스의 자원을 이용해서 실제 작업을 수행하는 것이 쓰레드

모든 프로세스에는 최소한 하나 이상의 쓰레드가 존재하고, 둘 이상의 쓰레드를 가진 프로세스를 멀티쓰레드 프로세스라 한다.

멀티쓰레딩 | 하나의 프로세스 내에서 여러 쓰레드가 동시에 작업을 수행

장점

- CPU의 사용률을 향상
- 자원을 보다 효율적으로 사용
- 사용자에 대한 응답성 향상
- 작업이 분리되어 코드 간결

동기화(synchronization), 교착상태(deadlock)등을 조심해야함.

### Thread 클래스와 Runnable 인터페이스

쓰레드를 구현하는 방법은 Thread 클래스를 상속받거나 Runnable 인터페이스를 구현하는 방법으로 나뉜다.

Thread 클래스를 상속받으면 다른 클래스를 상속받을 수 없기 때문에 Runnable인터페이스를 구현하는 것이 일반적이다.

run()메소드만 오버라이딩 할 경우엔 Runnable 인터페이스를 사용하고, Thread의 다른 메소드들을 오버라이딩 할 것이면 Thread 클래스를 상속받으면 된다.

쓰레드는 순서대로 실행하지 않는다.

### 쓰레드의 상태

![Untitled](%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%89%E1%85%B3%E1%84%91%E1%85%B3%E1%84%85%E1%85%B5%E1%86%BC%205%E1%84%92%E1%85%AC%E1%84%8E%E1%85%A1%20f825f2bf1225411ba7c502b76f76a10a/Untitled%201.png)

| NEW | 쓰레드 객체는 생성되었지만, 시작되지 않은 상태 |
| --- | --- |
| RUNNABLE | 실행중인 상태 |
| BLOCKED | 실행 중지 상태이며, 모니터 락이 풀리기를 기다리는 상태 |
| WAITING | 대기중인 상태 |
| TIMED_WAITING | 특정 시간만큼 쓰레드가 대기중인 상태 |
| TERMINATED | 쓰레드가 종료된 상태 |

### 쓰레드의 우선순위

### Main 쓰레드

- Java는 실행 환경인 JVM에서 돌아가게 된다. 이것이 하나의 프로세스이고 Java를 실행하기 위해 우리가 실행하는 메인 메소드가 메인 쓰레드이다.
- `public static void main (String[] args) {}` 이것이 메인 쓰레드이고 메인 쓰레드의 시작점을 선언하는 것이다.
- 따로 쓰레드를 실행하지 않고 메인 메소드만 실행하는 것을 싱글 쓰레드 애플리케이션 이라고 한다

**Daemon Thread**

- Main 쓰레드의 작업을 돕는 보조적인 역할을 하는 쓰레드이다
- Main 쓰레드가 종료되면 데몬 쓰레드는 강제적으로 종료된다.

### **Deamon Thread 사용**

- Main 쓰레드가 Daemon 이 될 쓰레드의 `setDaemon(true)`를 호출해주면 Daemon 쓰레드가 된다

DaemonThread

```scala
public class DaemonThread extends Thread{
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
public void runCommonThread() {
    DaemonThread thread = new DaemonThread();
    thread.start();
}
```

- 이렇게 실행하면 long의 최대값 만큼 대기하게 된다

runDaemonThread

```tsx
public void runDaemonThread() {
    DaemonThread thread = new DaemonThread();
    thread.setDaemon(true);
    thread.start();
}
```

- 프로그램이 대기하지 않고 그냥 끝나버린다. 즉 데몬 쓰레드는 해당 쓰레드가 종료되지 않아도 다른 실행중인 일반 쓰레드가 없다면 멈춰버리게된다

### **데몬쓰레드를 만든 이유?**

그래서 데몬쓰레드는 왜 만들었을까?

- 예를 들어 모니터링하는 쓰레드를 별도로 띄워 모니터링을 하다가, Main 쓰레드가 종료되면 관련된 모니터링 쓰레드가 종료되어야 프로세스가 종료될 수 있다. 모니터링 스레드를 데몬 쓰레드로 만들지 않으면 프로세스가 종료할 수 없게 된다. 이렇게 부가적인 작업을 수행하는 쓰레드를 선언할 때 데몬 쓰레드를 만든다.

### 동기화(Synchronize)

여러 개의 쓰레드가 한 개의 리소스를 사용하려고 할 때 사용 하려는 쓰레드를 제외한 나머지들을 접근하지 못하게 막는 것이다.

이것을 쓰레드에 안전하다고 하다.(Thread-safe)

자바에서 동기화 하는 방법은 3가지로 분류

- Synchronized 키워드
- Atomic 키워드
- Volatile 키워드

Synchronized 키워드

java 예약어 중 하나로 변수명이나 클래스명으로 사용이 불가능하다.

메소드 자체를 synchronized methods로 선언하는 방법

메소드 내의 특정 문장만 synchronized로 감싸는 방법(synchronized statements)

synchronized에 this를 사용하면 메서드에 붙이는것과 같은 효과이다.

하지만 다른 object에 lock을 걸게되면 다르게 적용된다.

Atomic 키워드

쪼갤 수 없는 가장 작은 단위를 뜻한다.

Atomic Type은 Wrapping 클래스의 일종으로, 참조 타입과 원시 타입 두 종류 적용 가능하고, 내부적으로 CAS(Compare-And-Swap) 알고리즘을 사용해 lock 없이 동기화 처리를 할 수 있다.

CAS란?

메모리 위치의 내용을 주어진 값과 비교하고 동일한 경우에만 해당 메모리 위치의 내용을 새로 주어진 값으로 수정

현재 주어진 값과 실제 데이터와 저장된 데이터를 비교해서 두 개가 일치할때만 값을 업데이트한다.

java.util.concurrent.atomic에 정의된 클래스이다.

CAS는 특정 메모리 위치와 주어진 위치의 value를 비교하여 다르면 대체하지 않는다.

사용법은 변수 앞에 Atomic을 붙이면 된다. ex) AtomicLong

Volatile 키워드

java 변수를 Main Memory에 저장하겠다는것을 명시하는 키워드

변수의 값을 Read할때 CPU cache가 아닌 MainMemory에서 읽고, 변수의 값을 Write할 때 마다 Main Memory에 작성

Volatile 변수를 사용하고 있지 않는 MultiThread 애플리케이션은 작업을 수행하는 동안 성능 향상을 위해서 Main Memory에서 읽은 변수를 CPU Cache에 저장하게 된다

만약 Multi Thread환경에서 Thread가 변수 값을 읽어올 때 각각의 CPU Cache에 저장된 값이 다르기 때문에 변수 값 불일치 문제가 발생하게 된다.

### 데드락

Deadlock(교착상태)란 둘 이상의 쓰레드가 lock을 획득하기 위해 대기하는데, 이 lock을 잡고 있는 쓰레드들도 다른 lock을 기다리면서 block 상태에 놓이는 것을 말한다.

상호 배제 / 점유 대기 / 비선점 / 순환 대기

4가지 발생조건이 모두 충족할 때 데드락이 발동 됨.

하나만 막더라도 데드락을 막을 수 있다.

다수의 쓰레드가 같은 lock을 동시에, 다른 명령에 의해 획득하려 할 때 발생할 수 있다.

서로가 서로를 쳐다보는 상태로 영원히 기다리고만 있게 된다.