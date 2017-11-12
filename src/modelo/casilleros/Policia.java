package modelo.casilleros;

import modelo.Jugador;

public class Policia extends Casillero {

    public Policia(String casillero) {
        super(casillero);
    }

    @Override
    public void pisar(Jugador jugador) {
        jugador.encarcelar();
    }
}
