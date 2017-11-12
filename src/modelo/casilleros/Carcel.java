package modelo.casilleros;

import modelo.Jugador;

import java.util.Hashtable;

public class Carcel extends Casillero {

    private static int TURNOS_PRESO = 3;

    private Hashtable<Jugador, Integer> presos; // Clave: El jugador preso, valor: Cantidad de turnos que le quedan preso.

    public Carcel(String idcasilla) {
        super(idcasilla);
        this.presos = new Hashtable<Jugador, Integer>();
    }

    public void jugadorCayoEnLaCarcel(Jugador jugador) {
        //cuando la policia te manda a la carcel, se ejecuta este metodo, el 3 que aparece seria un "contador"
        //de turnos que tenes que estar sin hacer nada, se ira descontando al pasar los turnos!
        jugador.setPuedeMoverse(false);
        this.presos.put(jugador, TURNOS_PRESO);
    }

    public void pisar(Jugador jugador) {
        Integer turnos = this.presos.get(jugador);
        Integer nuevosTurnos = turnos - 1;
        this.presos.put(jugador, nuevosTurnos);
    }

    public Integer cantidadDeTurnosSinMovimiento(Jugador jugador) {
        //necesito la cantidad de turnos que le quedan al jugador en carcel
        //
        return this.presos.get(jugador);
    }

}