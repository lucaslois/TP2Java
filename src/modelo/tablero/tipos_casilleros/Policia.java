package modelo.tablero.tipos_casilleros;

import modelo.tablero.Casillero;
import modelo.jugador.Jugador;

public class Policia extends Casillero {

    public Policia() {
    }

    @Override
    public void pisar(Jugador jugador) {
        jugador.enviarALaCarcel();
    }
}

