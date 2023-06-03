package com.watchvibe.visualsVista;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
public class Main extends Application {

    private Button boton1;
    private Label boton2;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/watchvibe/ProyectoFinal/FXMLogin.fxml"));
        Parent root = fxmlLoader.load();

        // Obtener los botones del archivo FXML
        boton1 = (Button) fxmlLoader.getNamespace().get("botoniniciosesion");
        boton2 = (Label) fxmlLoader.getNamespace().get("registrase");

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/watchvibe/css/materialbotonesestilo.css").toExternalForm());
        stage.setTitle("WatchVibe");
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        javafx.scene.image.Image backg = new javafx.scene.image.Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/ISOTIPO_NEGRO.png"));
        stage.getIcons().add(backg);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public void setBoton1ActionListener(EventHandler<ActionEvent> eventHandler) {
        boton1.setOnAction(eventHandler);
    }

    public void setBoton2ActionListener(EventHandler<MouseEvent> eventHandler) {
        boton2.setOnMouseClicked(eventHandler);
    }
}
