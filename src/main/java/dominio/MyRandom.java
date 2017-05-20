package dominio;

/**
 *  La clase MyRandom sirve para generar, con nuestras propias reglas, numeros aleatorios
*/
public class MyRandom extends RandomNumberGenerator{
  /**
   *  randomDouble genera un Double aleatorio entre 0 y 1
  */
	public double randomDouble() {
		return Math.random();
	}
	
	/**
   *  randomInt recibe un maximo y genera un Entero aleatorio entre 0 y un maximo
  */
	@Override
	public int randomInt(int max) {
		 return (int) Math.round(Math.random()*max);
	}
}
