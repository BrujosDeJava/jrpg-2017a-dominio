package tests_dominio;

import org.junit.Test;

import dominio.*;
import mensajeria.PaquetePersonajeDom;

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
		PaquetePersonajeDom pp = new PaquetePersonajeDom();

		pp.setFuerza(199);
		pp.setDestreza(199);
		pp.setInteligencia(199);
		pp.setCasta("Asesino");
		h.actualizarEstado(pp);
		h.AsignarPuntosSkills(2, 2, 2);
		Assert.assertEquals(h.getFuerza(),199);
		Assert.assertEquals(h.getDestreza(),199);
		Assert.assertEquals(h.getInteligencia(),199);
	}
}
