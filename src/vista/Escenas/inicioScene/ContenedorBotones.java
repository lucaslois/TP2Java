package vista.Escenas.inicioScene;

import controladores.BotonFiguraConJugador;
import controladores.BotonIniciarJuegoController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ContenedorBotones extends VBox {
    public ContenedorBotones(Stage stage) {
        this.setStyle("-fx-width: 500; -fx-text-align: center; -fx-background-color: rgba(0, 0, 0, 0.7);");
       
        TextField nombreJugadorTxt = new TextField(); // Text1
        Label label1 = new Label();
        label1.setText("Bienvenido");
        label1.setTextFill(Color.web("#FFFFFF"));
        label1.setStyle("-fx-font-size: 16;");

        Label label2 = new Label();
        label2.setText("Ingrese el nombre");
        label2.setTextFill(Color.web("#FFFFFF"));
        label2.setStyle("-fx-font-size: 13;");
        
        Label label3 = new Label();
        label3.setText("Seleccione la ficha");
        label3.setTextFill(Color.web("#FFFFFF"));
        label3.setStyle("-fx-font-size: 13;");
        

        Button figura_01Boton = new Button();
        figura_01Boton.setStyle("-fx-background-color: transparent;");
        figura_01Boton.setGraphic(ingresarImagenEnBoton("file:src/vista/assets/images/figura_01.png",90,80));
        Button figura_02Boton = new Button();
        figura_02Boton.setStyle("-fx-background-color: transparent;");
        figura_02Boton.setGraphic(ingresarImagenEnBoton("file:src/vista/assets/images/figura_02.png",90,80));
        Button figura_03Boton = new Button();
        figura_03Boton.setStyle("-fx-background-color: transparent;");
        figura_03Boton.setGraphic(ingresarImagenEnBoton("file:src/vista/assets/images/figura_03.png",90,80));
        
        BotonFiguraConJugador accionDeBotonFigura1= new BotonFiguraConJugador(nombreJugadorTxt, stage,"file:src/vista/assets/images/figura_01.png",figura_01Boton);
        figura_01Boton.setOnAction(accionDeBotonFigura1);
        BotonFiguraConJugador accionDeBotonFigura2= new BotonFiguraConJugador(nombreJugadorTxt, stage,"file:src/vista/assets/images/figura_02.png",figura_02Boton);
        figura_02Boton.setOnAction(accionDeBotonFigura2);
        BotonFiguraConJugador accionDeBotonFigura3= new BotonFiguraConJugador(nombreJugadorTxt, stage,"file:src/vista/assets/images/figura_03.png",figura_03Boton);
        figura_03Boton.setOnAction(accionDeBotonFigura3);
        
        HBox seleccionDeFiguras =new HBox();
        seleccionDeFiguras.setAlignment(Pos.CENTER);
        seleccionDeFiguras.getChildren().addAll(figura_01Boton,figura_02Boton,figura_03Boton);
        
        
        this.getChildren().addAll(label1, label2, nombreJugadorTxt,label3,seleccionDeFiguras);
    }
    public ImageView ingresarImagenEnBoton(String direccionImage,int alto,int ancho) {
        Image fondo= new Image(direccionImage);
        ImageView fondo_01 = new ImageView(fondo);
        fondo_01.setFitWidth(alto);
        fondo_01.setFitHeight(ancho);
        return fondo_01;
    }
}
