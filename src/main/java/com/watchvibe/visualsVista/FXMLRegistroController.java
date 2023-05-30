package com.watchvibe.visualsVista;

import com.watchvibe.adModelo.operaciones.Operacion;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.regex.Pattern;

public class FXMLRegistroController {
    @FXML
    public ImageView imagen1;
    @FXML
    public ImageView imagen2;
    @FXML
    public ImageView imagen3;
    @FXML
    public ImageView imagen4;
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
    public ImageView imagen13;
    @FXML
    public ImageView imagen14;
    @FXML
    public ImageView imagen15;
    @FXML
    public ImageView imagen16;
    @FXML
    public ImageView logotipo;
    @FXML
    public ImageView fondo;
    @FXML
    public ImageView imagen17;
    @FXML
    public ImageView imagen18;
    @FXML
    public ImageView imagen5;
    @FXML
    public Pane panelprincipal;
    @FXML
    public Text labelusuario;
    @FXML
    public TextField textfieldusuario;
    @FXML
    public Text labelcontrasena;
    @FXML
    public TextField textfieldcontrasena;
    @FXML
    public Button botonregistro;
    @FXML
    public Text labelrepcontrasena;
    @FXML
    public TextField textfieldrepcontrasena;
    @FXML
    public Text labelemail;
    @FXML
    public TextField textfieldemail;
    @FXML
    public Button botoncancelar;
    @FXML
    public Label botonCerrar;
    @FXML
    public Label botonminimizar;

    Operacion op = new Operacion();

    public void initialize() {

        panelprincipal.toFront();

        labelusuario.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 15px; " +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");

        labelcontrasena.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 15px; " +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");

        labelrepcontrasena.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 15px; " +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");

        labelemail.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 15px; " +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");

        textfieldusuario.getStyleClass().add("custom-textfield");
        textfieldcontrasena.getStyleClass().add("custom-textfield");
        textfieldrepcontrasena.getStyleClass().add("custom-textfield");
        textfieldemail.getStyleClass().add("custom-textfield");

        botonregistro.getStyleClass().add("boton-material");
        botoncancelar.getStyleClass().add("boton-material");


        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image = new Image(getClass().getResourceAsStream("/com/watchvibe/icono/logopng.png"));
        logotipo.setImage(image);

        Image backgroundImage = new Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/naranja.png"));
        fondo.setImage(backgroundImage);

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
        Image image12 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_series/c4mk4EQVIM11yd3W43DDdqDazDU.jpg"));
        imagen12.setImage(image12);



        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image13 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/El_gato_con_botas_El_ltimo_deseo-632107416-large.jpg"));
        imagen13.setImage(image13);


        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image14 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/Every-thing-cartel.jpg"));
        imagen14.setImage(image14);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image15 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/mdLDgQBD0va09npSQX5Zgo2evXM.jpg"));
        imagen15.setImage(image15);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image16 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/mZ4gBdfkhP9tvLH1DO4m4HYtiyi.jpg"));
        imagen16.setImage(image16);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image17 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_series/0441DO_4.jpg"));
        imagen17.setImage(image17);

        /**
         * Asignacion de Logo a la pantalla Inicial
         */
        Image image18 = new Image(getClass().getResourceAsStream("/com/watchvibe/caratulas_peliculas/jQ0gylJMxWSL490sy0RrPj1Lj7e.jpg"));
        imagen18.setImage(image18);

    }

    @FXML
    public void onClicCerrar(Event event) {
    }

    @FXML
    public void onClicMinimizar(Event event) {
    }

    public void onClicCerrar(MouseEvent mouseEvent) {
        Node source = (Node) mouseEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void onClicMinimizar(MouseEvent mouseEvent) {
        Node source = (Node) mouseEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setIconified(true);
    }


    @FXML
    public void onClickCancelar(ActionEvent actionEvent) {
        try {
            op.cambiarEscena(actionEvent,"/com/watchvibe/ProyectoFinal/FXMLogin.fxml", getClass());
        } catch (Exception ex) {
        System.err.println("Error! " + ex.getMessage());
    }


    }

    @FXML
    public void onClickRegistro(ActionEvent actionEvent) {
        Boolean UsuarioUtilizado = false;
        Boolean EmailUtilizado = false;
        Boolean PassDiferente = false;
        Boolean correct;
        Operacion op = new Operacion();

        if (textfieldusuario.getText().isBlank()) {
            vibrarcion(textfieldusuario);
            textfieldusuario.setStyle("-fx-border-color: red ; -fx-border-width: 0.5px ;");
            correct = false;
        } else {
            textfieldusuario.setStyle("");
            if (textfieldemail.getText().isBlank()) {
                vibrarcion(textfieldusuario);
                textfieldemail.setStyle("-fx-border-color: red ; -fx-border-width: 0.5px ;");
                correct = false;
            } else {
                textfieldemail.setStyle("");
                /*Contraseña entre 4 y 32 caracteres que necesita al menos 3 de 4 (mayúsculas y letras minúsculas, números y caracteres especiales) y como máximo 2 caracteres consecutivos iguales.*/
                String COMPLEX_PASSWORD_REGEX = "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|"
                        + "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|"
                        + "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|"
                        + "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})"
                        + "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]"
                        + "{8,32}$";
                Pattern PASSWORD_PATTERN = Pattern.compile(COMPLEX_PASSWORD_REGEX);
                String password = textfieldcontrasena.getText();
                // Validar una contraseña
                if (!PASSWORD_PATTERN.matcher(password).matches()) {
                    vibrarcion(textfieldcontrasena);
                    textfieldcontrasena.setStyle("-fx-border-color: red ; -fx-border-width: 0.5px ;");
                    correct = false;
                } else {
                    textfieldcontrasena.setStyle("");
                    String con1, con2;
                    con1 = textfieldcontrasena.getText();
                    con2 = textfieldrepcontrasena.getText();
                    if (!con1.equalsIgnoreCase(con2)) {
                        vibrarcion(textfieldrepcontrasena);
                        textfieldrepcontrasena.setStyle("-fx-border-color: red ; -fx-border-width: 0.5px ;");
                        PassDiferente = true;
                        correct = false;
                    } else {
                        textfieldrepcontrasena.setStyle("");
                        correct = true;
                    }

                }
            }

        }if (correct) {
            System.out.println(op.procesarRegistro(this));
            try {
                op.cambiarEscena(actionEvent,"/com/watchvibe/ProyectoFinal/FXMLogin.fxml", getClass());
            } catch (Exception ex) {
                System.err.println("No pudo encontrar la clase " + ex.getMessage());
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setTitle("Correcto");
            alerta.setContentText("El registro ha sido correcto. Ya puedes iniciar sesión");
            alerta.initStyle(StageStyle.UTILITY);
            alerta.showAndWait();
        } else {
            if (UsuarioUtilizado) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Error. El nombre de usuario ya está en uso.");
                alerta.initStyle(StageStyle.UTILITY);
                alerta.showAndWait();
            } else if (EmailUtilizado) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Error. El correo ya está asociado a otra cuenta.");
                alerta.initStyle(StageStyle.UTILITY);
                alerta.showAndWait();
            } else if (PassDiferente) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Error. Las contraseñas no coinciden.");
                alerta.initStyle(StageStyle.UTILITY);
                alerta.showAndWait();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Error. Algún campo no es correcto.\nRevise los datos introducidos");
                alerta.initStyle(StageStyle.UTILITY);
                alerta.showAndWait();
            }


        }
    }


        private void vibrarcion (TextField textField)
            {
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
}

