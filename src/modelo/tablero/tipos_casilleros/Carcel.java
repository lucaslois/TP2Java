package modelo.tablero.tipos_casilleros;

import modelo.tablero.Casillero;
import modelo.jugador.Jugador;

public class Carcel extends Casillero {

    public void pisar(Jugador jugador) {
        jugador.encarcelar();
    }

}
