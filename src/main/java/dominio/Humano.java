package dominio;

/**
 * La clase "Humano" es un tipo de Personaje (por ende, hereda de esta misma).
 * Aqui se describen los metodos y atributos propios de esta clase.
 */
public class Humano extends Personaje {

	private static final long serialVersionUID = 1L;
	private static final int AUMENTO_SALUD_TOPE_HUMANO = 5;
	private static final int ENERGIA_SALUD_TOPE_HUMANO = 5;
	private static final int COSTE_DE_ENERGIA_HABILIDADES = 10;
	protected static final String[] habilidades = new String[] {"Incentivar", "Golpe Fatal" };

	/**
	 * Constructor parametrizado para la casta Guerrero.
	 * @param nombre
	 * @param guerrero
	 * @param id
	 */
	public Humano(final String nombre, final Guerrero guerrero, final int id) {
		super(nombre, guerrero, id, AUMENTO_SALUD_TOPE_HUMANO, ENERGIA_SALUD_TOPE_HUMANO, "Humano", habilidades);
	}

	/**
	 * Constructor parametrizado la casta Hechicero.
	 * @param nombre
	 * @param hechicero
	 * @param id
	 */
	public Humano(final String nombre, final Hechicero hechicero, final int id) {
		super(nombre, hechicero, id, AUMENTO_SALUD_TOPE_HUMANO, ENERGIA_SALUD_TOPE_HUMANO, "Humano", habilidades);
	}

	/**
	 * Constructor parametrizado para la casta Asesino.
	 * @param nombre
	 * @param asesino
	 * @param id
	 */
	public Humano(final String nombre, final Asesino asesino, final int id) {
		super(nombre, asesino, id, AUMENTO_SALUD_TOPE_HUMANO, ENERGIA_SALUD_TOPE_HUMANO, "Humano", habilidades);
	}

	/**
	 * Constructor parametrizado en donde se pasan los states de la raza.
	 * @param nombre
	 * @param salud
	 * @param energia
	 * @param fuerza
	 * @param destreza
	 * @param inteligencia
	 * @param casta
	 * @param experiencia
	 * @param nivel
	 * @param idPersonaje
	 */
	public Humano(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje, "Humano",
				habilidades);
	}

	/**
	 * El metodo "habilidadRaza1" correspondiente a la habilidad "Incentivar" se
	 * ocupa de aumentar el ataque del objetivo en la cantidad de magia del
	 * @return boolean
	 * @param atacado
	 * personaje.
	 */
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			this.disminuirEnergia(COSTE_DE_ENERGIA_HABILIDADES);
			atacado.setAtaque(((Personaje) atacado).getAtaque() + this.getMagiaTotal());
			return true;
		}
		return false;
	}

	/**
	 * El metodo "habilidadRaza2" correspondiente a la habilidad "Golpe Fatal"
	 * se ocupa de aplicar la mitad de la vida actual de la victima como daño a
	 * la misma.
	 * @return boolean
	 * @param atacado
	 */
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > COSTE_DE_ENERGIA_HABILIDADES) {
			if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
				this.disminuirEnergia(this.getEnergia() / 2);
				return true;
			}
		}
		this.disminuirEnergia(COSTE_DE_ENERGIA_HABILIDADES);
		return false;
	}
}
