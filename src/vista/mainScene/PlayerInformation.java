package vista.mainScene;

import controladores.BotonLanzarDados;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.jugador.Jugador;

public class PlayerInformation extends VBox {
    private Jugador jugador;

    public PlayerInformation(Jugador unJugador,ImageView figura) {
        this.jugador = unJugador;

        Label labelNombre = new Label();
        labelNombre.setText(this.jugador.getNombre());
        labelNombre.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));

        Label labelDinero = new Label();
        labelDinero.setText("$" + this.jugador.getDinero());
        labelDinero.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        labelDinero.setTextFill(Color.web("#2bcc4e"));

        Button lnzarDadosButton = new Button();
        lnzarDadosButton.setText("Lanzar los dados");
        BotonLanzarDados botonLanzar=new BotonLanzarDados(figura);
        lnzarDadosButton.setOnAction(botonLanzar);
        Button comprarButton = new Button();
        comprarButton.setText("Comprar propiedad");

        this.getChildren().addAll(labelNombre, labelDinero, lnzarDadosButton, comprarButton);
    }
}
