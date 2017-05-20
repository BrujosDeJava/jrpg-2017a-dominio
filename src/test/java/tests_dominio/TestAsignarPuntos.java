package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestAsignarPuntos {

	@Test
	public void testAumentarSalud_tope(){
		Personaje.cargarTablaNivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertEquals(h.getSaludTope(),105);
		h.ganarExperiencia(50);
		Assert.assertEquals(h.getSaludTope(),130);
		}
	
	@Test
	public void testAumentarEnergia_tope(){
		Personaje.cargarTablaNivel();

		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Assert.assertEquals(h.getEnergiaTope(),105);
		h.ganarExperiencia(50);
		Assert.assertEquals(h.getEnergiaTope(),125);
	}
	
	@Test
	public void testMasDe200Puntos(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		h.setFuerza(199);
		h.setDestreza(199);
		h.setInteligencia(199);
		h.AsignarPuntosSkills(2, 2, 2);
		Assert.assertEquals(h.getFuerza(),199);
		Assert.assertEquals(h.getDestreza(),199);
		Assert.assertEquals(h.getInteligencia(),199);
	}
}
