package modelo.tablero.tipos_casilleros;

import modelo.jugador.Jugador;
import modelo.tablero.Casillero;

public class ImpuestoAlLujo extends Casillero {


    @Override
    public void pisar(Jugador jugador) {
        double dinero = jugador.getDinero();
        jugador.pagar(dinero*0.1);

    }
}
