package dominio;

import java.util.LinkedList;

/**
 * Esta clase es desarrollada para saber y establecer las alianzas entre los
 * personajes.
 */
public class Alianza {

	private final String nombre;
	private final LinkedList<Personaje> aliados;

	/**
	 * Constructor de la Clase Alianza
	 * @param nombre nombre de Alianza
	 */
	public Alianza(final String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}

	/**
	 * Este medoto devuelve el nombre de nuestra alianza actual.
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este medoto devuelve el listado de los personajes aliados en la alianza
	 * actual.
	 * @return aliados.clone()
	 */
	public LinkedList<Personaje> getAliados() {
		return (LinkedList<Personaje>) aliados.clone();
	}

	/**
	 * Este medoto devuelve el nombre de la alianza actual.
	 * @return nombre
	 */
	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * Método "eliminarPersonaje", elimina a un personaje que ya no es aliado.
	 * @param pj
	 */
	public void eliminarPersonaje(final Personaje pj) {
		aliados.remove(pj);
	}

	/**
	 * Método "anadirPersonaje", anade a un personaje aliado.
	 * @param pj
	 */
	public void anadirPersonaje(final Personaje pj) {
		aliados.add(pj);
	}
}
