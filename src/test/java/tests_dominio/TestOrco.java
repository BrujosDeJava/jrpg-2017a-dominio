package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;

public class TestOrco {

	@Test
	public void testGolpeDefensivo() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Orco o = new Orco("Hernan", new Guerrero(), 1);
		Assert.assertEquals(h.getSalud(),105);
		h.setRandgen(new MyRandomStub(0.5));
		o.habilidadRaza1(h);
		Assert.assertEquals(h.getSalud(),95);
		}
	
	@Test
	public void testGolpeDefensivoFallido() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Orco o = new Orco("Hernan", new Guerrero(), 1);
		Assert.assertEquals(h.getSalud(),105);
		h.setRandgen(new MyRandomStub(0.1));
		o.habilidadRaza1(h);
		Assert.assertEquals(h.getSalud(),105);
	}
	
	@Test
	public void testMordiscoDeVida() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(o.getSalud(), 100);
		h.setRandgen(new MyRandomStub(0.5));
		o.habilidadRaza2(h);
		Assert.assertEquals(40, h.getSalud());
		Assert.assertEquals(o.getSalud(), 100);
	}
	
	@Test
	public void testMordiscoDeVidaFallido() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Juan", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(o.getSalud(), 100);
		h.setRandgen(new MyRandomStub(0.1));
		o.habilidadRaza2(h);
		Assert.assertEquals(o.getSalud(), 100);
		Assert.assertEquals(o.getSalud(), 100);
	}
	@Test
	public void testSinEnergia() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Juan", 100, 0, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(o.getEnergia(), 0);
		Assert.assertFalse(o.habilidadRaza1(h));
		Assert.assertFalse(o.habilidadRaza2(h));
	}
}
