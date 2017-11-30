package vista.Casilleros.Cajas;

import javafx.scene.image.Image;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import modelo.tablero.tipos_casilleros.Comprable;
import vista.AlgoPoly;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

import javax.swing.*;

public class CarcelVista extends CajaVista {


    public CarcelVista(Casillero casillero) {
        super(casillero);
        this.setImage(new Image("File:src/vista/assets/images/casilleros/Tablero_16.jpg"));
    }

    public void pisar(Jugador unJugador) {
        JOptionPane.showMessageDialog(null, "Caiste en la cárcel. Estarás preso por 3 turnos");
        this.casillero.pisar(unJugador);
    }

    @Override
    public void mostrarOpciones(Usuario usuario, PlayerInformation panelInformacion) {
        panelInformacion.setDisableComprarButton(true);
    }
}
