package vista.inicioScene;

import controladores.BotonIniciarJuegoController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ContenedorBotones extends VBox {
    public ContenedorBotones(Stage stage) {
        this.setStyle("-fx-width: 500; -fx-text-align: center; -fx-background-color: rgba(0, 0, 0, 0.3);");

        TextField nombreJugador1Txt = new TextField(); // Text1
        TextField nombreJugador2Txt = new TextField(); // Text2
        TextField nombreJugador3Txt = new TextField(); // Text3

        Label label = new Label();
        label.setText("Bienvenido, por favor, ingrese el nombre de los Jugadores y empiece a jugar");
        label.setTextFill(Color.web("#FFFFFF"));

        Button iniciarButton = new Button();
        iniciarButton.setText("Empezar a jugar!");
        iniciarButton.setStyle("-fx-background-color: #a3d1ad; -fx-color: #FFFFFF");

        BotonIniciarJuegoController botonController = new BotonIniciarJuegoController(nombreJugador1Txt, nombreJugador2Txt, nombreJugador3Txt, stage);
        iniciarButton.setOnAction(botonController);

        this.getChildren().addAll(label, nombreJugador1Txt, nombreJugador2Txt, nombreJugador3Txt, iniciarButton);
    }
}
