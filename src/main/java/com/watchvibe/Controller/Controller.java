package com.watchvibe.Controller;

import com.watchvibe.adModelo.operaciones.Operacion;
import com.watchvibe.visualsVista.Main;
import javafx.application.Application;
import javafx.scene.control.Button;

public class Controller {

    
    //Vista
    Main vi = new Main();

    //Modelo
    Operacion op = new Operacion();

    public Controller() {
        Application.launch(vi.getClass());

    }



}



