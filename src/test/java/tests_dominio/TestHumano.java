package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestHumano {

	@Test
	public void testIncentivar() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertEquals(e.getAtaque(), 37);
		h.habilidadRaza1(e);
		Assert.assertTrue(e.getAtaque() > 37);
	}
	@Test
	public void testGolpeFatal() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

		Assert.assertEquals(h.getEnergia(), 100);
		Assert.assertEquals(e.getSalud(), 100);
		e.setRandgen(new MyRandomStub(0.5));
		h.habilidadRaza2(e);
		Assert.assertEquals(e.getSalud(), 70);
		Assert.assertEquals(h.getEnergia(), 50);
	}
	
	@Test
	public void testGolpeFatalFallido() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		e.setRandgen(new MyRandomStub(0.1));
		Assert.assertEquals(e.getSalud(), 100);
		h.habilidadRaza2(e);
		Assert.assertEquals(e.getSalud(), 100);
	}
	
	@Test
	public void testSinEnergia() {
		Humano h = new Humano("Nico", 100, 0, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertEquals(h.getEnergia(), 0);
		Assert.assertEquals(e.getAtaque(), 37);
		h.habilidadRaza1(e);
		Assert.assertFalse(e.getAtaque() > 37);
		Assert.assertEquals(e.getSalud(), 100);
		h.habilidadRaza2(e);
		Assert.assertEquals(e.getSalud(), 100);
	}

}
