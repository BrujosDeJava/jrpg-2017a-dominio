package dominio;

public class Item {
  private String nombre;
  private int salud;
  private int magia;
  private int ataque;
  private int energia;
  private int defensa;
  private int id;

  public Item() {
  }
  
  public Item(String nombre) {
    super();
    this.nombre = nombre;
  }

  public Item(int n) {
	this.id =n;
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

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void setNombre(String string) {
	this.nombre=string;
}

@Override
public String toString() {
	return "Item [nombre=" + nombre + ", salud=" + salud + ", magia=" + magia + ", ataque=" + ataque + ", energia="
			+ energia + ", defensa=" + defensa + ", id=" + id + "]";
}
  
}
