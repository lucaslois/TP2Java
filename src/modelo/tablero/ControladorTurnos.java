package modelo.tablero;

import modelo.jugador.Jugador;
import modelo.jugador.estados.Dados;

import java.util.ArrayList;

public class ControladorTurnos {

    private ArrayList<Jugador> jugadores;
    private int posActual;
    private Jugador jugadorAnt;

    public ControladorTurnos(){
        jugadores = new ArrayList<Jugador>();
        posActual=0;
        jugadorAnt = null;
    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public Jugador getJugadorSiguiente(){
        Dados dados = Dados.getInstance();

        if(dados.esDoble() && this.jugadorAnt != jugadores.get(posActual)){//segunda condicion es para que no pueda jugar 3 veces
            this.jugadorAnt=this.getJugadorActual();
            return jugadores.get(posActual) ;
        }
        this.jugadorAnt=this.getJugadorActual();
        posActual++;
        if(posActual>3)posActual=0;
        return jugadores.get(posActual);
    }

    public Jugador getJugadorActual() {
        return jugadores.get(posActual);
    }
}
