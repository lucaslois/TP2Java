package models;

import models.casilleros.Casillero;

import java.util.Hashtable;

public class Desplazamiento extends Casillero {
    private Hashtable<Integer, Integer> sumaObtenida; //suma de los dados, podemos charlar el nombre

    public Desplazamiento(String idCasillero) {
        super(idCasillero);
        this.sumaObtenida = new Hashtable<Integer, Integer>();
    }

    public Integer cuantoSeMueve(Jugador unJugador) {
        this.sumaObtenida.put(2, 0);
        this.sumaObtenida.put(3, 1);
        this.sumaObtenida.put(4, 2);
        this.sumaObtenida.put(5, 3);
        this.sumaObtenida.put(6, 4);
        this.sumaObtenida.put(7, (unJugador.getDinero() % 7));
        this.sumaObtenida.put(8, (unJugador.getDinero() % 8));
        this.sumaObtenida.put(9, (unJugador.getDinero() % 9));
        this.sumaObtenida.put(10, (unJugador.getDinero() % 10));
        this.sumaObtenida.put(11, (11 - unJugador.todasMisPropiedades()));
        this.sumaObtenida.put(12, (12 - unJugador.todasMisPropiedades()));
        return sumaObtenida.get(unJugador.getNumeroObtenedido());
    }

    public void pisar(Jugador unJugador) {
        int nPosicion = cuantoSeMueve(unJugador);
        unJugador.avanzar(nPosicion);
    }
}
