package tests_dominio;

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
}
