package com.example.sechung.member.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * MemberEntityImplTest.
 *
 * @author : middlefitting
 * @since : 2023/10/17
 */
class MemberEntityImplTest {

  @Test
  void getImplTest() {
    MemberEntity memberEntity = new MemberEntityImpl();
    memberEntity.getId();
    memberEntity.getName();
    memberEntity.getAddress();
  }


}