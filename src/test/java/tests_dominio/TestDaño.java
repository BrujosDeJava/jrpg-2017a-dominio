package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandom;
import dominio.Orco;

public class TestDaño {

  @Test
  public void testLosMuertosNoAtacan() {
    Humano h = new Humano("Nico", 100, 100, 25, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);
    Orco o = new Orco("Nico", 100, 100, 15, 0, 30, new Guerrero(0.2, 0, 1.5), 0, 1, 1);

    h.atacar(o);
    h.atacar(o);
    h.atacar(o);
    h.atacar(o);

    o.atacar(h);
    Assert.assertEquals(100, h.getSalud());
  }
}