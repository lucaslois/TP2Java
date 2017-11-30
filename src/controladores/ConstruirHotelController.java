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

public class ConstruirHotelController implements EventHandler<ActionEvent> {
    private ComboBox<Edificable> combo;
    private Usuario usuario;
    private Stage stageCartel;

    public ConstruirHotelController(Stage stageCartel, ComboBox<Edificable> combo, Usuario usuario) {
        this.combo = combo;
        this.usuario = usuario;
        this.stageCartel = stageCartel;
    }

    @Override
    public void handle(ActionEvent event) {
        Edificable edificable = this.combo.getSelectionModel().getSelectedItem();
        if(edificable == null) return;
        try {
            edificable.agregarHotel(usuario.getJugador());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Has agregado un hotel en " + edificable.getNombre());
            alert.showAndWait();
        }
        catch (JugadorNoTieneDineroException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("No tienes dinero para construir un hotel");
            alert.showAndWait();
        }
        catch (JugadorNoEsDuenioDeAmbasPropiedades e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("No puedes construir un hotel aquí porque necesitas el otro barrio de " + edificable.getNombre());
            alert.showAndWait();
        }
        catch (CantidadInsuficienteDeCasasException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("No puedes todavía construir un hotel aquí.");
            alert.showAndWait();
        }
        catch (PropiedadNoPuedeConstruirHotelException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("No puedes hotel en esta propiedad " + edificable.getNombre());
            alert.showAndWait();
        }
        this.stageCartel.close();
    }
}
