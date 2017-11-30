package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import vista.AlgoPoly;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

public class PasarTurnoController implements EventHandler<ActionEvent> {
    private Usuario usuario;
    private PlayerInformation panelInformacion;


    public PasarTurnoController(Usuario usuario, PlayerInformation panelInformacion) {
        this.usuario = usuario;
        this.panelInformacion = panelInformacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void handle(ActionEvent event) {
        AlgoPoly algoPoly = AlgoPoly.getInstance();

        this.panelInformacion.setDisableLanzarDadosButton(false);
        this.panelInformacion.setDisableComprarButton(true);
        this.panelInformacion.setDisablePasarTurnoButton(true);

        algoPoly.turnoSiguiente();
        algoPoly.dibujarJugadores();
    }
}
