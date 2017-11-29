package vista.mainScene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modelo.tablero.tipos_casilleros.Salida;
import vista.Casilleros.CasilleroVista;

public class CampoJuego extends GridPane {
    public CampoJuego() {
        // FILA DE ABAJO
        CasilleroVista salida = new CasilleroVista();
        salida.setImage("File:src/vista/assets/images/casilleros/Tablero_21.jpg");
        CasilleroVista quini6 = new CasilleroVista();
        quini6.setImage("File:src/vista/assets/images/casilleros/Tablero_20.jpg");
        CasilleroVista barrio1 = new CasilleroVista();
        barrio1.setImage("File:src/vista/assets/images/casilleros/Tablero_19.jpg");
        CasilleroVista edesur = new CasilleroVista();
        edesur.setImage("File:src/vista/assets/images/casilleros/Tablero_18.jpg");
        CasilleroVista barrio2 = new CasilleroVista();
        barrio2.setImage("File:src/vista/assets/images/casilleros/Tablero_17.jpg");
        CasilleroVista carcel = new CasilleroVista();
        carcel.setImage("File:src/vista/assets/images/casilleros/Tablero_16.jpg");

        // COLUMNA IZQUIERDA
        CasilleroVista barrio3 = new CasilleroVista();
        barrio3.setImage("File:src/vista/assets/images/casilleros/Tablero_14.jpg");
        CasilleroVista avance = new CasilleroVista();
        avance.setImage("File:src/vista/assets/images/casilleros/Tablero_12.jpg");
        CasilleroVista subte = new CasilleroVista();
        subte.setImage("File:src/vista/assets/images/casilleros/Tablero_10.jpg");
        CasilleroVista barrio4 = new CasilleroVista();
        barrio4.setImage("File:src/vista/assets/images/casilleros/Tablero_07.jpg");
        CasilleroVista impuesto = new CasilleroVista();
        impuesto.setImage("File:src/vista/assets/images/casilleros/Tablero_01.jpg");

        // FILA TOP
        CasilleroVista barrio5 = new CasilleroVista();
        barrio5.setImage("File:src/vista/assets/images/casilleros/Tablero_02.jpg");
        CasilleroVista aysa = new CasilleroVista();
        aysa.setImage("File:src/vista/assets/images/casilleros/Tablero_03.jpg");
        CasilleroVista barrio6 = new CasilleroVista();
        barrio6.setImage("File:src/vista/assets/images/casilleros/Tablero_04.jpg");
        CasilleroVista barrio7 = new CasilleroVista();
        barrio7.setImage("File:src/vista/assets/images/casilleros/Tablero_05.jpg");
        CasilleroVista policia = new CasilleroVista();
        policia.setImage("File:src/vista/assets/images/casilleros/Tablero_06.jpg");

        // COLUMNA RIGHT
        CasilleroVista tren = new CasilleroVista();
        tren.setImage("File:src/vista/assets/images/casilleros/Tablero_10.jpg");
        CasilleroVista barrio8 = new CasilleroVista();
        barrio8.setImage("File:src/vista/assets/images/casilleros/Tablero_11.jpg");
        CasilleroVista retroceso = new CasilleroVista();
        retroceso.setImage("File:src/vista/assets/images/casilleros/Tablero_13.jpg");
        CasilleroVista barrio9 = new CasilleroVista();
        barrio9.setImage("File:src/vista/assets/images/casilleros/Tablero_15.jpg");

        this.add(new ImageView(salida.getImage()), 5, 5);
        this.add(new ImageView(quini6.getImage()), 4, 5);
        this.add(new ImageView(barrio1.getImage()), 3, 5);
        this.add(new ImageView(edesur.getImage()), 2, 5);
        this.add(new ImageView(barrio2.getImage()), 1, 5);
        this.add(new ImageView(carcel.getImage()), 0, 5);

        this.add(new ImageView(barrio3.getImage()), 0, 4);
        this.add(new ImageView(avance.getImage()), 0, 3);
        this.add(new ImageView(subte.getImage()), 0, 2);
        this.add(new ImageView(barrio4.getImage()), 0, 1);
        this.add(new ImageView(impuesto.getImage()), 0, 0);

        this.add(new ImageView(barrio5.getImage()), 1, 0);
        this.add(new ImageView(aysa.getImage()), 2, 0);
        this.add(new ImageView(barrio6.getImage()), 3, 0);
        this.add(new ImageView(barrio7.getImage()), 4, 0);
        this.add(new ImageView(policia.getImage()), 5, 0);

        this.add(new ImageView(tren.getImage()), 5, 1);
        this.add(new ImageView(barrio8.getImage()), 5, 2);
        this.add(new ImageView(retroceso.getImage()), 5, 3);
        this.add(new ImageView(barrio9.getImage()), 5, 4);

        this.add(new ImageView(new Image("File:src/vista/assets/images/casilleros/Tablero_08.jpg")), 1, 1, 4, 4);
    }
}
