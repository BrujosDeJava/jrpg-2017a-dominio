package dominio;

import java.io.Serializable;

/**
 * La clase "Casta" es la que se encargara de administrar las los atributos
 * basicos en todas las castas (como ser la "probablidadGolpeCritico") del juego
 * asi como tambien los metodos que comparten.
 */
public abstract class Casta implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final double PROBABILIDAD_GOLPE_CRITICO_INICIAL = 0.2;
	private static final double EVASION_INICIAL = 0.2;
	private static final double GOLPE_CRITICO_INICIAL = 1.5;

	private double probabilidadGolpeCritico;
	private double probabilidadEvitarDano;
	private double danoCritico;
	private String nombreCasta;
	private String[] habilidadesCasta;

	/**
	 * Constructor por defecto.
	 */
	public Casta() {
		this.probabilidadGolpeCritico = PROBABILIDAD_GOLPE_CRITICO_INICIAL;
		this.probabilidadEvitarDano = EVASION_INICIAL;
		this.danoCritico = GOLPE_CRITICO_INICIAL;
	}

	/**
	 * Constructor parametrizado.
	 * @param probCrit
	 * @param evasion
	 * @param danoCrit
	 */
	public Casta(final double probCrit, final double evasion, final double danoCrit) {
		// La variable danoCrit fue modificada. Antes era dano_crit.
		this.probabilidadGolpeCritico = probCrit;
		this.probabilidadEvitarDano = evasion;
		this.danoCritico = danoCrit;
	}

	/**
	 * Método booleano que se sobreescribe en cada casta diferente, que indica
	 * si se cumplen las condiciones para iniciar la habilidad1.
	 * @return boolean
	 * @param caster
	 * @param atacado
	 */
	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	/**
	 * Método booleano que se sobreescribe en cada casta diferente, que indica
	 * si se cumplen las condiciones para iniciar la habilidad2.
	 * @return boolean
	 * @param caster
	 * @param atacado
	 */
	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	/**
	 * Método booleano que se sobreescribe en cada casta diferente, que indica
	 * si se cumplen las condiciones para iniciar la habilidad3.
	 * @return boolean
	 * @param caster
	 * @param atacado
	 */
	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	/**
	 * Este metodo devuelve el nombre de la casta.
	 * @return nombreCasta
	 */
	public String getNombreCasta() {
		return this.nombreCasta;
	}

	/**
	 * Este metodo establece el nombre de la casta.
	 * @param nombreCasta
	 */
	public void setNombreCasta(final String nombreCasta) {
		this.nombreCasta = nombreCasta;
	}

	/**
	 * Este metodo devuelve la descripción de las habilidades que posee la
	 * casta.
	 * @return habilidadesCasta
	 */
	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	/**
	 * Este metodo devuelve la probabilidad que tiene la casta actual de golpe
	 * critico.
	 * @return probabilidadGolpeCritico
	 */
	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	/**
	 * Este metodo establece la probabilidad de golpe critico.
	 * @param probabilidadGolpeCritico
	 */
	public void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	/**
	 * Este metodo devuelve la probabilidad de evitar dano de la casta actual.
	 * @return probabilidadEvitarDano
	 */
	public double getProbabilidadEvitarDano() {
		return probabilidadEvitarDano;
	}

	/**
	 * Este metodo establece la probabilidad de evitar dano de la casta actual.
	 * @param probabilidadEvitarDano
	 */
	public void setProbabilidadEvitarDano(double probabilidadEvitarDano) {
		this.probabilidadEvitarDano = probabilidadEvitarDano;
	}

	/**
	 * Este metodo devuelve el valor del dano critico de la casta actual.
	 * @return danoCritico
	 */
	public double getDanoCritico() {
		return danoCritico;
	}

	/**
	 * Este metodo establece la probabilidad de dano critico de la casta actual.
	 * @param danoCritico
	 */
	public void setDanoCritico(final double danoCritico) {
		this.danoCritico = danoCritico;
	}

	/**
	 * Este metodo establece las habilidades de la casta actual.
	 * @param habilidadesCasta
	 */
	public void setHabilidadesCasta(final String[] habilidadesCasta) {
		this.habilidadesCasta = habilidadesCasta;
	}
}
