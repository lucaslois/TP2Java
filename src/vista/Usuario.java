package vista;

import exceptions.JugadorNoTieneDineroException;
import javafx.scene.image.Image;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import vista.Casilleros.Ficha;
import vista.Casilleros.Posicion;
import vista.Escenas.mainScene.PlayerInformation;

import javax.swing.*;

public class Usuario {
    private Jugador jugador;
    private Ficha ficha;
    private Nodo nodoPosicion;
    private Posicion pos;

    public Usuario(Jugador jugador, Ficha ficha) {
        this.jugador = jugador;
        this.ficha = ficha;
        this.pos = new Posicion();
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public Posicion getPosicion() {
        return this.pos;
    }

    public Ficha getFicha() {
        return this.ficha;
    }

    public void setPosicion(Posicion posicion) {
        this.pos = posicion;
    }

    public void preInicializarTurno() {
        Usuario usuario = this;
        Jugador jugador = usuario.getJugador();

        Nodo nodoActual = jugador.getNodoActual();
        Casillero casillero = nodoActual.getCasillero();

        if(jugador.estaPreso() && jugador.getTurnosRestantesEnCarcel() <= 2) {
            int dialogButton = JOptionPane.YES_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, this.getJugador().getNombre() + ": deseas pagar una fianza de 45,000 pesos?", "Pago de fianza", dialogButton);

            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    jugador.pagarFianzaDeCarcel();
                    JOptionPane.showMessageDialog(null, "Pagaste la fianza de la cárcel. ¡Eres libre!");
                }
                catch(JugadorNoTieneDineroException e) {
                    JOptionPane.showMessageDialog(null, "No tienes dinero para pagar al fianza.");
                }
            }
        }
    }
}
