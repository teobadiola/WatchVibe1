package com.watchvibe.proyectofinal;

import com.watchvibe.ad.cruds.CRUDUsuarios;
import com.watchvibe.ad.tablas.Usuarios;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Label;
import javafx.util.Duration;


import java.awt.*;
import java.io.IOException;

public class FXMLoginController {
    @FXML
    public Pane principal;
    @FXML
    public ImageView imagen3;
    @FXML
    public ImageView imagen2;
    @FXML
    public ImageView imagen1;
    @FXML
    public ImageView imagen4;
    @FXML
    public ImageView imagen5;
    @FXML
    public ImageView imagen6;
    @FXML
    public ImageView imagen7;
    @FXML
    public ImageView imagen8;
    @FXML
    public ImageView imagen9;
    @FXML
    public ImageView imagen10;
    @FXML
    public ImageView imagen11;
    @FXML
    public ImageView imagen12;
    @FXML
    public AnchorPane panelinicioderecha;
    @FXML
    public Button botoniniciosesion;
    @FXML
    public ImageView imagenlogo;
    @FXML
    public ImageView fondo;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private TextField passwordFieldContrasena;
    boolean correcto = false;
    @FXML
    private Label botonCerra;
    @FXML
    private Label botonminimiza;
    @FXML
    private ImageView user;
    @FXML
    private ImageView contra;
    @FXML
    private Label registrase;


    /**
     *
     */
   public void initialize() {

       botoniniciosesion.getStyleClass().add("boton-material");

       textFieldUsuario.getStyleClass().add("custom-textfield");
       passwordFieldContrasena.getStyleClass().add("custom-textfield");
       registrase.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
               "-fx-font-size: 15px; " +
               "-fx-font-size: 0.875em; " +
               "-fx-border-color: white; " +
               "-fx-border-width: 0 0 1 0; " +
               "-fx-border-color: white; "+ " -fx-border-size:7; " + "-fx-color: white; ");

       Image backgroundImage = new Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/logindeg.png"));
       fondo.setImage(backgroundImage);
       fondo.toBack();

       Image usr = new Image(getClass().getResourceAsStream("/com/watchvibe/iconos_pequeños/avatar.png"));
       user.setImage(usr);
       Image pssq = new Image(getClass().getResourceAsStream("/com/watchvibe/iconos_pequeños/contrasena.png"));
       contra.setImage(pssq);



       panelinicioderecha.toFront();

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image = new Image(getClass().getResourceAsStream("/com/watchvibe/icono/logopng.png"));
        imagenlogo.setImage(image);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image1 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/Sonic_2_La_pel_cula-126622695-large.jpg"));
        imagen1.setImage(image1);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image2 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/3Gkb6jm6962ADUPaCBqzz9CTbn9.jpg"));
        imagen2.setImage(image2);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image3 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/eCOtqtfvn7mxGl6nfmq4b1exJRc.jpg"));
        imagen3.setImage(image3);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image4 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/q719jXXEzOoYaps6babgKnONONX.jpg"));
        imagen4.setImage(image4);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image5 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/5bqwnvdmxYA55FFMc95oNvlAoYk.jpg"));
        imagen5.setImage(image5);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image6 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/9050VGrYjYrEjpOvDZVAngLbg1f.jpg"));
        imagen6.setImage(image6);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image7 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/dm06L9pxDOL9jNSK4Cb6y139rrG.jpg"));
        imagen7.setImage(image7);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image8 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/El_gato_con_botas_El_ltimo_deseo-632107416-large.jpg"));
        imagen8.setImage(image8);


        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image9 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/Every-thing-cartel.jpg"));
        imagen9.setImage(image9);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image10 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/mdLDgQBD0va09npSQX5Zgo2evXM.jpg"));
        imagen10.setImage(image10);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image11 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/mZ4gBdfkhP9tvLH1DO4m4HYtiyi.jpg"));
        imagen11.setImage(image11);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image12 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/jQ0gylJMxWSL490sy0RrPj1Lj7e.jpg"));
        imagen12.setImage(image12);


    }


    @FXML
    public void onHandleBotoLogin(ActionEvent actionEvent) {
       CRUDUsuarios CR = new CRUDUsuarios();
       Usuarios user = null;
        if (textFieldUsuario.getText().isBlank() || passwordFieldContrasena.getText().isBlank()) {
            vibrarTextField(textFieldUsuario);
            vibrarTextField(passwordFieldContrasena);

            textFieldUsuario.setStyle("-fx-color: red");
            passwordFieldContrasena.setStyle("-fx-color: red");

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Error. Ningún campo puede estar vacío.");
            alerta.initStyle(StageStyle.UTILITY);
            alerta.showAndWait();


        } else {
            textFieldUsuario.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            passwordFieldContrasena.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            user = CR.getUsuarioporNombre(textFieldUsuario.getText());
            if (user != null && user.getContrasena().equals(passwordFieldContrasena.getText())) {
                correcto = true;
            } else {
                correcto = false;
                vibrarTextField(textFieldUsuario);
                vibrarTextField(passwordFieldContrasena);
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Error. El usuario o la contraseña son incorrectos.");
                alerta.initStyle(StageStyle.UTILITY);
                alerta.showAndWait();
            }
        }

        if (correcto) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                scene.getStylesheets().add(getClass().getResource("/com/watchvibe/css/materialbotonesestilo.css").toExternalForm());
                stage.setResizable(false);
                stage.initStyle(StageStyle.UNDECORATED);
                scene.setFill(Color.TRANSPARENT);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                Node source = (Node) actionEvent.getSource();
                Stage stageActual = (Stage) source.getScene().getWindow();
                stageActual.close();
                javafx.scene.image.Image backg = new javafx.scene.image.Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/ISOTIPO_NEGRO.png"));
                stage.getIcons().add(backg);
                stage.show();
            } catch (IOException ex) {
                System.err.println("Error! " + ex.getMessage());
            }
        }
    }

    @FXML
    public void onClicCerrar(javafx.scene.input.MouseEvent mouseEvent) {
        Node source = (Node) mouseEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void onClicMinimizar(javafx.scene.input.MouseEvent mouseEvent) {
        Node source = (Node) mouseEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setIconified(true);
    }

    private void vibrarTextField(TextField textField) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(0), new KeyValue(textField.translateXProperty(), 0)),
                new KeyFrame(Duration.millis(50), new KeyValue(textField.translateXProperty(), -5)),
                new KeyFrame(Duration.millis(100), new KeyValue(textField.translateXProperty(), 5)),
                new KeyFrame(Duration.millis(150), new KeyValue(textField.translateXProperty(), -5)),
                new KeyFrame(Duration.millis(200), new KeyValue(textField.translateXProperty(), 5)),
                new KeyFrame(Duration.millis(250), new KeyValue(textField.translateXProperty(), -5)),
                new KeyFrame(Duration.millis(300), new KeyValue(textField.translateXProperty(), 0))
        );
        timeline.setCycleCount(2);
        timeline.play();
    }

    @Deprecated
    public void clickenregistro(javafx.scene.input.MouseEvent mouseEvent) {

    }

    public void handleBotonRegistrarse(MouseEvent mouseEvent) {
        try {
            // Cargar el archivo FXML "perfil.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistro.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con el archivo FXML cargado
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/com/watchvibe/css/materialbotonesestilo.css").toExternalForm());

            // Obtener la ventana actual a través del evento
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

            // Establecer la escena en la ventana
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
