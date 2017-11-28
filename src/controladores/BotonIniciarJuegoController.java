package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.tablero.Tablero;
import vista.SoundPlayer;
import vista.mainScene.ContenedorPrincipal;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.net.URI;
import java.net.URL;

public class BotonIniciarJuegoController implements EventHandler<ActionEvent> {
    private TextField txt1;
    private Stage stage;
    private int cantidadDeJugadores;
    private Tablero unicoTablero;

    public BotonIniciarJuegoController(TextField txt1,Stage stage) {
        this.txt1 = txt1;
        this.stage = stage;
        this.cantidadDeJugadores=0;
    }

    @Override
    public void handle(ActionEvent event) {
        SoundPlayer.playClick();
        System.out.println(this.txt1.getText());
        cantidadDeJugadores=cantidadDeJugadores+1;
        this.txt1.clear();//limpia el textfield una vez que toma el dato
        if (cantidadDeJugadores>=3) {
	        ContenedorPrincipal contenedor = new ContenedorPrincipal();
	        Scene EscenaPrincipal = new Scene(contenedor, 1280, 720);
	        stage.setScene(EscenaPrincipal);
        }
    }
}
