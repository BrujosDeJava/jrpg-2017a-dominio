package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mercado {
	private Map<Integer,ArrayList<Item>> mochilas;
	
	public Mercado(){
		this.mochilas = new HashMap<Integer,ArrayList<Item>>();
	}
	
	public Map<Integer, ArrayList<Item>> getMochilas() {
		return mochilas;
	}
	
	public void setMochilas(Map<Integer, ArrayList<Item>> mochilas) {
		this.mochilas = mochilas;
	}
}
