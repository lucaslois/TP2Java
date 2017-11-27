package vista.mainScene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;

public class ContenedorPrincipal extends BorderPane {
    public ContenedorPrincipal() {
        Tablero tablero = TableroFactory.crearTablero();
        Jugador jugador = new Jugador("Lucas", tablero);

        this.setIzquierda();
        this.setCentro();
    }

    public void setIzquierda() {
        Tablero tablero = TableroFactory.crearTablero();
        Jugador jugador = new Jugador("Lucas", tablero);
        PlayerInformation box1 = new PlayerInformation(jugador);
        box1.setPadding(new Insets(20));
        box1.setSpacing(5);

        this.setLeft(box1);

    }

    public void setCentro() {
        Principal contenedor = new Principal();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(20);
        contenedor.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/assets/images/background_main.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedor.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedor);
    }

}
