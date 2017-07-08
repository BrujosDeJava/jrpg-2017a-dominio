package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * La Clase Inventario es la que se encarga de
 * almacenar los items recolectados en nuestro juego
 */
public class Inventario extends Item {
	private List<Item> mochila;
	private Item cabeza;
	private Item manos;
	private Item pies;
	private Item cuerpo;
	private Item accesorio;
	private Item arma;

	/**
	 * Constructor por defecto de la clase Inventario
	 */
	public Inventario() {
		mochila = new ArrayList<Item>();
		cabeza = new Item(-1);
		manos = new Item(-1);
		pies = new Item(-1);
		cuerpo = new Item(-1);
		accesorio = new Item(-1);
		arma = new Item(-1);
	}

	/**
	 * Falta JavaDoc.
	 */
	public void aniadir(final Item o) {
		int type = o.getTipo();
		switch (type) {
		case 1:
			if (cabeza.getId() != -1) {
				aniadirMochila(o);
				return;
			} else{
				cabeza = o;				
			}
			break;
		case 2:
			if (manos.getId() != -1) {
				aniadirMochila(o);
				return;
			} else{
				manos = o;				
			}
			break;
		case 3:
			if (pies.getId() != -1) {
				aniadirMochila(o);
				return;
			} else{
				pies = o;				
			}
			break;
		case 4:
			if (cuerpo.getId() != -1) {
				aniadirMochila(o);
				return;
			} else{
				cuerpo = o;				
			}
			break;
		case 5:
			if (accesorio.getId() != -1) {
				aniadirMochila(o);
				return;
			} else{
				accesorio = o;				
			}
			break;
		case 6:
			if (arma.getId() != -1) {
				aniadirMochila(o);
				return;
			} else{
				arma = o;				
			}
			break;
		default:
			return;
		}
		this.setSalud(o.getSalud() + this.getSalud());
		this.setEnergia(o.getEnergia() + this.getEnergia());
		this.setAtaque(o.getAtaque() + this.getAtaque());
		this.setDefensa(o.getDefensa() + this.getDefensa());
		this.setMagia(o.getMagia() + this.getMagia());
	}

	private void aniadirMochila(Item o) {
		if (mochila.size() == 10)
			return;
		mochila.add(o);
	}

	public Item getCabeza() {
		return cabeza;
	}

	public Item getManos() {
		return manos;
	}

	public Item getPies() {
		return pies;
	}

	public Item getCuerpo() {
		return cuerpo;
	}

	public Item getAccesorio() {
		return accesorio;
	}

	public Item getArma() {
		return arma;
	}

	/**
	 * Falta JavaDoc.
	 */
	public void eliminar(Item o) {
		mochila.remove(o);
		this.setSalud(this.getSalud() - o.getSalud());
		this.setEnergia(this.getEnergia() - o.getEnergia());
		this.setAtaque(this.getAtaque() - o.getAtaque());
		this.setDefensa(this.getDefensa() - o.getDefensa());
		this.setMagia(this.getMagia() - o.getMagia());
	}

	public List<Item> getMochila() {
		return mochila;
	}

	public void setMochila(List<Item> mochila) {
		this.mochila = mochila;
	}

	public void setCabeza(Item cabeza) {
		this.cabeza = cabeza;
	}

	public void setManos(Item manos) {
		this.manos = manos;
	}

	public void setPies(Item pies) {
		this.pies = pies;
	}

	public void setCuerpo(Item cuerpo) {
		this.cuerpo = cuerpo;
	}

	public void setAccesorio(Item accesorio) {
		this.accesorio = accesorio;
	}

	public void setArma(Item arma) {
		this.arma = arma;
	}

	@Override
	public String toString() {
		return "Inventario [mochila=" + mochila + ", cabeza=" + cabeza + ", manos=" + manos + ", pies=" + pies
				+ ", cuerpo=" + cuerpo + ", accesorio=" + accesorio + ", arma=" + arma + "]";
	}

	public void desequipar(Item aDesequipar) {
		boolean desequipado = false;
		int i = 0;
		while (!desequipado) {
			if (aDesequipar.getId() == mochila.get(i).getId()) {
				desequipado = true;
				mochila.remove(i);
			}
			i++;
		}
	}

}
