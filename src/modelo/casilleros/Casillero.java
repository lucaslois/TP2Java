package modelo.casilleros;

import modelo.jugador.Jugador;

/**
 * a los casilleros le asigne valores alfabeticos , siendo la salida A, etc
 * esto sepuede cambiar, hay que charlarlo :3
 */
public abstract class Casillero {
    public Casillero() {

    }

    abstract public void pisar(Jugador jugador);
}
