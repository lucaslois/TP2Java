package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.tablero.Tablero;
import vista.AlgoPoly;
import vista.Casilleros.Ficha;
import vista.SoundPlayer;
import vista.Escenas.mainScene.ContenedorPrincipal;

import java.util.ArrayList;

public class BotonIniciarJuegoController implements EventHandler<ActionEvent> {
    private TextField txt1;
    private Stage stage;

    public BotonIniciarJuegoController(TextField txt1, Stage stage) {
        this.txt1 = txt1;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        SoundPlayer.playClick();

        AlgoPoly algoPoly = AlgoPoly.getInstance();
        String nombreJugador = this.txt1.getText();
        Ficha ficha = new Ficha("File: src/vista/assets/images/ficha_01.jpg");
        algoPoly.agregarUsuario(nombreJugador, ficha);
        this.txt1.clear();

        if (algoPoly.getCantidadJugadores() >= 3) {
            ContenedorPrincipal contenedor = new ContenedorPrincipal();
            Scene EscenaPrincipal = new Scene(contenedor, 1280, 720);
            stage.setScene(EscenaPrincipal);
        }
    }
}
