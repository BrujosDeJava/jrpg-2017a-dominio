package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mercado {
	private Map<Integer, ArrayList<Item>> mochilas;

	public Mercado() {
		this.mochilas = new HashMap<Integer, ArrayList<Item>>();
	}

	public Map<Integer, ArrayList<Item>> getMochilas() {
		return mochilas;
	}

	public void setMochilas(Map<Integer, ArrayList<Item>> mochilas) {
		this.mochilas = mochilas;
	}

	public void aniadir(int n, List<Item> list) {
		mochilas.put(n, (ArrayList<Item>) list);
	}

	public void remover(int n) {
		mochilas.remove(n);
	}
}
