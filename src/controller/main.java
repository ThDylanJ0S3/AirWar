package controller;

import java.awt.geom.Rectangle2D;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
//import ServidorSockets.Servidor;

/**
 * Metodo principal que corre el juego
 *
 * @author Vidal Flores
 * @author Dylan Meza   
 * @author Brayner Moncada
 */
public class main extends Application {



    /**
     * se declara el contructor del metodo main para poder hacer ejecutable el
     * proyecto
     *
     * @param args se envian los argumentos y comandos de linea
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    /**
     * Método principal que genera el hilo necesario para poder ejecutar la GUI
     * y todos sus elementos.
     *
     * @param stage se envia como parametro el escenario de la GUI
     *
     */
    public void start(Stage stage) throws Exception {

        Parent rootMenu = FXMLLoader.load(getClass().getResource("/vista/menuPlay.fxml"));
        Scene sceneMenu = new Scene(rootMenu);
        Stage stageMenu = new Stage();
        stageMenu.setTitle("Menú principal");
        stageMenu.setScene(sceneMenu);

        stageMenu.show();

    }
}
