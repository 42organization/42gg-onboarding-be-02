package com.example.sechung.post.entity;

import java.lang.reflect.InvocationTargetException;

/**
 * PostEntityFactory.
 *
 * <p>
 *  PostEntity를 상속받은 클래스를 생성하는 팩토리 클래스
 *  <br>
 *  getDeclaredConstructor() : 리플렉션 API를 사용하여 생성자를 가져온다.
 *  <br>
 *  newInstance() : 생성자를 통해 객체를 생성한다.
 *  <br>
 *  NoSuchMethodException : 생성자가 없을 경우 발생한다.
 *  <br>
 *  InvocationTargetException : 메서드 내부에서 발생하는 예외를 JVM이 InvocationTargetException으로 감싸서 던진다.
 *  <br>
 *  InstantiationException : 추상 클래스나 인터페이스일 경우 발생한다.
 *  <br>
 *  IllegalAccessException : 생성자에 접근할 수 없을 경우 발생한다.
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/10/22
 */
public class PostEntityFactory<T extends PostEntity> {

  public T getNewInstance(Class<T> clazz) {
    try {
      return clazz.getDeclaredConstructor().newInstance();
    } catch (NoSuchMethodException | InvocationTargetException |
             InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
