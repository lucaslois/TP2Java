package controladores;

import exceptions.JugadorNoPuedeMoverseException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.jugador.Jugador;
import modelo.jugador.estados.Dados;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import vista.AlgoPoly;
import vista.Casilleros.Posicion;
import vista.Escenas.mainScene.CampoJuego;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

import javax.swing.*;

public class BotonLanzarDados implements EventHandler<ActionEvent> {
	private ImageView figura;
	private Usuario usuario;
	private PlayerInformation panelInformacion;
	private Label resultadoTiradaLbl;
	public BotonLanzarDados(Usuario usuario, PlayerInformation panelInformacion){
		this.usuario = usuario;
		this.panelInformacion = panelInformacion;

		this.resultadoTiradaLbl = new Label();
		this.resultadoTiradaLbl.setText("Resultado de tirada: -");
		this.panelInformacion.getChildren().addAll(this.resultadoTiradaLbl);

	}

	@Override
	public void handle(ActionEvent arg0) {
		Jugador jugador = usuario.getJugador();
		AlgoPoly algoPoly = AlgoPoly.getInstance();

		int pasos = jugador.tirarDados();
		Posicion pos = usuario.getPosicion();

		try {
			jugador.avanzar(pasos);
			System.out.println("==> " + jugador.getNombre() + " caigo en: " + jugador.getNodoActual().getCasillero().getClass().getName());
			jugador.getNodoActual().getCasillero().pisar(jugador);
			System.out.println("==> " + jugador.getNombre() + " despues de pisar estoy en: " + jugador.getNodoActual().getCasillero().getClass().getName());
		}
		catch (JugadorNoPuedeMoverseException e) {
			System.out.println("El jugador " + jugador.getNombre() + ".");
		}
		Posicion nuevaPosicion = algoPoly.getCasilleroVista(jugador.getNodoActual()).getPosicion();
		usuario.setPosicion(nuevaPosicion);
		algoPoly.turnoSiguiente();
		algoPoly.dibujarJugadores();

		this.resultadoTiradaLbl.setText("Resultado de tirada: " + pasos);

		//this.panelInformacion.getChildren().add(new ImageView(new Image("file:src/vista/assets/images/dados/d6_1.png")));
	}

}
