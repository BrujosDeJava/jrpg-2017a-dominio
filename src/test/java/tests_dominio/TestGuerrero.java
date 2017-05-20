package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestGuerrero {

	@Test
	public void testDobleGolpe() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		e.setRandgen(new MyRandomStub(0.5));
		Assert.assertEquals(e.getSalud(), 100);
		h.habilidadCasta1(e);
		Assert.assertTrue(e.getSalud() < 100);
		}
	
	@Test
	public void testDobleGolpeFallido(){
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		e.setRandgen(new MyRandomStub(0.1));
		Assert.assertEquals(e.getSalud(), 100);
		h.habilidadCasta1(e);
		Assert.assertTrue(e.getSalud() == 100);
	}

	@Test
	public void testAutoDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(h.getDefensa(), 20);
		h.habilidadCasta2(null);
		Assert.assertEquals(h.getDefensa(), 65);
	}
	
	@Test
	public void testIgnoraDefensa() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		e.setRandgen(new MyRandomStub(0.5));
		Assert.assertTrue(e.getSalud() == 100);
		h.habilidadCasta3(e);
		Assert.assertTrue(e.getSalud() < 100);
	}
	
	@Test
	public void testIgnoraDefensaFallido() {
		Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		e.setRandgen(new MyRandomStub(0.1));
		Assert.assertTrue(e.getSalud() == 100);
		h.habilidadCasta3(e);
		Assert.assertTrue(e.getSalud() == 100);
	}
	@Test
	public void testSinEnergia() {
		Humano h = new Humano("Nico", 100, 0, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Assert.assertFalse(h.habilidadCasta1(e));
		Assert.assertFalse(h.habilidadCasta2(null));
		Assert.assertFalse(h.habilidadCasta3(e));
	}
	
}
