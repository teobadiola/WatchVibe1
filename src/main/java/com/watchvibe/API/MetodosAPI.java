package com.watchvibe.API;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.watchvibe.adModelo.tablas.Peliculas;
import com.watchvibe.adModelo.tablas.Series;
import com.watchvibe.visualsVista.FXMLMenuController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MetodosAPI {
    private FXMLMenuController menuController;

    public MetodosAPI(FXMLMenuController menuController) {
        this.menuController = menuController;
    }
    public String cojerPoster(String nombre) {
        String claveAPI = "c5d32ee544149dd1396e8996324d5da5";
        String pathImagen = "https://image.tmdb.org/t/p/w500/";
        String busqueda =  menuController.textFieldBusqueda.getText();
        try {
            String url = "https://api.themoviedb.org/3/search/movie?api_key=" + claveAPI + "&query=" + busqueda;

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(new URL(url));

            JsonNode results = root.get("results");
            if (results.isArray() && results.size() > 0) {
                JsonNode firstResult = results.get(0);
                JsonNode posterPath = firstResult.get("poster_path");
                if (!posterPath.isMissingNode()) {
                    String posterPathValue = posterPath.asText();
                    pathImagen += posterPathValue;
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pathImagen;
    }

    public static List<Peliculas> buscarPeliculas(String claveAPI, String busqueda) {
        List<Peliculas> resultados = new ArrayList<>();

        try {

            busqueda = busqueda.replace(" ", "+");

            String url = "https://api.themoviedb.org/3/search/movie?api_key=" + claveAPI + "&query=" + busqueda + "&include_adult=false&language=en-US&page=1";
            System.out.println("URL:" + url);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(new URL(url));

            JsonNode results = root.get("results");
            if (results.isArray()) {
                for (JsonNode result : results) {
                    JsonNode posterPath = result.get("poster_path");
                    if (!posterPath.isMissingNode()) {
                        String posterPathValue = posterPath.asText();
                        String pathImagen = "https://image.tmdb.org/t/p/w500/" + posterPathValue;

                        String titulo = result.get("title").asText();
                        int anio = result.get("release_date").asText().isEmpty() ? 0 : Integer.parseInt(result.get("release_date").asText().substring(0, 4));
                        String sinopsis = result.get("overview").asText();
                        String fotodePortada = pathImagen;

                        Peliculas pelicula = new Peliculas(titulo, anio, sinopsis, fotodePortada);

                        System.out.println(pelicula.toString());
                        resultados.add(pelicula);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return resultados;
    }
    public static List<Series> buscarSeries(String claveAPI, String busqueda) {
        List<Series> resultados = new ArrayList<>();

        try {
            busqueda = busqueda.replace(" ", "+");

            String url = "https://api.themoviedb.org/3/search/tv?api_key=" + claveAPI + "&query=" + busqueda + "&include_adult=false&language=en-US&page=1";

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(new URL(url));

            JsonNode results = root.get("results");
            if (results.isArray()) {
                for (JsonNode result : results) {
                    JsonNode posterPath = result.get("poster_path");
                    if (!posterPath.isMissingNode()) {
                        String posterPathValue = posterPath.asText();
                        String pathImagen = "https://image.tmdb.org/t/p/w500/" + posterPathValue;

                        String titulo = result.get("name").asText();
                        int anio = result.get("first_air_date").asText().isEmpty() ? 0 : Integer.parseInt(result.get("first_air_date").asText().substring(0, 4));
                        String sinopsis = result.get("overview").asText();
                        String fotodePortada = pathImagen;

                        Series serie = new Series(titulo , anio, sinopsis, fotodePortada);

                        resultados.add(serie);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return resultados;
    }


    public static void main(String[] args) {
        List<Series> series = MetodosAPI.buscarSeries("c5d32ee544149dd1396e8996324d5da5", "zatch bell");

        for (Series serie : series) {
            System.out.println(serie);
        }
    }




    //https://api.themoviedb.org/3/search/movie?api_key=c5d32ee544149dd1396e8996324d5da5&query=%2520hunger%2520games&include_adult=false&language=en-US&page=1

    //https://api.themoviedb.org/3/search/movie?api_key=c5d32ee544149dd1396e8996324d5da5&query=%2520hunger%2520games&include_adult=false&language=en-US&page=1
}
