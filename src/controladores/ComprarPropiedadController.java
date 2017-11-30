package controladores;

import exceptions.JugadorNoTieneDineroException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import modelo.tablero.Nodo;
import modelo.tablero.tipos_casilleros.Comprable;
import modelo.tablero.tipos_casilleros.Edificable;
import vista.AlgoPoly;
import vista.Casilleros.Cajas.CajaVista;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

import javax.swing.*;

public class ComprarPropiedadController implements EventHandler<ActionEvent> {
    private Usuario usuario;
    private PlayerInformation panelInformacion;

    public ComprarPropiedadController(Usuario usuario, PlayerInformation panelInformacion) {
        this.usuario = usuario;
        this.panelInformacion = panelInformacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void handle(ActionEvent event) {
        AlgoPoly algoPoly = AlgoPoly.getInstance();
        Jugador jugador = this.usuario.getJugador();
        Nodo nodoActual = jugador.getNodoActual();
        CajaVista caja = algoPoly.getCasilleroVista(nodoActual);

        try {
            caja.esCompradoPor(jugador);
        }
        catch (JugadorNoTieneDineroException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("No tienes dinero para comprar la propiedad");
            alert.showAndWait();
        }

        this.panelInformacion.refresh();
        this.panelInformacion.setDisableComprarButton(true);
    }
}
