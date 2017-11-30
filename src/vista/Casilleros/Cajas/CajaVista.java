package vista.Casilleros.Cajas;

import exceptions.CajaNoComprableException;
import exceptions.NoSePuedeVenderException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import vista.Casilleros.Ficha;
import vista.Casilleros.Posicion;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

public abstract class CajaVista {
    protected Image imagen = new Image("File:src/vista/assets/images/casilleros/undefined.jpg");
    protected Casillero casillero;
    protected StackPane panel;
    protected Posicion pos;

    public CajaVista(Casillero casillero) {
        this.casillero = casillero;
        this.panel = new StackPane();
        this.pos = new Posicion();
    }

    protected void setImage(Image imagen) {
        this.imagen = imagen;
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

    public void setPosicion(int col, int row) {
        this.pos.setPos(col, row);
    }

    public Posicion getPosicion() {
        return this.pos;
    }

    public void pisar(Jugador unJugador) {
        this.casillero.pisar(unJugador);
    }

    public abstract void mostrarOpciones(Usuario usuario, PlayerInformation panelInformacion);

    public void esCompradoPor(Jugador jugador) {
        throw new CajaNoComprableException();
    }

    public void esVendidoPor(Jugador jugador) { throw new NoSePuedeVenderException(); }
}
