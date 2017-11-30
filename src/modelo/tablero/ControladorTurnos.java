package modelo.tablero;

import modelo.jugador.Jugador;

import java.util.ArrayList;

public class ControladorTurnos {

    private ArrayList<Jugador> jugadores;
    private int posActual;
    private Jugador jugadorAnt;

    public ControladorTurnos() {
        jugadores = new ArrayList<>();
        posActual = 0;
        jugadorAnt = null;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void agregarTodosLosJugadores(ArrayList<Jugador> nuevosJugadores) {
        this.jugadores = nuevosJugadores;
    }

    public Jugador getJugadorSiguiente() {
        /*Dados dados = Dados.getInstance();

        if (dados.esDoble() && this.jugadorAnt != jugadores.get(posActual)) {//segunda condicion es para que no pueda jugar 3 veces
            this.jugadorAnt = this.getJugadorActual();
            return jugadores.get(posActual);
        }*/
        this.jugadorAnt = jugadores.get(posActual);
        posActual++;
        if (posActual >= this.jugadores.size()) posActual = 0;

        return jugadores.get(posActual);
    }

    public void cambiarTurno() {
        // TODO: Implementar. Se debe tener en cuenta cuando el usuario saca doble numero en dados y no debe interferir con las tiradas para los servicios (AySA, Subte, ETC)
        //Dados dados = Dados.getInstance();
        this.posActual++;
        if (posActual >= this.jugadores.size()) posActual = 0;
        Jugador jugador = jugadores.get(posActual);
        jugador.inicializarTurno();
    }

    public Jugador getJugadorActual() {
        /*Jugador jugadorActual = jugadores.get(posActual);
        if (!jugadorActual.puedeMoverse()) {
            jugadorActual.inicializarTurno();
            jugadorActual = this.getJugadorSiguiente();
        }*/

        return jugadores.get(posActual);
    }
}
