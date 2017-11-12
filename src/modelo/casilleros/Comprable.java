package models.casilleros;

import models.Jugador;

public interface Comprable {
	
	void setPropietario(Jugador unJugador);
	
	Jugador getPropietario();
	
	int getPrecio();

}
