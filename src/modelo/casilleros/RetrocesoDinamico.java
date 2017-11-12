package modelo.casilleros;

import modelo.Jugador;

import java.util.Hashtable;

public class RetrocesoDinamico extends Casillero {
    private Hashtable<Integer, Integer> sumaObtenida;

    public RetrocesoDinamico(String idCasillero) {
        super(idCasillero);
        this.sumaObtenida = new Hashtable<Integer, Integer>();
    }

    public Integer cuantoSeMueve(Jugador unJugador) {
        this.sumaObtenida.put(2, unJugador.getNumeroObtenedido() - unJugador.getCantidadTotalPropiedades());
        this.sumaObtenida.put(3, unJugador.getNumeroObtenedido() - unJugador.getCantidadTotalPropiedades());
        this.sumaObtenida.put(4, unJugador.getNumeroObtenedido() - unJugador.getCantidadTotalPropiedades());
        this.sumaObtenida.put(5, unJugador.getNumeroObtenedido() - unJugador.getCantidadTotalPropiedades());
        this.sumaObtenida.put(6, unJugador.getNumeroObtenedido() - unJugador.getCantidadTotalPropiedades());
        this.sumaObtenida.put(7, (unJugador.getDinero() % 7));
        this.sumaObtenida.put(8, (unJugador.getDinero() % 8));
        this.sumaObtenida.put(9, (unJugador.getDinero() % 9));
        this.sumaObtenida.put(10, (unJugador.getDinero() % 10));
        this.sumaObtenida.put(11, (unJugador.getNumeroObtenedido() - 2));
        this.sumaObtenida.put(12, (unJugador.getNumeroObtenedido() - 2));
        return sumaObtenida.get(unJugador.getNumeroObtenedido());
    }

    public void pisar(Jugador unJugador) {
        int nPosicion = cuantoSeMueve(unJugador);
        if(nPosicion < 0) nPosicion = 0;
        unJugador.retroceder(nPosicion);
    }
}
