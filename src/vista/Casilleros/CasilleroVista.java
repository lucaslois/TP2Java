package vista.Casilleros;

import javafx.scene.image.Image;
import modelo.tablero.Casillero;

public class CasilleroVista {
    private Image imagen;
    private Casillero casillero;

    public CasilleroVista() {
        //this.casillero = casillero;
    }

    public void setImage(String nombre) {
        this.imagen = new Image(nombre);
    }

    public Image getImage() {
        return this.imagen;
    }
}
