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
import java.util.ArrayList;
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

        ImageView[] imageViewspelis = {
                imagen1,
                imagen2,
                imagen3,
                imagen4,
                imagen5,
                imagen6
        };

        ImageView[] imageViewsSeries = {
                imagen7,
                imagen8,
                imagen9,
                imagen10,
                imagen11,
                imagen12
        };

        ImageView[] imageViewsTV = {
                imagen13,
                imagen14,
                imagen15,
                imagen16,
                imagen17,
                imagen18
        };

        ArrayList<String> imagePathspelis = op.obtenerPathsPeliculasAleatorios();
        System.out.println(imagePathspelis.size());

        ArrayList<String> imagePathsSeries = op.obtenerPathsSeriesAleatorios();
        System.out.println(imagePathsSeries.size());

        ArrayList<String> imagePathsTV = op.obtenerPathsPeliculasAleatorios();
        System.out.println(imagePathspelis.size());

        op.agregarURLsAImageViewsPeliculas(imagePathspelis, imageViewspelis);
        op.agregarURLsAImageViewsSeries(imagePathsSeries, imageViewsSeries);
        op.agregarURLsAImageViewsSeries(imagePathsTV, imageViewsTV);

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

