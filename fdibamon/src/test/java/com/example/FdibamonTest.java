package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FdibamonTest {
  @Test
  public void testAttack() {
    Fdibamon fdibamon1 = new Fdibamon("testFdibamon1", 200, 50);
    Fdibamon fdibamon2 = new Fdibamon("testFdibamon2", 100, 60);

    fdibamon1.attack(fdibamon2);

    assertEquals(fdibamon2.hitpoints, 50);
  }
}
