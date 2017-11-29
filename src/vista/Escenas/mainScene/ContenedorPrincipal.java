package vista.Escenas.mainScene;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import vista.AlgoPoly;
import vista.Usuario;

public class ContenedorPrincipal extends BorderPane {
    public ContenedorPrincipal() {
        this.setPanel();
    }

    public void setPanel() {
        AlgoPoly algoPoly = AlgoPoly.getInstance();
        Tablero tablero = algoPoly.getTablero();

        CampoJuego campoJuego = CampoJuego.getInstance(tablero);
        campoJuego.setHgap(0);
        campoJuego.setVgap(0);
        campoJuego.setAlignment(Pos.CENTER);
        campoJuego.setPadding(new Insets(25));

        campoJuego.setMinHeight(680);
        campoJuego.setMaxHeight(680);
        this.setCenter(campoJuego);

        Usuario primerUsuario = algoPoly.getUsuarioActual();
        PlayerInformation box1 = new PlayerInformation(primerUsuario);
        box1.setPadding(new Insets(40));
        box1.setSpacing(5);
        this.setLeft(box1);

        algoPoly.dibujarJugadores();
    }
}
