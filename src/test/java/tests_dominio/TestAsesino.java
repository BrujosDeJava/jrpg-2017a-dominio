package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestAsesino {

	@Test
	public void testHabilidad3(){ 
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertFalse(h.habilidadCasta3(h2));
	}
	
	@Test
	public void testHabilidad1(){
		Humano h = new Humano("Nicolas", new Asesino(), 1);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertEquals(105, h2.getSalud());
		h2.setRandgen(new MyRandomStub(0.5));
		h.habilidadCasta1(h2);
		Assert.assertEquals(93, h2.getSalud());
	}
	
	@Test
	public void testHabilidad1Fallida(){
		Humano h = new Humano("Nicolas", new Asesino(), 1);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		h2.setRandgen(new MyRandomStub(0.1));
		Assert.assertEquals(105, h2.getSalud());
		h.habilidadCasta1(h2);
		Assert.assertEquals(105, h2.getSalud());
	}
	
	@Test
	public void testProbEvasion(){
		Humano h = new Humano("Nico",100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertEquals(0.3, h.getCasta().getProbabilidadEvitarDano(),0.0001);
		h.habilidadCasta2(null);
		Assert.assertEquals(0.45, h.getCasta().getProbabilidadEvitarDano(), 0.0001);
		h.habilidadCasta2(null);
		Assert.assertEquals(0.5,h.getCasta().getProbabilidadEvitarDano(),0.0001);
	}

	@Test
	public void testSinEnergia(){
		Humano h = new Humano("Nico",100, 0, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertFalse(h.habilidadCasta1(h2));
		Assert.assertEquals(0.3, h.getCasta().getProbabilidadEvitarDano(), 0.0001);
		h.habilidadCasta2(null);
		Assert.assertEquals(0.3, h.getCasta().getProbabilidadEvitarDano(), 0.0001);
		h.habilidadCasta2(null);
		Assert.assertEquals(0.3,h.getCasta().getProbabilidadEvitarDano(), 0.0001);
		Assert.assertFalse(h.habilidadCasta3(h2));
	}
}
