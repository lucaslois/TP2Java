package vista.mainScene;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.jugador.Jugador;
import modelo.tablero.ControladorTurnos;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;

public class ContenedorPrincipal extends BorderPane {
    public ContenedorPrincipal(ArrayList<String> nombreJugadores) {
        this.setPanel(nombreJugadores);
    }

    public void setPanel(ArrayList<String> nomJugadores) {
    	Tablero tablero = TableroFactory.crearTablero();
    	ControladorTurnos turnos=new ControladorTurnos();
    	turnos.agregarTodosLosJugadores(setDeJugadores(nomJugadores,tablero));
    	Principal contenedor = new Principal();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(25));
        ImageView figura_01=agregarFicha("file:src/vista/assets/images/figura_01.png",90,80);
        ImageView figura_02=agregarFicha("file:src/vista/assets/images/figura_02.png",90,80);
        ImageView figura_03=agregarFicha("file:src/vista/assets/images/figura_03.png",90,80);
        contenedor.getChildren().addAll(figura_01,figura_02,figura_03);
        Image imagen = new Image("file:src/vista/assets/images/tablero.jpg",900,680,false,false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedor.setBackground(new Background(imagenDeFondo));
        contenedor.setMinHeight(680);
        contenedor.setMaxHeight(680);
        this.setCenter(contenedor);
        
        
        Jugador primerJugador = turnos.getJugadorActual();
        PlayerInformation box1 = new PlayerInformation(primerJugador,figura_01);
        box1.setPadding(new Insets(40));
        box1.setSpacing(5);
        this.setLeft(box1);
        

    }

    public ImageView agregarFicha(String direccion,int alto,int ancho) {
    	Image imagen = new Image(direccion,alto,ancho,false,false);
        ImageView imagenvista = new ImageView(imagen);
        return imagenvista;
    }
    public ArrayList<Jugador> setDeJugadores(ArrayList<String> nombreJugadores,Tablero tablero){
    	ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
    	Jugador player_01=new Jugador(nombreJugadores.get(0),tablero);
    	jugadores.add(player_01);
    	Jugador player_02=new Jugador(nombreJugadores.get(1),tablero);
    	jugadores.add(player_02);
    	Jugador player_03=new Jugador(nombreJugadores.get(2),tablero);
    	jugadores.add(player_03);
    	return jugadores;
    }
}
