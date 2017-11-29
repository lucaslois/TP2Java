package vista.Casilleros;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import modelo.tablero.Casillero;

public class CasilleroVista {
    private Image imagen;
    private Casillero casillero;
    private StackPane panel;
    private Posicion pos;

    public CasilleroVista(Casillero casillero) {
        this.casillero = casillero;
        this.panel = new StackPane();
        this.pos = new Posicion();
    }

    public void setImage(String nombre) {
        this.imagen = new Image(nombre);
        this.panel.getChildren().add(new ImageView(this.imagen));
    }

    public Image getImage() {
        return this.imagen;
    }

    public StackPane getPanel() {
        return this.panel;
    }

    public void addFicha(Ficha ficha) {
        this.panel.getChildren().add(new ImageView(ficha.getImage()));
    }

    public void quitarFicha(Ficha ficha) {
        this.panel.getChildren().remove(ficha);
    }

    public void setPosicion(int col, int row) {
        this.pos.setPos(col, row);
    }

    public Posicion getPosicion() {
        return this.pos;
    }
}
