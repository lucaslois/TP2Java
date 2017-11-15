package modelo.casilleros;

import modelo.jugador.Jugador;

public interface Comprable {
	
	void setPropietario(Jugador unJugador);
	
	Jugador getPropietario();
	
	int getPrecio();

}
