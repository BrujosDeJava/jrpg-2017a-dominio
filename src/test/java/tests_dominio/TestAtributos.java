package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

public class TestAtributos {

	@Test
	public void testIncrementarFuerza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		
		Assert.assertEquals(h.getAtaqueTotal(), 22);
		h.AsignarPuntosSkills(10, 0, 0);
		Assert.assertEquals(h.getAtaqueTotal(), 37);
	}

	@Test
	public void testIncrementarDestreza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);

		Assert.assertEquals(h.getDefensa(), 10);
		h.AsignarPuntosSkills(0, 10, 0);
		Assert.assertEquals(h.getDefensa(), 20);
	}

	@Test
	public void testIncrementarInteligencia() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(h.getMagia(), 15);
		h.AsignarPuntosSkills(0, 0, 10);
		Assert.assertEquals(h.getMagia(), 30);
	}
}
