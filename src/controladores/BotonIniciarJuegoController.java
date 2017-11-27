package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    private TextField txt2;
    private TextField txt3;
    private Stage stage;

    public BotonIniciarJuegoController(TextField txt1, TextField txt2, TextField txt3, Stage stage) {
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.txt3 = txt3;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        SoundPlayer.playClick();
        String jugadores = this.txt1.getText() + this.txt2.getText() + this.txt3.getText();

        ContenedorPrincipal contenedor = new ContenedorPrincipal();
        Scene EscenaPrincipal = new Scene(contenedor, 1280, 720);
        stage.setScene(EscenaPrincipal);
    }
}
