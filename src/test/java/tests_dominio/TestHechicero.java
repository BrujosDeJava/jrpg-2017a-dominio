package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestHechicero {
	
  @Test
  public void testConstructor(){
	  Hechicero h = new Hechicero();
	  Assert.assertEquals("Bola de Fuego", h.getHabilidadesCasta()[0]);
	  
  }
	
  @Test
  public void testCurar() {
    final Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    e.setRandgen(new MyRandomStub(0.5));
    e.serAtacado(50);
    Assert.assertEquals(e.getSalud(), 70);
    h.habilidadCasta2(e);
    Assert.assertEquals(e.getSalud(), 100);
  }

  @Test
  public void testBolaDeFuego() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    e.setRandgen(new MyRandomStub(0.5));
    Assert.assertEquals(e.getSalud(), 100);
    h.habilidadCasta1(e);
    Assert.assertTrue(e.getSalud() < 100);
  }

  @Test
  public void testBolaDeFuegoFallido() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    e.setRandgen(new MyRandomStub(0.1));
    Assert.assertEquals(e.getSalud(), 100);
    h.habilidadCasta1(e);
    Assert.assertEquals(e.getSalud(), 100);
  }

  @Test
  public void testRobarEnergia_y_Salud() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Assert.assertTrue(e.getSalud() == 100);
    h.setRandgen(new MyRandomStub(0.5));
    e.setRandgen(new MyRandomStub(0.5));
    h.serAtacado(50);
    h.serDesernegizado(50);
    Assert.assertEquals(h.getSalud(), 70);
    Assert.assertEquals(h.getEnergia(), 70);
    h.habilidadCasta3(e);
    Assert.assertTrue(e.getSalud() < 100);
    Assert.assertTrue(h.getEnergia() > 70);
    Assert.assertTrue(h.getSalud() > 70);

  }

  @Test
  public void testSinEnergia() {
    Humano h = new Humano("Nico", 100, 0, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Assert.assertFalse(h.habilidadCasta1(e));
    Assert.assertFalse(h.habilidadCasta2(e));
    Assert.assertFalse(h.habilidadCasta3(e));

  }

}
