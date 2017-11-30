package controladores;

import controladores.PasarTurnoController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.jugador.Jugador;
import modelo.tablero.tipos_casilleros.Comprable;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MostrarCartelVenderController implements EventHandler<ActionEvent> {
    private Usuario usuario;
    private PlayerInformation panelInformacion;


    public MostrarCartelVenderController(Usuario usuario, PlayerInformation panelInformacion) {
        this.usuario = usuario;
        this.panelInformacion = panelInformacion;
    }

    @Override
    public void handle(ActionEvent event) {
        Jugador jugador = this.usuario.getJugador();

        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Vender propiedades");
        stage.setResizable(false);
        stage.setMaximized(false);
        VBox root = new VBox();
        Scene scene = new Scene(root, 300, 150, Color.LIGHTBLUE);
        stage.initOwner(scene.getWindow());

        Label label = new Label();
        label.setText("Seleccione la propiedad que desea vender");

        ObservableList<Comprable> data = FXCollections.observableArrayList();
        for(Comprable comprable : jugador.getListaComprables()) {
            data.add(comprable);
        }
        ComboBox<Comprable> combobox = new ComboBox<>(data);
        combobox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Comprable>() {

            @Override
            public void changed(ObservableValue<? extends Comprable> arg0, Comprable arg1, Comprable arg2) {
                if (arg2 != null) {
                    System.out.println("Seleccioné el: " + arg2.getNombre());
                }
            }
        });


        Button buttonVender = new Button();
        buttonVender.setText("Vender propiedad");
        VenderPropiedadController venderPropiedadController = new VenderPropiedadController(stage, combobox, this.usuario);
        buttonVender.setOnAction(venderPropiedadController);

        root.setPadding(new Insets(20));
        root.setSpacing(5);
        root.getChildren().addAll(label, combobox, buttonVender);
        stage.setScene(scene);
        stage.show();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
