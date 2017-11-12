package models.casilleros;

import models.Jugador;

/**
 * a los casilleros le asigne valores alfabeticos , siendo la salida A, etc
 * esto sepuede cambiar, hay que charlarlo :3
 */
public abstract class Casillero {
    private String idCasillero;

    public Casillero(String casillero) {
        this.idCasillero = casillero;
    }

    abstract public void pisar(Jugador jugador);
}
