package modelo.tablero.tipos_casilleros;

import modelo.tablero.Casillero;
import modelo.jugador.Jugador;

public class Carcel extends Casillero {

    private static int PRECIO_FIANZA = 45000;

    public static int getPrecioFianza() {
        return PRECIO_FIANZA;
    }

    public void pisar(Jugador jugador) {
        jugador.encarcelar();
    }

}
