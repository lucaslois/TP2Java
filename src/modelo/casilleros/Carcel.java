package modelo.casilleros;

import modelo.jugador.EstadoEncarcelado;
import modelo.jugador.Jugador;

import java.util.Hashtable;

public class Carcel extends Casillero {

    private static int TURNOS_PRESO = 3;

    private Hashtable<Jugador, Integer> presos; // Clave: El jugador preso, valor: Cantidad de turnos que le quedan preso.

    public Carcel() {
        this.presos = new Hashtable<Jugador, Integer>();
    }

    public void pisar(Jugador jugador) {
    	if(this.presos.get(jugador)==null) {
    		jugador.setPuedeMoverse(new EstadoEncarcelado());
    		this.presos.put(jugador, TURNOS_PRESO);
    		return;
    	}
    	Integer turnos = this.presos.get(jugador);
        Integer nuevosTurnos = turnos - 1;
        this.presos.put(jugador, nuevosTurnos);
    }

    /**
     * Devuelve la cantidad de turnos que le quedan al jugador sin poder moverse.
     * @param jugador
     */
    public Integer getCantidadDeTurnosSinMovimiento(Jugador jugador) {
        return this.presos.get(jugador);
    }

}
