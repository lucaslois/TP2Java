package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vista.AlgoPoly;
import vista.Casilleros.Ficha;
import vista.Escenas.mainScene.ContenedorPrincipal;

public class BotonFiguraConJugador implements EventHandler<ActionEvent>{
	private TextField txt1;
    private Stage stage;
    private String direccion;
    private Button bton;
    public BotonFiguraConJugador(TextField txt1, Stage stage,String direccionFigura,Button yo){
    	this.txt1 = txt1;
        this.stage = stage;
        this.direccion=direccionFigura;
        this.bton=yo;
    	
    }
	@Override
	public void handle(ActionEvent arg0) {
		AlgoPoly algoPoly = AlgoPoly.getInstance();
        String nombreJugador = this.txt1.getText();
        Ficha ficha = new Ficha(direccion);
        algoPoly.agregarUsuario(nombreJugador, ficha);
        this.txt1.clear();
        this.bton.setVisible(false);

        if (algoPoly.getCantidadJugadores() >= 3) {
            ContenedorPrincipal contenedor = new ContenedorPrincipal();
            Scene EscenaPrincipal = new Scene(contenedor, 1280, 720);
            stage.setScene(EscenaPrincipal);
        }
	}
	

}
