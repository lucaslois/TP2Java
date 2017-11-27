package vista.mainScene;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.jugador.Jugador;

public class PlayerInformation extends VBox {
    private Jugador jugador;

    public PlayerInformation(Jugador unJugador) {
        this.jugador = unJugador;

        Label labelNombre = new Label();
        labelNombre.setText(this.jugador.getNombre());
    }
}
