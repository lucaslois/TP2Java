package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.Escenas.inicioScene.ContenedorInicio;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("AlgoPoly - TP2Java");
        ContenedorInicio contenedor = new ContenedorInicio(stage);
        Scene inicioScene = new Scene(contenedor, 1280, 720);

        stage.setScene(inicioScene);
        stage.show();
    }
}