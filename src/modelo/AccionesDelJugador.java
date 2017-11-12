package models;

import models.casilleros.Carcel;

public class AccionesDelJugador {
    //estoy dudando de esto, pero lo necesito, aca tengo pensado que le diga al jugador si se puedo
    //cobrar la fianza, comprar casas, terrenos,!!!!! moverse lo hace el jugador!!!!!!
    private Jugador jugador;

    public AccionesDelJugador(Jugador nuevoJugador) {
        this.jugador = nuevoJugador;
    }

    public void pagarFianza(Carcel ncarcel) {
        Integer turnosRestantes = ncarcel.cantidadDeTurnosSinMovimiento(jugador);
        if ((turnosRestantes == 1 || turnosRestantes == 0) && (jugador.getDinero() >= 45000)) {
            jugador.cobrar(45000);
            jugador.setMovimiento(true);
        }
    }
}
