package com.watchvibe.Principal;

import com.watchvibe.API.MetodosAPI;
import com.watchvibe.Controller.Controller;
import com.watchvibe.adModelo.operaciones.Operacion;
import com.watchvibe.adModelo.tablas.Peliculas;
import com.watchvibe.adModelo.tablas.Series;

import java.util.List;

public class principal {
    public static void main(String[] args) {
        /*
        Operacion op = new Operacion();
        // Precarga de 10 películas
        List<Peliculas> peliculas = MetodosAPI.buscarPeliculas("c5d32ee544149dd1396e8996324d5da5", "pelicula");

        for (int i = 0; i < 10 && i < peliculas.size(); i++) {
            Peliculas pelicula = peliculas.get(i);
            op.agregarPeliculaPreCarga(pelicula);
        }

        System.out.println("Precarga de Peliculas realizada");

        // Precarga de 10 series
        List<Series> series = MetodosAPI.buscarSeries("c5d32ee544149dd1396e8996324d5da5", "series");

        for (int i = 0; i < 10 && i < series.size(); i++) {
            Series serie = series.get(i);
            op.agregarSeriePreCarga(serie);
        }

        System.out.println("Precarga de Series realizada");

        */
        Controller controlador = new Controller();
    }
}
