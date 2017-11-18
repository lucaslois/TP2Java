package modelo.jugador;

public abstract class EstadoJugador {
	
	public abstract void avanzar(int cantidad, Posicion posicion);
	
	public abstract void retroceder(int cantidad, Posicion posicion);
	
	public abstract boolean puedeMoverse();

}
