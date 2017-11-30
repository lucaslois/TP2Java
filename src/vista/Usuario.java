package vista;

import exceptions.JugadorNoTieneDineroException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import modelo.tablero.tipos_casilleros.Comprable;
import vista.Casilleros.Ficha;
import vista.Casilleros.Posicion;
import vista.Escenas.mainScene.PlayerInformation;

import javax.swing.*;
import java.util.Optional;

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
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText(this.getJugador().getNombre() + ": deseas pagar una fianza de 45,000 pesos?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                try {
                    jugador.pagarFianzaDeCarcel();
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setHeaderText(null);
                    alert2.setContentText("Pagaste la fianza de la cárcel. ¡Eres libre!");
                    alert2.showAndWait();
                }
                catch(JugadorNoTieneDineroException e) {
                    Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                    alert3.setHeaderText(null);
                    alert3.setContentText("No tenes dinero para pagar la fianza.");
                    alert3.showAndWait();
                }
            }
        }
    }
}
