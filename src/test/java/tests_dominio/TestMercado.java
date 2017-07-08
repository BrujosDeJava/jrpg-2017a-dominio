package tests_dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import dominio.Item;
import dominio.Mercado;
import junit.framework.Assert;

public class TestMercado {

	@Test
	public void test() {
	
	}
	
	@Test
	public void testMercado(){
		
		Mercado m = new Mercado();
		Map<Integer, ArrayList<Item> > mochilas  = new HashMap<Integer, ArrayList<Item> >();
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item(1,1));
		mochilas.put(1, items);
		m.setMochilas(mochilas);
		Assert.assertEquals(1, m.getMochilas().get(1).get(0).getId());
		
	}
	
	@Test
	public void testAniadir(){
		Mercado m = new Mercado();
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item(1,1));
		m.aniadir(1, items);
		Assert.assertEquals(1, m.getMochilas().get(1).get(0).getId());
		
		
	}
	
	@Test
	public void testemover(){
		Mercado m = new Mercado();
		Map<Integer, ArrayList<Item> > mochilas  = new HashMap<Integer, ArrayList<Item> >();
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item(1,1));
		m.aniadir(1, items);
		Assert.assertEquals(1, m.getMochilas().get(1).get(0).getId());
		m.remover(1);
		Assert.assertNull(m.getMochilas().get(1));
		
		
	}
	
	

}
