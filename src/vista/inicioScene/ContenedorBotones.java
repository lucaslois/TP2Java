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
        this.setStyle("-fx-width: 500; -fx-text-align: center; -fx-background-color: rgba(0, 0, 0, 0.7);");

        TextField nombreJugador1Txt = new TextField(); // Text1
        TextField nombreJugador2Txt = new TextField(); // Text2
        TextField nombreJugador3Txt = new TextField(); // Text3

        Label label1 = new Label();
        label1.setText("¡Bienvenido!");
        label1.setTextFill(Color.web("#FFFFFF"));
        label1.setStyle("-fx-font-size: 16;");

        Label label2 = new Label();
        label2.setText("Por favor, ingrese el nombre de los Jugadores y empiece a jugar");
        label2.setTextFill(Color.web("#FFFFFF"));
        label2.setStyle("-fx-font-size: 13;");

        Button iniciarButton = new Button();
        iniciarButton.setText("Empezar a jugar");
        //iniciarButton.setStyle("-fx-background-color: #a3d1ad; -fx-color: #FFFFFF");

        BotonIniciarJuegoController botonController = new BotonIniciarJuegoController(nombreJugador1Txt, nombreJugador2Txt, nombreJugador3Txt, stage);
        iniciarButton.setOnAction(botonController);

        this.getChildren().addAll(label1, label2, nombreJugador1Txt, nombreJugador2Txt, nombreJugador3Txt, iniciarButton);
    }
}
