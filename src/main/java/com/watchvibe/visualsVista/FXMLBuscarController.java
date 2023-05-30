package com.watchvibe.visualsVista;

import com.watchvibe.adModelo.tablas.Peliculas;
import com.watchvibe.adModelo.tablas.Series;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.List;

public class FXMLBuscarController {

    @FXML
    private ImageView fondoizq;
    @FXML
    private ImageView portada;
    @FXML
    private ListView<Series> listviewseries;
    @FXML
    private ListView<Peliculas> listviewpeliculas;
    @FXML
    public Text titulo;
    @FXML
    public Text anio;
    @FXML
    public Text director;
    @FXML
    public Text titulotxt;
    @FXML
    public Text aniotxt;

    public Text getTitulo() {
        return titulo;
    }

    public void setTitulo(Text titulo) {
        this.titulo = titulo;
    }

    public Text getAnio() {
        return anio;
    }

    public void setAnio(Text anio) {
        this.anio = anio;
    }

    public Text getDirector() {
        return director;
    }

    public void setDirector(Text director) {
        this.director = director;
    }

    public Text getTitulotxt() {
        return titulotxt;
    }

    public void setTitulotxt(Text titulotxt) {
        this.titulotxt = titulotxt;
    }

    public Text getAniotxt() {
        return aniotxt;
    }

    public void setAniotxt(Text aniotxt) {
        this.aniotxt = aniotxt;
    }

    public void initialize() {
        listviewseries.getStyleClass().add("list-view-material");
        listviewseries.setPrefHeight(Control.USE_COMPUTED_SIZE);
        listviewseries.setStyle("-fx-background-color: transparent;");
        listviewpeliculas.getStyleClass().add("list-view-material");
        listviewpeliculas.setPrefHeight(Control.USE_COMPUTED_SIZE);
        listviewpeliculas.setStyle("-fx-background-color: transparent;");
    }
    public void setSeries(List<Series> series) {
        ObservableList<Series> observableSeriesList = FXCollections.observableArrayList(series);
        listviewseries.setItems(observableSeriesList);
        listviewseries.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Series> call(ListView<Series> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Series item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getTitulo());
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
    }

    public void setPeliculas(List<Peliculas> peliculas) {
        ObservableList<Peliculas> observablePeliculasList = FXCollections.observableArrayList(peliculas);
        listviewpeliculas.setItems(observablePeliculasList);
        listviewpeliculas.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Peliculas> call(ListView<Peliculas> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Peliculas item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getTitulo());
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
        listviewpeliculas.setOnMouseClicked(event -> {
            Peliculas selectedPelicula = listviewpeliculas.getSelectionModel().getSelectedItem();
            if (selectedPelicula != null) {
                titulotxt.setText(selectedPelicula.getTitulo());
                aniotxt.setText(" "+selectedPelicula.getAnio());

            }
        });

        listviewseries.setOnMouseClicked(event -> {
            Series selectedSerie = listviewseries.getSelectionModel().getSelectedItem();
            if (selectedSerie != null) {
                titulotxt.setText(selectedSerie.getTitulo());
                aniotxt.setText(" "+selectedSerie.getAnio());

            }
        });
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
}