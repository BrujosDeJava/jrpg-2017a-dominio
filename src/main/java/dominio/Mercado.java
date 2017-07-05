package dominio;

import java.util.HashMap;
import java.util.Map;

public class Mercado {
	private Map<Integer,Inventario> mochilas;
	
	public Mercado(){
		this.mochilas = new HashMap<Integer,Inventario>();
		
	}
}
