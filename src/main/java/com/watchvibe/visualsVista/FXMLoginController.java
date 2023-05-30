package com.watchvibe.visualsVista;

import com.watchvibe.adModelo.cruds.CRUDUsuarios;
import com.watchvibe.adModelo.operaciones.Operacion;
import com.watchvibe.adModelo.tablas.Usuarios;
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


import java.io.IOException;
import java.util.ArrayList;

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

    Operacion op = new Operacion();

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

       String[] imagePaths = {
               "/com/watchvibe/icono/logopng.png",
               "/com/watchvibe/caratulas_peliculas/Sonic_2_La_pel_cula-126622695-large.jpg",
               "/com/watchvibe/caratulas_peliculas/3Gkb6jm6962ADUPaCBqzz9CTbn9.jpg",
               "/com/watchvibe/caratulas_peliculas/eCOtqtfvn7mxGl6nfmq4b1exJRc.jpg",
               "/com/watchvibe/caratulas_peliculas/q719jXXEzOoYaps6babgKnONONX.jpg",
               "/com/watchvibe/caratulas_peliculas/5bqwnvdmxYA55FFMc95oNvlAoYk.jpg",
               "/com/watchvibe/caratulas_peliculas/9050VGrYjYrEjpOvDZVAngLbg1f.jpg",
               "/com/watchvibe/caratulas_peliculas/dm06L9pxDOL9jNSK4Cb6y139rrG.jpg",
               "/com/watchvibe/caratulas_peliculas/El_gato_con_botas_El_ltimo_deseo-632107416-large.jpg",
               "/com/watchvibe/caratulas_peliculas/Every-thing-cartel.jpg",
               "/com/watchvibe/caratulas_peliculas/mdLDgQBD0va09npSQX5Zgo2evXM.jpg",
               "/com/watchvibe/caratulas_peliculas/mZ4gBdfkhP9tvLH1DO4m4HYtiyi.jpg",
               "/com/watchvibe/caratulas_peliculas/jQ0gylJMxWSL490sy0RrPj1Lj7e.jpg"
       };

       ImageView[] imageViews = {
               imagenlogo,
               imagen1,
               imagen2,
               imagen3,
               imagen4,
               imagen5,
               imagen6,
               imagen7,
               imagen8,
               imagen9,
               imagen10,
               imagen11,
               imagen12
       };

       for (int i = 0; i < imagePaths.length; i++) {
           Image image = new Image(getClass().getResourceAsStream(imagePaths[i]));
           imageViews[i].setImage(image);
       }
        */

       ImageView[] imageViews = {
               imagenlogo,
               imagen1,
               imagen2,
               imagen3,
               imagen4,
               imagen5,
               imagen6,
               imagen7,
               imagen8,
               imagen9,
               imagen10,
               imagen11,
               imagen12
       };

       ArrayList<String> imagePaths = op.obtenerPathsPeliculasAleatorios();

       op.agregarURLsAImageViews(imagePaths, imageViews);


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
                op.cambiarEscena(actionEvent,"/com/watchvibe/ProyectoFinal/FXMLMenu.fxml", getClass());
            } catch (Exception ex) {
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
        op.cambiarEscena(mouseEvent,"/com/watchvibe/ProyectoFinal/FXMLRegistro.fxml", getClass());
    }
}
