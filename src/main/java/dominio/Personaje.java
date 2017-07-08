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

  private static final double MULTIPLICADOR_MAGIA = 1.5;
  private static final double MULTIPLICADOR_ATAQUE = 1.5;
  private static final int MINIMA_ENERGIA_PARA_CASTEAR = 10;
  private static final int REGULADOR_EVASION = 1000;
  /**
   * La clase personaje es la que se encarga
   * de manejar todo lo referido a cualquier
   * tipo de personaje en si. Aqui se 
   * declaran todos los metodos comunes
   * a todas las demas subclases.
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
   * El siguiente método retorna las habilidades de raza que posee el personaje
   * actual.
   * @return habilidadesRaza.
   */
  public String[] getHabilidadesRaza() {
    return habilidadesRaza;
  }

  /**
   * El siguiente método retorna las habilidades de casta que posee el personaje
   * actual.
   * @return Devuelve las habilidades propias de una casta.
   */
  public String[] getHabilidadesCasta() {
    return casta.getHabilidadesCasta();
  }

  /**
   * El siguiente método carga la el array de niveles con las primeras dos
   * posiciones en cero y las siguientes 98 aumenta en 50 la al valor de la
   * posicion anterior.
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
   * Constructor parametrizado para la casta Guerrero.
   * @param nombre - Variable recibida que seteara el nombre del personaje.
   * @param guerrero - Variable recibida que seteara la casta del personaje.
   * @param id - Variable recibida que seteara el id del personaje.
   * @param AUMENTO_SALUD - Varaible recibida que marca el aumento de salud que tendra este personaje.
   * @param AUMENTO_ENERGIA - Variable recibida que marca el aumento de energia que tendra este personaje.
   * @param nombreDeRaza - Variable recibida tendra el nommbre de la raza del personaje.
   * @param nomHabilidadesRaza - Variable recibida que setea el nombre de las habilidades.
   */
  public Personaje(final String nombre, final Guerrero guerrero, final int id, final int AUMENTO_SALUD,
      final int AUMENTO_ENERGIA, final String nombreDeRaza, final String[] nomHabilidadesRaza) {
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
   * Constructor parametrizado para la casta Hechicero.
   * @param nombre - Variable recibida que seteara el nombre del personaje.
   * @param hechicero - Variable recibida que seteara la casta del personaje.
   * @param id - Variable recibida que seteara el id del personaje.
   * @param AUMENTO_SALUD - Varaible recibida que marca el aumento de salud que tendra este personaje.
   * @param AUMENTO_ENERGIA - Variable recibida que marca el aumento de energia que tendra este personaje.
   * @param nombreDeRaza - Variable recibida tendra el nommbre de la raza del personaje.
   * @param nomHabilidadesRaza - Variable recibida que setea el nombre de las habilidades.
   */
  public Personaje(final String nombre, final Hechicero hechicero, final int id, final int AUMENTO_SALUD,
      final int AUMENTO_ENERGIA, final String nombreDeRaza, final String[] nomHabilidadesRaza) {
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
   * Constructor parametrizado para la casta Asesino.
   * @param nombre - Variable recibida que seteara el nombre del personaje.
   * @param asesino - Variable recibida que seteara la casta del personaje.
   * @param id - Variable recibida que seteara el id del personaje.
   * @param AUMENTO_SALUD - Varaible recibida que marca el aumento de salud que tendra este personaje.
   * @param AUMENTO_ENERGIA - Variable recibida que marca el aumento de energia que tendra este personaje.
   * @param nombreDeRaza - Variable recibida tendra el nommbre de la raza del personaje.
   * @param nomHabilidadesRaza - Variable recibida que setea el nombre de las habilidades.
   
   */
  public Personaje(final String nombre, final Asesino asesino, final int id, final int AUMENTO_SALUD,
      final int AUMENTO_ENERGIA, final String nombreDeRaza, final String[] nomHabilidadesRaza) {
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
   * Constructor parametrizado en donde se pasan los states.
   * @param nombre - Variable recibida que seteara el nombre del personaje.
   * @param salud - Variable recibida que seteara la salud del personaje.
   * @param energia - Variable recibida que seteara la energia del personaje.
   * @param fuerza - Variable recibida que seteara la fuerza del personaje.
   * @param destreza - Variable recibida que seteara la destreza del personaje.
   * @param inteligencia - Variable recibida que seteara la inteligencia del personaje.
   * @param casta - Variable recibida que seteara la casta del personaje.
   * @param experiencia - Variable recibida que seteara la experiencia del personaje.
   * @param nivel - Variable recibida que seteara el nivel del personaje.
   * @param idPersonaje- Variable recibida que seteara el ID del personaje.
   * @param nombreDeRaza- Variable recibida que seteara el nombre de la raza del personaje.
   * @param nomHabilidadesRaza - Variable recibida que seteara el nombre de habilidades de Raza del personaje.
   */
  public Personaje(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
      final int inteligencia, final Casta casta, final int experiencia, final int nivel, final int idPersonaje,
      final String nombreDeRaza, final String[] nomHabilidadesRaza) {
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

  /**
   * Getter de Ataque.
   * @return ataque - Devuelve el ataque.
   */
  public int getAtaque() {
    return ataque;
  }
  
  /**
   * Getter de Nombre de Raza.
   * @return nombreRaza - Devuelve el nombre de la raza.
   */
  /** El siguiente metodo retorna el mombre de la raza del personaje */
  public String getNombreRaza() {
    return nombreRaza;
  }

  /**
   * Setter de Ataque.
   * @param ataque - devuelve el ataque a retornar.
   */
  /** El siguiente metodo establece el nivel de ataquea del personaje */
  public void setAtaque(final int ataque) {
    this.ataque = ataque;
  }

  /**
   * Getter de Magia.
   * @return magia - devuelve la magia a retornar.
   */
  /** El siguiente metodo retorna el nivel de magia del personaje */
  public int getMagia() {
    return magia;
  }

  /**
   * El siguiente metodo retorna el tipo de alianza a la que pertenece el
   * personaje.
   * @return clan - Devuelve la alianza en la que esta el personaje.
   */
  public Alianza getClan() {
    return clan;
  }

  /**
   * El siguiente metodo establece el tipo de alianza a la que pertenece el
   * personaje.
   * @param clan - Alianza que vamos a setear.
   */
  public void setClan(final Alianza clan) {
    this.clan = clan;
    clan.anadirPersonaje(this);
  }

  /**
   * Getter de Energia.
   * @return energia - Devuelve la energia a retornar.
   */
  /** El siguiente metodo retorna el nivel de energa del personaje */
  public int getEnergia() {
    return energia;
  }

  /**
   * Getter de Destreza.
   * @return destreza - Devuelve la destreza a retornar.
   */
  /** El siguiente metodo retorna el nivel de destreza del personaje */
  public int getDestreza() {
    return destreza;
  }

  /**
   * Getter de Inteligencia.
   * @return inteligencia - Devuelve la inteligencia a retornar.
   */
  /** El siguiente metodo retorna el nivel de inteligencia del personaje */
  public int getInteligencia() {
    return inteligencia;
  }

  /**
   * El siguiente metodo retorna el tipo de casta a la que pertenece el
   * personaje.
   * @return casta - Devuelve la casta a la que pertenece el personaje.
   */
  public Casta getCasta() {
    return casta;
  }

  /**
   * Getter de Experiencia.
   * @return experiencia - Devuelve la experiencia a retornar.
   */
  /** El siguiente metodo retorna el nivel de experiencia del personaje */
  public int getExperiencia() {
    return experiencia;
  }

  /**
   * Getter de idPersonaje.
   * @return idPersonaje - Devuelve el id del Personaje.
   */
  /** El siguiente metodo retorna el id del personaje */
  public int getIdPersonaje() {
    return idPersonaje;
  }

  /**
   * El siguiente metodo retorna el nivel máximo de salud que puede tener el
   * personaje.
   * @return saludTope - Retorna el tope de salud que puede tener el personaje.
   */
  public int getSaludTope() {
    return saludTope;
  }

  /**
   * El siguiente metodo retorna el nivel máximo de energia que puede tener el
   * personaje.
   * @return energiaTope - Retorna el nivel tope de energia del personaje.
   */
  public int getEnergiaTope() {
    return energiaTope;
  }

  /**
   * El siguiente metodo permite al personaje atacar a un enemigo sollo si
   * cuenta con el nivel de salud distinto de cero.
   * @param atacado - Variable que representa al usuario que va a ser atacado (Victima).
   */
  public int atacar(final Peleable atacado) {
    if (this.getSalud() == 0) {
      return 0;
    }

    if (randgen.randomDouble() <= this.casta.getProbabilidadGolpeCritico() + (this.destreza) / REGULADOR_EVASION) {
      return atacado.serAtacado(this.golpeCritico());
    } else {
      return atacado.serAtacado(this.getAtaqueTotal());
    }

    // return 0;
  }

  /**
   * El siguiente método permite al personaje dar un golpe crítico al enemigo.
   * @return Este metodo devuelve el daño por golpe critico.
   */
  public int golpeCritico() {
    return (int) (this.getAtaqueTotal() * this.getCasta().getDanoCritico());
  }

  /**
   * El siguiente define lo que tiene que realizar el personaje despues del
   * turno.
   */
  public void despuesDeTurno() {
  }

  /**
   * El siguiente metodo autoriza al personaje a poder atacar si cuenta con la
   * energia suficiente.
   * @return retorna un booleano si puede atacar o no.
   */
  public boolean puedeAtacar() {
    return energia > MINIMA_ENERGIA_PARA_CASTEAR;
  }

  /**
   * El siguiente metodo calcula los puntos de ataque siendo éste 3/2 de la
   * fuerza.
   * @return retorna el daño de ataque que va a causar.
   */
  public int calcularPuntosDeAtaque() {
    return (int) ((this.getFuerza() * MULTIPLICADOR_ATAQUE));
  }

  /**
   * El siguiente metodo calcula los puntos de defenza siendo este el mismo
   * valor de la destreza.
   * @return Retorna los puntos de defensa.
   */
  public int calcularPuntosDeDefensa() {
    return (int) (this.getDestreza());
  }

  /**
   * El siguiente metodo calcula los puntos de magia siendo éste 3/2 de la
   * inteligencia.
   * @return Retorna los puntos de magia.
   */
  public int calcularPuntosDeMagia() {
    return (int) ((this.getInteligencia()) * MULTIPLICADOR_MAGIA);
  }

  
  /** El siguiente metodo recarga el nivel de salud del personaje al máximo */
  public void restablecerSalud() {
    this.salud = this.getSaludTotal();
  }

  /**
   * El siguiente metodo recarga el nivel de energía del personaje al máximo.
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

  /**
   * El siguiente metodo revisa si el personaje esta vivo.
   * @return retorna un booleano para verificar si esta vivo o no.
   */
  /** El siguiente metodo permite saber si el personaje esta con vida */
  public boolean estaVivo() {
    return this.getSalud() > 0;
  }

  /**
   * El siguiente metodo se ocupa de aplicar un ataque a un personaje (Victima).
   * @param dano - dano que debe recibir la victima.
   * @return devuelve el danio causado o 0.
   */
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
   * Metodo que calcula la energia despues de recibir danio.
   * @param dano - dano que va a ser filtrado y recibido por la victima.
   * @return devuelve una cierta cantidad de danio a la vida o 0 si la energia o la defensa logro cubrir todo el danio.
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
   * @param salud - salud que, inicialmente, representa cuanto tiene y finalmente su salud curada.
   */
  public void serCurado(final int salud) {
    if ((this.getSalud() + salud) <= this.getSaludTotal()) {
      this.salud += salud;
    } else {
      this.salud = this.getSaludTotal();
    }
  }

  /**
   * El metodo "serEnergizado" se encarga de evaluar la cantidad de energia que el
   * personaje se va a curar sin sobrepasar el tope de energia que un personaje
   * puede tener.
   * @param energia - energia que, inicialmente, representa cuanto tiene y finalmente su energia curada.
   */
  /** El siguiente metodo permite cargar energia al personaje */
  public void serEnergizado(final int energia) {
    if ((this.energia + energia) <= this.getEnergiaTotal()) {
      this.energia += energia;
    } else {
      this.energia = this.getEnergiaTotal();
    }
  }

  /**
   * El metodo crearAlianza se encarga de crear una alianza nueva.
   * @param nombreAlianza - Nombre de la alianza que vamos a crear.
   */
  /** El siguiente metodo permite al personaje crear una alianza */
  public void crearAlianza(final String nombreAlianza) {
    this.clan = new Alianza(nombreAlianza);
    this.clan.anadirPersonaje(this);
  }

  /**
   * El siguiente metodo permite al personaje salir de la alianza en la que se
   * encuentra.
   */
  public void salirDeAlianza() {
    if (this.clan != null) {
      this.clan.eliminarPersonaje(this);
      this.clan = null;
    }
  }

  /**
   * El siguiente metodo permite al personaje agregar un nuevo miembro a su
   * alianza.
   * @return devuelve true si lo pudo agregar o false si no pudo.
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
   * metodo que controla lo sucedido cuando se sube el nivel, controlando que no
   * se exceda de 100 y que se asignen los nuevos atributos
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
   * super.nivel = pp.getNivel(); this.idPersonaje = pp.getId(); this.saludTope
   * = pp.getSaludTope(); this.energiaTope = pp.getEnergiaTope(); super.nombre =
   * pp.getNombre(); this.nombreRaza = pp.getRaza(); }
   * 
   * private void cambiaCasta(String casta2) { switch(casta2){ case "Asesino" :
   * this.casta = new Asesino(); break; case "Hechicero" : this.casta = new
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
    inventario.añadir(o);
  }

  public Inventario getInventario() {
    return inventario;
  }

  public void setInventario(Inventario inv) {
    inventario = inv;
  }

  @Override
  public String toString() {
    return "Personaje [energia=" + energia + ", ataque=" + ataque + ", magia=" + magia + ", nombreRaza=" + nombreRaza
        + ", saludTope=" + saludTope + ", energiaTope=" + energiaTope + ", destreza=" + destreza + ", inteligencia="
        + inteligencia + ", casta=" + casta + ", x=" + x + ", y=" + y + ", experiencia=" + experiencia
        + ", idPersonaje=" + idPersonaje + ", clan=" + clan + ", habilidadesRaza=" + Arrays.toString(habilidadesRaza)
        + ", randgen=" + randgen + " " + inventario + "]";
  }

}
