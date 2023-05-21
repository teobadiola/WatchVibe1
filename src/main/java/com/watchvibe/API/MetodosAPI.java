package com.watchvibe.API;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.watchvibe.proyectofinal.FXMLMenuController;

import java.io.IOException;
import java.net.URL;

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



}
