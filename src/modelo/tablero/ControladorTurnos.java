package modelo.tablero;

import modelo.jugador.Dados;
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


    public void cambiarTurno() {
        // TODO: Implementar. Se debe tener en cuenta cuando el usuario saca doble numero en dados y no debe interferir con las tiradas para los servicios (AySA, Subte, ETC)

        Jugador jugadorActual = this.jugadores.get(posActual);

        if (jugadorActual.tiroDoble() && this.jugadorAnt != jugadores.get(posActual)) {//segunda condicion es para que no pueda jugar 3 veces
            this.jugadorAnt = this.getJugadorActual();
        }
        else {
            this.posActual++;
            if (posActual >= this.jugadores.size()) posActual = 0;
        }
         Jugador jugador = jugadores.get(posActual);
        if(jugador.perdio()){
            jugador.venderTodasLasPropiedades();
            //this.jugadores.remove(jugador);
            cambiarTurno();
        }

         jugador.inicializarTurno();
    }

    public Jugador getJugadorActual() { return jugadores.get(posActual); }
}
