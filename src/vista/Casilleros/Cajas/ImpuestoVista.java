package vista.Casilleros.Cajas;

import javafx.scene.image.Image;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import modelo.tablero.tipos_casilleros.Comprable;
import vista.AlgoPoly;
import vista.Casilleros.Cajas.CajaVista;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

import javax.swing.*;

public class ImpuestoVista extends CajaVista {
    public ImpuestoVista(Casillero casillero) {
        super(casillero);
        this.setImage(new Image("File:src/vista/assets/images/casilleros/Tablero_01.jpg"));
    }

    @Override
    public void pisar(Jugador unJugador) {
        this.casillero.pisar(unJugador);
        JOptionPane.showMessageDialog(null, "¡Debes pagar un impuesto del 10% de tu dinero!");
    }

    @Override
    public void mostrarOpciones(Usuario usuario, PlayerInformation panelInformacion) {
        panelInformacion.setDisableComprarButton(true);
    }
}
