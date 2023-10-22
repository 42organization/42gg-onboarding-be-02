package com.example.sechung.member.entity.type;

import static org.junit.jupiter.api.Assertions.*;

import com.example.sechung.global.type.Address;
import com.example.sechung.global.type.AddressImpl;
import org.junit.jupiter.api.Test;

/**
 * AddressImplTest.
 *
 * @author : middlefitting
 * @since : 2023/10/17
 */
class AddressImplTest {

  @Test
  void getterTest() {
    Address address = new AddressImpl("Seoul", "42", "00012");
    assertEquals("Seoul", address.getCity());
    assertEquals("42", address.getStreet());
    assertEquals("00012", address.getZipcode());
  }
}