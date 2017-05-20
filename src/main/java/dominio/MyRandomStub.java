package dominio;

public class MyRandomStub extends RandomNumberGenerator{
	private int vali;
	private double vald;
	public MyRandomStub(int val){
		vali = val;
	}
	public MyRandomStub(double val){
		vald = val;
	}
	/**
	 * Devuelve valor 0
	 * 
	 */
	public double randomDouble() {
		return vald;
	}
	/**
	 * Devuelve valor 0
	 * 
	 */
	public int randomInt(int n) {
		 return vali;
	}
}
