package vista.mainScene;

import javafx.scene.layout.BorderPane;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;

public class ContenedorPrincipal extends BorderPane {
    public ContenedorPrincipal() {
        Tablero tablero = TableroFactory.crearTablero();
        Jugador jugador = new Jugador("Lucas", tablero);

        PlayerInformation box1 = new PlayerInformation(jugador);

        this.setLeft(box1);
    }

}
