package modelo.jugador;

import modelo.tablero.tipos_casilleros.Carcel;

public class AccionesDelJugador {
    //estoy dudando de esto, pero lo necesito, aca tengo pensado que le diga al jugador si se puedo
    //pagar la fianza, comprar casas, terrenos,!!!!! moverse lo hace el jugador!!!!!!
    private Jugador jugador;

    public AccionesDelJugador(Jugador nuevoJugador) {
        this.jugador = nuevoJugador;
    }

    public void pagarFianza(Carcel ncarcel) {
        if(jugador.estaPreso()) {
            int turnosRestantes = jugador.getTurnosRestantesEnCarcel();
            if (turnosRestantes <= 1) {
                jugador.pagar(45000);
                jugador.desencarcelar();
            }
        }
    }
}
