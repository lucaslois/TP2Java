package modelo.jugador.estados;

import modelo.jugador.Jugador;
import modelo.jugador.Posicion;

public abstract class EstadoJugador {
	
	public abstract void avanzar(int cantidad, Posicion posicion);
	
	public abstract void retroceder(int cantidad, Posicion posicion);
	
	public abstract boolean puedeMoverse();

	public abstract void sumarTurno(Jugador unJugador);

	public abstract boolean estaPreso();

	public abstract int getTurnosRestantesEnCarcel();

}
