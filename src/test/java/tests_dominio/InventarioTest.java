package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Humano;
import dominio.Inventario;
import dominio.Item;
import dominio.Personaje;

public class InventarioTest {
	@Test
	public void test1(){
		for(int i=0;i<50;i++)
		System.out.println(Item.generarItem());
	}
	
	public int random(int d){
		return d%6+1;
		//return (int) Math.round(Math.random() * max);
	}
	
	@Test
	public void getCabezaTest(){
		Inventario in = new Inventario();
		in.setCabeza(new Item(1,1));
        Assert.assertEquals(1, in.getCabeza().getId());
		
	}
	
	@Test
	public void getManosTest(){
		Inventario in = new Inventario();
		in.setManos(new Item(2,1));
        Assert.assertEquals(2, in.getManos().getId());
		
	}
	
	@Test
	public void getPiesTest(){
		Inventario in = new Inventario();
		in.setPies(new Item(3,1));
        Assert.assertEquals(3, in.getPies().getId());
		
	}
	
	@Test
	public void getCuerpoTest(){
		Inventario in = new Inventario();
		in.setCuerpo(new Item(4,1));
        Assert.assertEquals(4, in.getCuerpo().getId());
		
	}
	
	@Test
	public void getAccesorioTest(){
		Inventario in = new Inventario();
		in.setAccesorio(new Item(5,1));
        Assert.assertEquals(5, in.getAccesorio().getId());
		
	}
	
	@Test
	public void getArma(){
		Inventario in = new Inventario();
		in.setArma(new Item(6,1));
        Assert.assertEquals(6, in.getArma().getId());
		
	}
	
	@Test
	public void aniadirTest(){
		Inventario in = new Inventario();
		in.setCabeza(new Item(1,1));
		in.setManos(new Item(2,1));
		in.setPies(new Item(3,1));
		in.setCuerpo(new Item(4,1));
		in.setAccesorio(new Item(5,1));
		in.setArma(new Item(6,1));
		in.aniadir(new Item(1,1));
		in.aniadir(new Item(2,1));
		in.aniadir(new Item(3,1));
		in.aniadir(new Item(4,1));
		in.aniadir(new Item(5,1));
		in.aniadir(new Item(6,1));
        Assert.assertEquals(1, in.getCabeza().getId());
        Assert.assertEquals(2, in.getManos().getId());
        Assert.assertEquals(3, in.getPies().getId());
        Assert.assertEquals(4, in.getCuerpo().getId());
        Assert.assertEquals(5, in.getAccesorio().getId());
        Assert.assertEquals(6, in.getArma().getId());
		
	}
	public void aniadirTest2(){
		Inventario in = new Inventario();
		in.aniadir(new Item(1));
		Assert.assertEquals(1, in.getCabeza().getId());
	}
	
}
