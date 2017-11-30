package controladores;

import exceptions.JugadorNoPuedeMoverseException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import modelo.jugador.Jugador;
import modelo.jugador.Dados;
import vista.AlgoPoly;
import vista.Casilleros.Cajas.CajaVista;
import vista.Casilleros.Posicion;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;


public class LanzarDadosController implements EventHandler<ActionEvent> {
	private ImageView figura;
	private Usuario usuario;
	private PlayerInformation panelInformacion;

	public LanzarDadosController(Usuario usuario, PlayerInformation panelInformacion){
		this.usuario = usuario;
		this.panelInformacion = panelInformacion;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public void handle(ActionEvent arg0) {
		Jugador jugador = usuario.getJugador();
		AlgoPoly algoPoly = AlgoPoly.getInstance();

		int pasos = jugador.tirarDados();
		Dados dados = Dados.getInstance();
		Posicion pos = usuario.getPosicion();
		this.panelInformacion.setDados(dados.getResultadoDado1(), dados.getResultadoDado2());
		try {
			jugador.avanzar(pasos);
			System.out.println("==> " + jugador.getNombre() + " caigo en: " + jugador.getNodoActual().getCasillero().getClass().getName());
			algoPoly.getCasilleroVista(jugador.getNodoActual()).pisar(jugador);
			System.out.println("==> " + jugador.getNombre() + " despues de pisar estoy en: " + jugador.getNodoActual().getCasillero().getClass().getName());
		}
		catch (JugadorNoPuedeMoverseException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("No puedes moverte porque estás preso. Te quedan " + jugador.getTurnosRestantesEnCarcel() + " turnos en la cárcel");
			alert.showAndWait();
		}

		Posicion nuevaPosicion = algoPoly.getCasilleroVista(jugador.getNodoActual()).getPosicion();
		usuario.setPosicion(nuevaPosicion);

		algoPoly.dibujarJugadores();
		this.panelInformacion.setDisableLanzarDadosButton(true);
		this.panelInformacion.setDisablePasarTurnoButton(false);
		this.panelInformacion.setDisableEdificarButton(true);
		CajaVista caja = AlgoPoly.getInstance().getCasilleroVista(jugador.getNodoActual());
		caja.mostrarOpciones(usuario, panelInformacion);
	}

}
