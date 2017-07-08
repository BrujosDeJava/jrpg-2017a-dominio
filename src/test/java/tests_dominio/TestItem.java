package tests_dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Item;
import junit.framework.Assert;

public class TestItem {

	@Test
	public void testConstructor1(){
		
		Item it = new Item("cabeza");
		
		Assert.assertEquals("cabeza", it.getNombre());
	} 
	
	@Test
	public void testGetTipo(){
		
		Item it = new Item(1,1);
		Assert.assertEquals(1, it.getTipo());
		
	}
	
	@Test
	public void testSetTipoI(){
		
		Item it = new Item("cabeza");
		it.setTipo(2);
		Assert.assertEquals(2, it.getTipo());
	}
	
	@Test
	public void testSetMagia(){
		
		Item it = new Item("cabeza");
		it.setMagia(1);
		Assert.assertEquals(1, it.getMagia());
	}
	
	@Test
	public void testGetMagia(){
		
		Item it = new Item("cabeza");
		it.setMagia(4);
		Assert.assertEquals(4, it.getMagia());
	}
	
	@Test
	public void testSetSalud(){
		
		Item it = new Item("cabeza");
		it.setSalud(3);
		Assert.assertEquals(3, it.getSalud());
	}
	
	@Test
	public void testGetSalud(){
		
		Item it = new Item("cabeza");
		it.setSalud(4);
		Assert.assertEquals(4, it.getSalud());
	}
	
	@Test
	public void testSetAtaque(){
		
		Item it = new Item("cabeza");
		it.setAtaque(1);
		Assert.assertEquals(1, it.getAtaque());
	}
	
	@Test
	public void testGetAtaque(){
		
		Item it = new Item("cabeza");
		it.setAtaque(4);
		Assert.assertEquals(4, it.getAtaque());
	}
	
	@Test
	public void testSetId(){
		
		Item it = new Item("cabeza");
		it.setId(1);
		Assert.assertEquals(1, it.getId());
	}
	
	@Test
	public void testGetId(){
		
		Item it = new Item(3);
		Assert.assertEquals(3, it.getId());
	}
	@Test
	public void testSetEnergia(){
		
		Item it = new Item("cabeza");
		it.setEnergia(1);
		Assert.assertEquals(1, it.getEnergia());
	}
	
	@Test
	public void testGetEnergia(){
		
		Item it = new Item("cabeza");
		it.setEnergia(4);
		Assert.assertEquals(4, it.getEnergia());
	}
	
	@Test
	public void testSetDefensa(){
		
		Item it = new Item("cabeza");
		it.setDefensa(1);
		Assert.assertEquals(1, it.getDefensa());
	}
	
	@Test
	public void testGetDefensa(){
		
		Item it = new Item("cabeza");
		it.setDefensa(4);
		Assert.assertEquals(4, it.getDefensa());
	}
	@Test
	public void testSetNombre(){
		
		Item it = new Item(1);
		it.setNombre("Manos");
		Assert.assertEquals("Manos", it.getNombre());
	}
	
	@Test
	public void testGetNombre(){
		
		Item it = new Item();
		it.setNombre("Pies");
		Assert.assertEquals("Pies", it.getNombre());
	}
	
	@Test
	public void testSetDuenio(){
		
		Item it = new Item("cabeza");
		it.setDuenio(1);
		Assert.assertEquals(1, it.getDuenio());
	}
	
	@Test
	public void testGetDuenio(){
		
		Item it = new Item("cabeza");
		it.setDuenio(4);
		Assert.assertEquals(4, it.getDuenio());
	}

	
}
