package dominio;

import java.util.LinkedList;
import java.util.List;

public class Inventario extends Item {
  private List<Item> inv;

  public Inventario() {
    inv = new LinkedList<Item>();
  }
  
  /**
   * Falta JavaDoc. 
   */
  public void añadir(Item o) {
    inv.add(o);
    this.setSalud(o.getSalud() + this.getSalud());
    this.setEnergia(o.getEnergia() + this.getEnergia());
    this.setAtaque(o.getAtaque() + this.getAtaque());
    this.setDefensa(o.getDefensa() + this.getDefensa());
    this.setMagia(o.getMagia() + this.getMagia());
  }

  /**
   * Falta JavaDoc. 
   */
  public void eliminar(Item o) {
    inv.remove(o);
    this.setSalud(this.getSalud() - o.getSalud());
    this.setEnergia(this.getEnergia() - o.getEnergia());
    this.setAtaque(this.getAtaque() - o.getAtaque());
    this.setDefensa(this.getDefensa() - o.getDefensa());
    this.setMagia(this.getMagia() - o.getMagia());
  }

  public List<Item> getInv() {
    return inv;
  }

  @Override
  public String toString() {
    String aux = "";
    for (int i = 0; i < inv.size(); i++) {
      if (inv.get(i) != null) {        
        aux += inv.get(i).toString();
      }
    }
    return aux;
  }

}
