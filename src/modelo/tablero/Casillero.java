package modelo.tablero;

import exceptions.JugadorNoEstaEnCasilleroException;
import modelo.jugador.Jugador;
import modelo.jugador.Posicion;

import java.util.ArrayList;

/**
 * a los tablero le asigne valores alfabeticos , siendo la salida A, etc
 * esto sepuede cambiar, hay que charlarlo :3
 */
public abstract class Casillero {
    private Posicion pos;
    private ArrayList<Jugador> jugadores;

    public Casillero() {
        this.pos = new Posicion();
        this.jugadores = new ArrayList<>();
    }

    public Posicion getPosicion() {
        return this.pos;
    }

    public void agregarJugador(Jugador unJugador) {
        this.jugadores.add(unJugador);
    }

    public void quitarJugador(Jugador unJugador) {
        if(!jugadores.contains(unJugador))
            throw new JugadorNoEstaEnCasilleroException();
        jugadores.remove(unJugador);
    }

    public void setPosicion(Posicion pos)
    {
        this.pos = pos;
    }

    abstract public void pisar(Jugador jugador);
}
