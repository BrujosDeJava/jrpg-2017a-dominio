package dominio;

/**
 *  La clase MyRandom sirve para generar, con nuestras propias reglas, numeros aleatorios
*/
public class MyRandom extends RandomNumberGenerator{
  /**
   *  randomDouble genera un Double aleatorio entre 0 y 1
  */
	public static double randomDouble() {
		return Math.random();
	}
	
	/**
   *  randomInt genera un Entero aleatorio entre 0 y 100
  */
	public static int randomInt() {
		 return (int) Math.round(Math.random()*100);
	}
}
