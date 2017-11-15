package modelo.casilleros;

import modelo.jugador.Jugador;

public class Policia extends Casillero {

    public Policia() {

    }

    @Override
    public void pisar(Jugador jugador) {
        jugador.encarcelar();
    }
}

