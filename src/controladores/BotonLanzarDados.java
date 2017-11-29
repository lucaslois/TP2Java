package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.jugador.Jugador;
import modelo.jugador.estados.Dados;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import vista.Casilleros.Posicion;
import vista.Escenas.mainScene.CampoJuego;
import vista.Usuario;

public class BotonLanzarDados implements EventHandler<ActionEvent> {
	private ImageView figura;
	private Usuario usuario;
	public BotonLanzarDados(Usuario usuario){
		this.usuario = usuario;
	}

	@Override
	public void handle(ActionEvent arg0) {
		Jugador jugador = usuario.getJugador();

		Dados dados = Dados.getInstance();
		int pasos = dados.tirarDados();
		jugador.avanzar(pasos);

		Image imagen = usuario.getFicha().getImage();//new Image("File:src/vista/assets/images/ficha_reducida.png");
		CampoJuego campo = CampoJuego.getInstance(TableroFactory.crearTableroGrafico());
		Posicion pos = usuario.getPosicion();
		pos.next(pasos);
		campo.refresh();
		campo.add(new ImageView(imagen), pos.getCol(), pos.getRow());
	}

}
