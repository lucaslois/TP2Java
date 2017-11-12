package modelo.casilleros;

import modelo.Jugador;

public interface Comprable {
	
	void setPropietario(Jugador unJugador);
	
	Jugador getPropietario();
	
	int getPrecio();

}
