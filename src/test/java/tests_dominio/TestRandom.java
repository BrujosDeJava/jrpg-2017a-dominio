package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.MyRandom;
import dominio.MyRandomStub;

public class TestRandom {
  @Test
  public void testRandomStub() {
    MyRandomStub r1 = new MyRandomStub(5);
    Assert.assertEquals(r1.randomInt(1), 5, 0.001);
    MyRandomStub r2 = new MyRandomStub(0.99);
    Assert.assertEquals(r2.randomDouble(), 0.99, 0.001);
  }
}
