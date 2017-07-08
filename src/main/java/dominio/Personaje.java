package dominio;

import java.io.Serializable;
import java.util.Arrays;

import mensajeria.PaqueteAtacar;

/**
 * La clase "Personaje" es la que se encargara de administrar los personajes de
 * cada usuario, administrando todos sus atributos y las acciones que estos
 * mismos realizan.
 */
public abstract class Personaje extends Unidad implements Peleable, Serializable {

	/**
	 * 
	 */
	private Inventario inventario;
	private static final long serialVersionUID = 1L;
	private static final int TAMANO_ARRAY_NIVELES = 101;
	private static final int SALTO_EXPERIENCIA_ENTRE_NIVELES = 50;
	private static final int FUERZA_BASE = 10;
	private static final int DESTREZA_BASE = 10;
	private static final int INTELIGENCIA_BASE = 10;
	private static final int BONUS_POR_CASTA = 5;
	private static final int TOPE_SALUD = 100;
	private static final int TOPE_ENERGIA = 100;

	protected int energia;
	protected int ataque;
	protected int magia;
	protected String nombreRaza;
	protected int saludTope;
	protected int energiaTope;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int x;
	protected int y;

	protected int experiencia;

	protected int idPersonaje;

	protected Alianza clan = null;
	public static int[] tablaDeNiveles;

	protected String[] habilidadesRaza;

	private RandomNumberGenerator randgen = new MyRandom();

	/**
	 * El siguiente método retorna las habilidades de raza que posee el
	 * personaje actual
	 */
	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	/**
	 * El siguiente método retorna las habilidades de casta que posee el
	 * personaje actual
	 */
	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	/**
	 * El siguiente método carga la el array de niveles con las primeras dos
	 * posiciones en cero y las siguientes 98 aumenta en 50 la al valor de la
	 * posicion anterior
	 */
	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[TAMANO_ARRAY_NIVELES];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < TAMANO_ARRAY_NIVELES; i++) {
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + SALTO_EXPERIENCIA_ENTRE_NIVELES;
		}
	}

	/**
	 * Constructor parametrizado para la casta Guerrero
	 */
	public Personaje(final String nombre, final Guerrero guerrero, final int id, final int AUMENTO_SALUD,
			final int AUMENTO_ENERGIA, final String nombreDeRaza, final String nomHabilidadesRaza[]) {
		super(nombre);
		inventario = new Inventario();
		this.casta = guerrero;
		this.idPersonaje = id;
		experiencia = 0;
		this.nivel = 1;
		super.fuerza += FUERZA_BASE + BONUS_POR_CASTA;
		inteligencia = INTELIGENCIA_BASE;
		destreza = DESTREZA_BASE;
		x = 0;
		y = 0;
		saludTope = TOPE_SALUD + AUMENTO_SALUD;
		this.salud = saludTope;
		energiaTope = TOPE_ENERGIA + AUMENTO_ENERGIA;
		energia = energiaTope;
		nombreRaza = nombreDeRaza;
		ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();
		habilidadesRaza = nomHabilidadesRaza;
	}

	/**
	 * Constructor parametrizado para la casta Hechicero
	 */
	public Personaje(final String nombre, final Hechicero hechicero, final int id, final int AUMENTO_SALUD,
			final int AUMENTO_ENERGIA, final String nombreDeRaza, final String nomHabilidadesRaza[]) {
		super(nombre);
		inventario = new Inventario();
		this.casta = hechicero;
		this.idPersonaje = id;
		experiencia = 0;
		this.nivel = 1;
		super.fuerza += FUERZA_BASE;
		inteligencia = INTELIGENCIA_BASE;
		destreza = DESTREZA_BASE;
		inteligencia += BONUS_POR_CASTA;
		x = 0;
		y = 0;
		saludTope = TOPE_SALUD + AUMENTO_SALUD;
		this.salud = saludTope;
		energiaTope = TOPE_ENERGIA + AUMENTO_ENERGIA;
		energia = energiaTope;
		nombreRaza = nombreDeRaza;
		ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();
		habilidadesRaza = nomHabilidadesRaza;
	}

	/**
	 * Constructor parametrizado para la casta Asesino
	 */
	public Personaje(final String nombre, final Asesino asesino, final int id, final int AUMENTO_SALUD,
			final int AUMENTO_ENERGIA, final String nombreDeRaza, final String nomHabilidadesRaza[]) {
		super(nombre);
		inventario = new Inventario();
		this.casta = asesino;
		this.idPersonaje = id;
		experiencia = 0;
		this.nivel = 1;
		super.fuerza += FUERZA_BASE;
		inteligencia = INTELIGENCIA_BASE;
		destreza = DESTREZA_BASE;
		destreza += BONUS_POR_CASTA;
		x = 0;
		y = 0;
		saludTope = TOPE_SALUD + AUMENTO_SALUD;
		this.salud = saludTope;
		energiaTope = TOPE_ENERGIA + AUMENTO_ENERGIA;
		energia = energiaTope;
		nombreRaza = nombreDeRaza;
		ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();
		habilidadesRaza = nomHabilidadesRaza;
	}

	/**
	 * Constructor parametrizado en donde se pasan los states
	 */
	public Personaje(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
			final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje,
			final String nombreDeRaza, final String nomHabilidadesRaza[]) {
		super(salud, nombre, fuerza, nivel);
		inventario = new Inventario();
		this.energia = energia;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;
		this.experiencia = experiencia;
		this.saludTope = this.getSalud();
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
		nombreRaza = nombreDeRaza;
		habilidadesRaza = nomHabilidadesRaza;
	}

	public int getAtaque() {
		return ataque;
	}

	/** El siguiente metodo retorna el mombre de la raza del personaje */
	public String getNombreRaza() {
		return nombreRaza;
	}

	/** El siguiente metodo establece el nivel de ataquea del personaje */
	public void setAtaque(final int ataque) {
		this.ataque = ataque;
	}

	/** El siguiente metodo retorna el nivel de magia del personaje */
	public int getMagia() {
		return magia;
	}

	/**
	 * El siguiente metodo retorna el tipo de alianza a la que pertenece el
	 * personaje
	 */
	public Alianza getClan() {
		return clan;
	}

	/**
	 * El siguiente metodo establece el tipo de alianza a la que pertenece el
	 * personaje
	 */
	public void setClan(final Alianza clan) {
		this.clan = clan;
		clan.anadirPersonaje(this);
	}

	/** El siguiente metodo retorna el nivel de energa del personaje */
	public int getEnergia() {
		return energia;
	}

	/** El siguiente metodo retorna el nivel de destreza del personaje */
	public int getDestreza() {
		return destreza;
	}

	/** El siguiente metodo retorna el nivel de inteligencia del personaje */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * El siguiente metodo retorna el tipo de casta a la que pertenece el
	 * personaje
	 */
	public Casta getCasta() {
		return casta;
	}

	/** El siguiente metodo retorna el nivel de experiencia del personaje */
	public int getExperiencia() {
		return experiencia;
	}

	/** El siguiente metodo retorna el id del personaje */
	public int getIdPersonaje() {
		return idPersonaje;
	}

	/**
	 * El siguiente metodo retorna el nivel máximo de salud que puede tener el
	 * personaje
	 */
	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * El siguiente metodo retorna el nivel máximo de energia que puede tener el
	 * personaje
	 */
	public int getEnergiaTope() {
		return energiaTope;
	}

	/**
	 * El siguiente metodo permite al personaje atacar a un enemigo sollo si
	 * cuenta con el nivel de salud distinto de cero
	 */
	public int atacar(final Peleable atacado) {
		if (this.getSalud() == 0) {
			return 0;
		}

		if (randgen.randomDouble() <= this.casta.getProbabilidadGolpeCritico() + (this.destreza) / 1000) {
			return atacado.serAtacado(this.golpe_critico());
		} else {
			return atacado.serAtacado(this.getAtaqueTotal());
		}

		// return 0;
	}

	/**
	 * El siguiente método permite al personaje dar un golpe crítico al enemigo
	 */
	public int golpe_critico() {
		return (int) (this.getAtaqueTotal() * this.getCasta().getDanoCritico());
	}

	/**
	 * El siguiente define lo que tiene que realizar el personaje despues del
	 * turno
	 */
	public void despuesDeTurno() {
	}

	/**
	 * El siguiente metodo autoriza al personaje a poder atacar si cuenta con la
	 * energia suficiente
	 */
	public boolean puedeAtacar() {
		return energia > 10;
	}

	/**
	 * El siguiente metodo calcula los puntos de ataque siendo éste 3/2 de la
	 * fuerza
	 */
	public int calcularPuntosDeAtaque() {
		return (int) ((this.getFuerza() * 1.5));
	}

	/**
	 * El siguiente metodo calcula los puntos de defenza siendo este el mismo
	 * valor de la destreza
	 */
	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	/**
	 * El siguiente metodo calcula los puntos de magia siendo éste 3/2 de la
	 * inteligencia
	 */
	public int calcularPuntosDeMagia() {
		return (int) ((this.getInteligencia()) * 1.5);
	}

	/** El siguiente metodo recarga el nivel de salud del personaje al máximo */
	public void restablecerSalud() {
		this.salud = this.getSaludTotal();
	}

	/**
	 * El siguiente metodo recarga el nivel de energía del personaje al máximo
	 */
	public void restablecerEnergia() {
		this.energia = this.getEnergiaTotal();
	}

	/** El siguiente asigna al ataque, defensa y magia los valores calculados */
	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

	/** El siguiente metodo permite saber si el personaje esta con vida */
	public boolean estaVivo() {
		return this.getSalud() > 0;
	}

	/** El siguiente metodo permite al enemigo atacar al personaje */
	public int serAtacado(int dano) {
		if (randgen.randomDouble() >= this.getCasta().getProbabilidadEvitarDano()) {
			dano -= this.getDefensaTotal();
			if (dano > 0) {
				if (this.getSalud() <= dano) {
					dano = this.getSalud();
					this.salud = 0;
				} else {
					this.salud -= dano;
				}
				return dano;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * El metodo "serRobadoSalud" se encarga de evaluar la cantidad de vida que,
	 * en base al dano recibido, el atacante va a robar.
	 */
	public int serRobadoSalud(int dano) {
		dano -= this.getDefensaTotal();
		if (dano <= 0) {
			return 0;
		}
		if ((this.getSalud() - dano) >= 0) {
			this.salud -= dano;
		} else {
			dano = this.getSalud();
			this.salud = 0;
		}
		return dano;
	}

	/**
	 * metodo que calcula la energia despues de recibir daño
	 */
	public int serDesernegizado(int dano) {
		dano -= this.getDefensaTotal();
		if (dano <= 0) {
			return 0;
		}
		if ((energia - dano) >= 0) {
			energia -= dano;
		} else {
			dano = energia;
			energia = 0;
		}
		return dano;
	}

	/**
	 * El metodo "serCurado" se encarga de evaluar la cantidad de vida que el
	 * personaje se va a curar sin sobrepasar el tope de salud que un personaje
	 * puede tener.
	 */
	public void serCurado(final int salud) {
		if ((this.getSalud() + salud) <= this.getSaludTotal()) {
			this.salud += salud;
		} else {
			this.salud = this.getSaludTotal();
		}
	}

	/** El siguiente metodo permite cargar energia al personaje */
	public void serEnergizado(final int energia) {
		if ((this.energia + energia) <= this.getEnergiaTotal()) {
			this.energia += energia;
		} else {
			this.energia = this.getEnergiaTotal();
		}
	}

	/** El siguiente metodo permite al personaje crear una alianza */
	public void crearAlianza(final String nombreAlianza) {
		this.clan = new Alianza(nombreAlianza);
		this.clan.anadirPersonaje(this);
	}

	/**
	 * El siguiente metodo permite al personaje salir de la alianza en la que se
	 * encuentra
	 */
	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	/**
	 * El siguiente metodo permite al personaje agregar un nuevo miembro a su
	 * alianza
	 */
	public boolean aliar(final Personaje nuevoAliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.anadirPersonaje(this);
		}

		if (nuevoAliado.clan == null) {
			nuevoAliado.clan = this.clan;
			this.clan.anadirPersonaje(nuevoAliado);
			return true;
		} else {
			return false;
		}
	}

	/** metodo que actualiza los states sin que ests superen el tope */
	public void AsignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
		if (this.getFuerza() + fuerza <= 200) {
			super.fuerza += fuerza;
		}
		if (this.destreza + destreza <= 200) {
			this.destreza += destreza;
		}
		if (this.inteligencia + inteligencia <= 200) {
			this.inteligencia += inteligencia;
		}
		this.modificarAtributos();
	}

	/**
	 * metodo que controla lo sucedido cuando se sube el nivel, controlando que
	 * no se exceda de 100 y que se asignen los nuevos atributos
	 */
	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.getNivel() == 100) {
			return;
		}
		while (this.getNivel() != 100
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.getNivel() + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.getNivel() + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	/** metodo que asigna la experiencia segun la tabla de niveles */
	public boolean ganarExperiencia(final int exp) {
		this.experiencia += exp;
		if (experiencia >= Personaje.tablaDeNiveles[this.getNivel() + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	/** metodo que otorga la experiencia */
	public int otorgarExp() {
		return this.getNivel() * 40;
	}

	/** sobrecarga de clone para clonar un Personaje */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/** calcula la distancia entre dos personajes */
	public double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	/** habilidad 1 que se sobrecarga segun la casta */
	public boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	/** habilidad 2 que se sobrecarga segun la casta */
	public boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	/** habilidad 3 que se sobrecarga segun la casta */
	public boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	/** habilidad 1 que se sobrecarga segun la raza */
	public abstract boolean habilidadRaza1(final Peleable atacado);

	/** habilidad 2 que se sobrecarga segun la raza */
	public abstract boolean habilidadRaza2(final Peleable atacado);

	public void setRandgen(RandomNumberGenerator randgen) {
		this.randgen = randgen;
	}

	protected void disminuirEnergia(int costeDeEnergiaHabilidades) {
		this.energia -= costeDeEnergiaHabilidades;
	}

	protected void aumentarDefensa(int defensa) {
		super.defensa += defensa;
	}

	protected void aumentarAtaque(int ataque) {
		this.ataque += ataque;

	}
	/*
	 * public void actualizarEstado(PaquetePersonajeDom pp){ super.fuerza =
	 * pp.getFuerza(); this.destreza = pp.getDestreza(); this.inteligencia =
	 * pp.getInteligencia(); this.modificarAtributos();
	 * cambiaCasta(pp.getCasta()); this.experiencia = pp.getExperiencia();
	 * super.nivel = pp.getNivel(); this.idPersonaje = pp.getId();
	 * this.saludTope = pp.getSaludTope(); this.energiaTope =
	 * pp.getEnergiaTope(); super.nombre = pp.getNombre(); this.nombreRaza =
	 * pp.getRaza(); }
	 * 
	 * private void cambiaCasta(String casta2) { switch(casta2){ case "Asesino"
	 * : this.casta = new Asesino(); break; case "Hechicero" : this.casta = new
	 * Hechicero(); break; case "Guerrero" : this.casta = new Guerrero(); break;
	 * default : this.casta = null; } }
	 */

	public void actualizarPorAtaque(PaqueteAtacar pa) {
		if (this.idPersonaje == pa.getIdEnemigo()) {
			super.salud = pa.getNuevaSaludEnemigo();
			this.energia = pa.getNuevaEnergiaEnemigo();
		}
		if (this.idPersonaje == pa.getId()) {
			super.salud = pa.getNuevaSaludPersonaje();
			this.energia = pa.getNuevaEnergiaPersonaje();
		}
	}

	public int getDefensaTotal() {
		return super.defensa + inventario.getDefensa();
	}

	public int getAtaqueTotal() {
		return ataque + inventario.getAtaque();
	}

	public int getMagiaTotal() {
		return magia + inventario.getMagia();
	}

	public int getSaludTotal() {
		return saludTope + inventario.getSalud();
	}

	public int getEnergiaTotal() {
		return energiaTope + inventario.getEnergia();
	}

	public Item otorgarItem(int n) {
		return new Item(n);
	}

	public void recibirObjeto(Item o) {
		inventario.aniadir(o);
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inv) {
		inventario = inv;
	}

	@Override
	public String toString() {
		return "Personaje [energia=" + energia + ", ataque=" + ataque + ", magia=" + magia + ", nombreRaza="
				+ nombreRaza + ", saludTope=" + saludTope + ", energiaTope=" + energiaTope + ", destreza=" + destreza
				+ ", inteligencia=" + inteligencia + ", casta=" + casta + ", x=" + x + ", y=" + y + ", experiencia="
				+ experiencia + ", idPersonaje=" + idPersonaje + ", clan=" + clan + ", habilidadesRaza="
				+ Arrays.toString(habilidadesRaza) + ", randgen=" + randgen + " " + inventario + "]";
	}

}
