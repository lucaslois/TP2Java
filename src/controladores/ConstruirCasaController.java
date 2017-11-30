package controladores;

import exceptions.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.tablero.tipos_casilleros.Comprable;
import modelo.tablero.tipos_casilleros.Edificable;
import vista.Usuario;

public class ConstruirCasaController implements EventHandler<ActionEvent> {
    private ComboBox<Edificable> combo;
    private Usuario usuario;
    private Stage stageCartel;

    public ConstruirCasaController(Stage stageCartel, ComboBox<Edificable> combo, Usuario usuario) {
        this.combo = combo;
        this.usuario = usuario;
        this.stageCartel = stageCartel;
    }

    @Override
    public void handle(ActionEvent event) {
        Edificable edificable = this.combo.getSelectionModel().getSelectedItem();
        if(edificable == null) return;
        try {
            edificable.agregarCasa(usuario.getJugador());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Has agregado una casa en " + edificable.getNombre());
            alert.showAndWait();
        }
        catch (JugadorNoTieneDineroException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("No tienes dinero para construir casas");
            alert.showAndWait();
        }
        catch (LimiteDeCasasException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("No puedes construir más casas aquí.");
            alert.showAndWait();
        }
        catch (JugadorNoEsDuenioDeAmbasPropiedades e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("No puedes construir una casa aquí porque necesitas el otro barrio de " + edificable.getNombre());
            alert.showAndWait();
        }
        this.stageCartel.close();
    }
}
