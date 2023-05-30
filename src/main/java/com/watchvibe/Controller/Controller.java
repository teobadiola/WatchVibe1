package com.watchvibe.Controller;

import com.watchvibe.adModelo.operaciones.Operacion;
import com.watchvibe.visualsVista.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    // Vista
    Main vi = new Main();

    // Modelo
    Operacion op = new Operacion();

    public Controller() {
        Application.launch(vi.getClass());
    }

    // Agregar el código adicional aquí

    @FXML
    public void handleBoton1(ActionEvent event) {
        System.out.println("BOTON LOGIN");
    }

    @FXML
    public void handleBoton2(ActionEvent event) {
        System.out.println("boton registro");
    }
}
