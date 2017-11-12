package models;

import java.util.Hashtable;

public class Carcel extends Casillero{
	
	private Hashtable<Jugador,Integer> presos; //la idea es guardar los jugadores que esten en la carcel y los turnos que lleven ahi
	
	public Carcel(String idcasilla) {
		super(idcasilla);
		this.presos = new Hashtable<Jugador,Integer>();
	}
	public void jugadorCayoEnLaCarcel(Jugador jugador) {
		//cuando la policia te manda a la carcel, se ejecuta este metodo, el 3 que aparece seria un "contador"
		//de turnos que tenes que estar sin hacer nada, se ira descontando al pasar los turnos!
		jugador.setMovimiento(false);
		this.presos.put(jugador,3);
	}
	
	public void pisar(Jugador jugador) {
		Integer turnos= this.presos.get(jugador);
		Integer nuevosTurnos=turnos-1;
		this.presos.put(jugador, nuevosTurnos);
	}
	public Integer cantidadDeTurnosSinMovimiento(Jugador jugador){
		//necesito la cantidad de turnos que le quedan al jugador en carcel
		//
		return this.presos.get(jugador);
	}

}
