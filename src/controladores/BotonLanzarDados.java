package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;

public class BotonLanzarDados implements EventHandler<ActionEvent> {
	private ImageView figura;
	public BotonLanzarDados(ImageView nuevafig){
		this.figura=nuevafig;
	}

	@Override
	public void handle(ActionEvent arg0) {
		figura.setTranslateX((figura.getTranslateX())+65);
        figura.setTranslateY((figura.getTranslateY())+10);
		
	}

}
