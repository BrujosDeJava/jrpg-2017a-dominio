package dominio;

public class Item {
	private String nombre;
	private int salud;
	private int fuerza;
	private int dex;
	private int inteligencia;
	private int magia;
	private int ataque;
	private int energia;
	private int defensa;
	public Item(){
		
	}
	public Item(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public static Item generarItem(int n){
		Item item;
		switch(n){
		case 0:
			item = new Item("Espada");
			item.setAtaque(20);
			item.setFuerza(5);
			break;
		case 1:
			item = new Item("Armadura");
			item.setDefensa(15);
			item.setSalud(20);
			break;
		case 2:
			item = new Item("Casco");
			item.setDefensa(10);
			item.setDex(5);
			break;
		case 3:
			item = new Item("Baculo");
			item.setMagia(30);
			item.setEnergia(5);
			break;
		case 4:
			item = new Item("Gorro");
			item.setInteligencia(20);
			item.setEnergia(30);
			break;
		case 5:
			item = new Item("Botas");
			item.setDex(10);
			item.setSalud(10);
			break;
		default:
			item =new Item("Anillo");
			item.setAtaque(1);
			item.setDefensa(1);
			item.setMagia(1);
			break;
		}
		
		return item;
	}
	
	public int getMagia() {
		return magia;
	}
	public void setMagia(int magia) {
		this.magia = magia;
	}
	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public String getNombre() {
		return nombre;
	}
	
	
}
