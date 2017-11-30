package vista.Casilleros.Cajas;

import javafx.scene.image.Image;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import vista.AlgoPoly;
import vista.Casilleros.Cajas.CajaVista;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

public class AvanceDinamicoVista extends CajaVista {

    public AvanceDinamicoVista(Casillero casillero) {
        super(casillero);
        this.setImage(new Image("File:src/vista/assets/images/casilleros/Tablero_12.jpg"));
    }

    @Override
    public void mostrarOpciones(Usuario usuario, PlayerInformation panelInformacion) {
        AlgoPoly algoPoly = AlgoPoly.getInstance();
        panelInformacion.setDisableComprarButton(true);
    }


}
