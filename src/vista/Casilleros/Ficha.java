package vista.Casilleros;

import javafx.scene.image.Image;

public class Ficha {
    private Image image;

    public Ficha(String nombre) {
        this.image = new Image(nombre);
    }

    public Image getImage() {
        return this.image;
    }
}
