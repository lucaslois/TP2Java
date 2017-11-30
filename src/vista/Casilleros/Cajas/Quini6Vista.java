package vista.Casilleros.Cajas;

import javafx.scene.image.Image;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import modelo.tablero.tipos_casilleros.Comprable;
import modelo.tablero.tipos_casilleros.Quini6;
import vista.AlgoPoly;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

import javax.swing.*;

public class Quini6Vista extends CajaVista {

    public Quini6Vista(Casillero casillero) {
        super(casillero);
        this.setImage(new Image("File:src/vista/assets/images/casilleros/Tablero_20.jpg"));
    }


    @Override
    public void pisar(Jugador unJugador) {
        this.casillero.pisar(unJugador);
        if(((Quini6) this.casillero).puedeSeguirCobrando(unJugador))
            JOptionPane.showMessageDialog(null, "¡Ganaste el Quini 6!");
    }

    @Override
    public void mostrarOpciones(Usuario usuario, PlayerInformation panelInformacion) {
        panelInformacion.setDisableComprarButton(true);
    }
}
