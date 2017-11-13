package modelo.casilleros;

import modelo.jugador.Jugador;

import java.util.Hashtable;

public class Quini6 extends Casillero {
    private Hashtable<Jugador, Integer> ganadores;
    private Hashtable<Integer, Integer> premios;

    public Quini6() {
        this.ganadores = new Hashtable<Jugador, Integer>();
        this.premios = new Hashtable<Integer, Integer>();
        this.premios.put(1, 50000);
        this.premios.put(2, 30000);

    }

    /**
     * Pisar de Quini6 entrega dinero dependiendo de la cantidad de veces que el jugador ha caído en esta casilla.
     *
     * @param unJugador
     */
    public void pisar(Jugador unJugador) {
        Integer cantidadDeCaidas = this.ganadores.get(unJugador);

        if (cantidadDeCaidas == null) {
            ganadores.put(unJugador, 0);
            cantidadDeCaidas = 0;
        }
        cantidadDeCaidas += 1;
        ganadores.put(unJugador, cantidadDeCaidas);
        Integer monto = this.premios.get(cantidadDeCaidas);
        if (monto == null) return;
        unJugador.pagar(monto);
    }


}


