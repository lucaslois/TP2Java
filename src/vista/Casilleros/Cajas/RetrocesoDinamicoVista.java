package vista.Casilleros.Cajas;

import javafx.scene.image.Image;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import modelo.tablero.tipos_casilleros.Comprable;
import vista.AlgoPoly;
import vista.Casilleros.Cajas.CajaVista;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

public class RetrocesoDinamicoVista extends CajaVista {

    public RetrocesoDinamicoVista(Casillero casillero) {
        super(casillero);
        this.setImage(new Image("File:src/vista/assets/images/casilleros/Tablero_13.jpg"));
    }

    @Override
    public void mostrarOpciones(Usuario usuario, PlayerInformation panelInformacion) {
        panelInformacion.setDisableComprarButton(true);
    }
}
