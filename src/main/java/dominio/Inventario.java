package dominio;

import java.util.LinkedList;
import java.util.List;

public class Inventario extends Item{
	private List<Item> inv;
	
	public Inventario(){
		inv = new LinkedList<Item>();
	}
	
	public void añadir(Item o){
		this.setSalud(o.getSalud()+this.getSalud());
		this.setEnergia(o.getEnergia()+this.getEnergia());
		this.setAtaque(o.getAtaque()+this.getAtaque());
		this.setDefensa(o.getDefensa()+this.getDefensa());
		this.setFuerza(o.getFuerza()+this.getFuerza());
		this.setDex(o.getDex()+this.getDex());
		this.setInteligencia(o.getInteligencia()+this.getInteligencia());
	}
	
	public void eliminar(Item o){
		this.setSalud(this.getSalud()-o.getSalud());
		this.setEnergia(this.getEnergia()-o.getEnergia());
		this.setAtaque(this.getAtaque()-o.getAtaque());
		this.setDefensa(this.getDefensa()-o.getDefensa());
		this.setFuerza(this.getFuerza()-o.getFuerza());
		this.setDex(this.getDex()+o.getDex());
		this.setInteligencia(this.getInteligencia()+o.getInteligencia());
	}
}
