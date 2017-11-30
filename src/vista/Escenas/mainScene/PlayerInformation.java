package vista.Escenas.mainScene;

import controladores.LanzarDadosController;
import controladores.ComprarPropiedadController;
import controladores.PasarTurnoController;
import controladores.VenderPropiedadesController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.jugador.Jugador;
import modelo.tablero.tipos_casilleros.Comprable;
import vista.AlgoPoly;
import vista.Usuario;

public class PlayerInformation extends VBox {
    private Button lanzarDadosButton;
    private Button comprarButton;
    private Button pasarTurnoButton;
    private Button venderPropiedadesButton;

    private ListaCasas listaCasas;
    private CuadroDados cuadroDados;

    private Label nombreJugadorLabel;
    private Label dineroJugadorLabel;

    private LanzarDadosController lanzarDadosController;
    private ComprarPropiedadController comprarPropiedadController;
    private PasarTurnoController pasarTurnoController;
    private VenderPropiedadesController venderPropiedadesController;

    public PlayerInformation(Usuario user) {
        AlgoPoly algoPoly = AlgoPoly.getInstance();
        algoPoly.setPanelPlayerInformation(this);
        this.listaCasas = new ListaCasas();
        this.cuadroDados = new CuadroDados();

        this.create(user);
    }

    public void setDados(int dado1, int dado2) {
        this.cuadroDados.getChildren().clear();
        Label label = new Label();
        label.setText("Tirada de dados");
        label.setTextFill(Color.web("#2a885a"));
        label.setStyle("-fx-font-size: 14; -fx-font-weight: bold");
        this.cuadroDados.getChildren().add(label);

        Image imagen1 = new Image("File:src/vista/assets/images/dados/d6_0" + dado1 + ".png");
        Image imagen2 = new Image("File:src/vista/assets/images/dados/d6_0" + dado2 + ".png");

        this.cuadroDados.getChildren().addAll(new ImageView(imagen1), new ImageView(imagen2));
    }

    public void refresh() {
        Usuario usuario = AlgoPoly.getInstance().getUsuarioActual();
        Jugador jugador = usuario.getJugador();

        this.nombreJugadorLabel.setText("Turno de " + jugador.getNombre());
        this.nombreJugadorLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        this.dineroJugadorLabel.setText("$" + jugador.getDinero());

        this.lanzarDadosController.setUsuario(usuario);
        this.comprarPropiedadController.setUsuario(usuario);
        this.pasarTurnoController.setUsuario(usuario);

        this.listaCasas.getChildren().clear();
        Label label = new Label();
        label.setText("Propiedades");
        label.setTextFill(Color.web("#573939"));
        label.setStyle("-fx-font-size: 14; -fx-font-weight: bold");
        this.listaCasas.getChildren().add(label);
        for(Comprable comprable : jugador.getListaComprables()) {
            Label label_aux = new Label();
            label_aux.setText("# " + comprable.getNombre() + ": $" + comprable.getPrecio());
            label_aux.setTextFill(Color.web("#573939"));
            label_aux.setStyle("-fx-font-size: 13;");
            this.listaCasas.getChildren().add(label_aux);
        }
    }

    public void create(Usuario user) {
        Jugador jugador = user.getJugador();
        AlgoPoly algoPoly = AlgoPoly.getInstance();
        Usuario usuario = algoPoly.getUsuarioActual();

        this.setStyle("-fx-background-color: #b1d6f2");

        this.nombreJugadorLabel = new Label();
        this.nombreJugadorLabel.setText(jugador.getNombre());
        this.nombreJugadorLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));

        this.dineroJugadorLabel = new Label();
        this.dineroJugadorLabel.setText("$" + jugador.getDinero());
        this.dineroJugadorLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        this.dineroJugadorLabel.setTextFill(Color.web("#2bcc4e"));

        // BOTON LANZAR DADOS
        this.lanzarDadosButton = new Button();
        this.lanzarDadosButton.setText("Lanzar los dados");
        this.lanzarDadosController = new LanzarDadosController(usuario, this);
        this.lanzarDadosButton.setOnAction(this.lanzarDadosController);

        // BOTON COMPRAR PROPIEDAD
        this.comprarButton = new Button();
        this.comprarButton.setText("Comprar propiedad");
        this.comprarPropiedadController = new ComprarPropiedadController(usuario, this);
        this.comprarButton.setOnAction(this.comprarPropiedadController);

        // BOTON VENDER
        this.venderPropiedadesButton = new Button();
        this.venderPropiedadesButton.setText("Vender Propiedades");
        this.venderPropiedadesController = new VenderPropiedadesController(usuario, this);
        this.venderPropiedadesButton.setOnAction(this.venderPropiedadesController);

        // BOTON PASAR TURNO
        this.pasarTurnoButton = new Button();
        this.pasarTurnoButton.setText("Pasar Turno");
        this.pasarTurnoController = new PasarTurnoController(usuario, this);
        this.pasarTurnoButton.setOnAction(this.pasarTurnoController);

        this.getChildren().addAll(this.nombreJugadorLabel, this.dineroJugadorLabel, lanzarDadosButton, this.comprarButton, this.venderPropiedadesButton,this.pasarTurnoButton, this.listaCasas, this.cuadroDados);
    }

    public void setDisableLanzarDadosButton(Boolean check) {
        this.lanzarDadosButton.setDisable(check);
    }

    public void setDisableComprarButton(boolean disableComprarButton) {
        this.comprarButton.setDisable(disableComprarButton);
    }

    public void setDisablePasarTurnoButton(boolean disablePasarTurnoButton) {
        this.pasarTurnoButton.setDisable(disablePasarTurnoButton);
    }
}
