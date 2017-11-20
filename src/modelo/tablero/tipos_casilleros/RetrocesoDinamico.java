package modelo.tablero.tipos_casilleros;

import modelo.tablero.Casillero;
import modelo.jugador.Jugador;

import java.util.Hashtable;

public class RetrocesoDinamico extends Casillero {
    private Hashtable<Integer, Integer> sumaObtenida;

    public RetrocesoDinamico() {
        this.sumaObtenida = new Hashtable<Integer, Integer>();
    }

    public Integer cuantoSeMueve(Jugador unJugador) {
        int dados = unJugador.getNumeroObtenedido();

        for (int i = 2; i <= 6; i++) sumaObtenida.put(i, dados - unJugador.getCantidadTotalPropiedades());

        for (int i = 7; i <= 10; i++) sumaObtenida.put(i, unJugador.getDinero() % dados);

        for (int i = 11; i <= 12; i++) sumaObtenida.put(i, dados - 2);

        return sumaObtenida.get(dados);
    }

    public void pisar(Jugador unJugador) {
        int nPosicion = cuantoSeMueve(unJugador);
        if (nPosicion < 0) nPosicion = 0;
        unJugador.retroceder(nPosicion);
    }
}
