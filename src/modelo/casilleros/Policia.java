package models.casilleros;

import models.Jugador;

public class Policia extends Casillero {

    public Policia(String casillero) {
        super(casillero);
    }

    @Override
    public void pisar(Jugador jugador) {
        jugador.encarcelar();
    }
}
