package AlgoPoly;

public class Jugador {
	private String nombre;
	private int dinero;
	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.dinero = 0;
	}
	
	public int obtenerDinero() {
		return this.dinero;
	}
	
	public void cobrar(int monto) {
		this.dinero += monto;
	}

}
