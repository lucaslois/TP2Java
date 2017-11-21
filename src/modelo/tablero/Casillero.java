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

    public Casillero() {
    }

    abstract public void pisar(Jugador jugador);
}
