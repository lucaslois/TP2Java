package AlgoPoly;

import java.util.Hashtable;

public class Carcel {
	
	private Hashtable<Jugador,Integer> presos; //la idea es guardar los jugadores que esten en la carcel y los turnos que lleven ahi
	
	public Carcel() {
		this.presos = new Hashtable<Jugador,Integer>();
	}
	
	public void pisar(Jugador jugador) {
		this.presos.put(jugador,1);	
	}


}
