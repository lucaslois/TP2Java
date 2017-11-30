package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.tablero.tipos_casilleros.Comprable;
import modelo.tablero.tipos_casilleros.Edificable;
import modelo.tablero.tipos_casilleros.NoEdificable;
import vista.AlgoPoly;
import vista.Usuario;

public class VenderPropiedadController implements EventHandler<ActionEvent> {
    private ComboBox<Comprable> combo;
    private Usuario usuario;
    private Stage stageCartel;

    public VenderPropiedadController(Stage stageCartel, ComboBox<Comprable> combo, Usuario usuario) {
        this.combo = combo;
        this.usuario = usuario;
        this.stageCartel = stageCartel;
    }

    @Override
    public void handle(ActionEvent event) {
        Comprable comprable = this.combo.getSelectionModel().getSelectedItem();
        if (comprable == null) return;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Has vendido la propiedad " + comprable.getNombre() + " por $" + comprable.getPrecioCuandoSeVende());
        alert.showAndWait();

        try {
            this.usuario.getJugador().vender((Edificable) comprable);
        }
        catch(ClassCastException e) {
            this.usuario.getJugador().vender((NoEdificable) comprable);
        }

        AlgoPoly.getInstance().dibujarJugadores();
        this.stageCartel.close();
    }
}
