package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestElfo {

  @Test
  public void testGolpeLevel() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
    h.setRandgen(new MyRandomStub(0.5));
    Assert.assertEquals(h.getSalud(), 100);
    e.habilidadRaza1(h);
    Assert.assertTrue(h.getSalud() < 100);
  }

  @Test
  public void testGolpeLevelFallido() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
    h.setRandgen(new MyRandomStub(0.1));
    e.habilidadRaza1(h);
    Assert.assertEquals(h.getSalud(), 100);
  }

  @Test
  public void testAtaqueBosque() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
    h.setRandgen(new MyRandomStub(0.5));
    Assert.assertEquals(h.getSalud(), 100);
    e.habilidadRaza2(h);
    Assert.assertTrue(h.getSalud() < 100);

  }

  @Test
  public void testAtaqueBosqueFallido() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
    h.setRandgen(new MyRandomStub(0.1));
    Assert.assertEquals(h.getSalud(), 100);
    e.habilidadRaza2(h);
    Assert.assertEquals(h.getSalud(), 100);
  }

  @Test
  public void testSinEnergia() {
    Elfo e = new Elfo("Nico", 100, 0, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
    Assert.assertFalse(e.habilidadRaza1(h));
    Assert.assertFalse(e.habilidadRaza2(h));
  }
}
