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
    this.setAtaque(o.getAtaque() + this.getAtaque() + (int)(o.getFuerza() * 1.5));
    this.setDefensa(o.getDefensa() + this.getDefensa() + o.getDex());
    this.setMagia(o.getMagia() + this.getMagia() + (int)(o.getInteligencia() * 1.5));
  }

  /**
   * Falta JavaDoc. 
   */
  public void eliminar(Item o) {
    inv.remove(o);
    this.setSalud(this.getSalud() - o.getSalud());
    this.setEnergia(this.getEnergia() - o.getEnergia());
    this.setAtaque(this.getAtaque() - o.getAtaque() - (int)(o.getFuerza() * 1.5));
    this.setDefensa(this.getDefensa() - o.getDefensa() - o.getDex());
    this.setMagia(this.getMagia() - o.getMagia() - (int)(o.getInteligencia() * 1.5));
  }
}
