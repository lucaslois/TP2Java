package vista.Casilleros.Cajas;

import javafx.scene.image.Image;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import vista.AlgoPoly;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

public class SalidaVista extends CajaVista {
    public SalidaVista(Casillero casillero) {
        super(casillero);
        this.setImage(new Image("File:src/vista/assets/images/casilleros/Tablero_21.jpg"));
    }

    @Override
    public void mostrarOpciones(Usuario usuario, PlayerInformation panelInformacion) {
        AlgoPoly algoPoly = AlgoPoly.getInstance();
        panelInformacion.setDisableComprarButton(true);
    }
}
