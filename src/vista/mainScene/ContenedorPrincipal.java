package vista.mainScene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;

public class ContenedorPrincipal extends BorderPane {
    public ContenedorPrincipal() {
        this.setPanel();
    }

    public void setPanel() {
    	Principal contenedor = new Principal();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(25));
        ImageView figura_01=agregarFicha("file:src/vista/assets/images/figura_03.png",90,80);
        contenedor.getChildren().addAll(figura_01);
        Image imagen = new Image("file:src/vista/assets/images/tablero.jpg",680,680,false,false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedor.setBackground(new Background(imagenDeFondo));
        contenedor.setMinHeight(680);
        contenedor.setMaxHeight(680);
        this.setCenter(contenedor);
        
        Tablero tablero = TableroFactory.crearTablero();
        Jugador jugador = new Jugador("Lucas", tablero);
        PlayerInformation box1 = new PlayerInformation(jugador,figura_01);
        box1.setPadding(new Insets(40));
        box1.setSpacing(5);
        this.setLeft(box1);
        

    }

    public ImageView agregarFicha(String direccion,int alto,int ancho) {
    	Image imagen = new Image(direccion,alto,ancho,false,false);
        ImageView imagenvista = new ImageView(imagen);
        return imagenvista;
    }
}
