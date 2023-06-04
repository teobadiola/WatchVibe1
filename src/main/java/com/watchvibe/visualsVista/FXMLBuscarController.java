package com.watchvibe.visualsVista;

import com.watchvibe.API.MetodosAPI;
import com.watchvibe.adModelo.operaciones.Autenticator;
import com.watchvibe.adModelo.operaciones.Operacion;
import com.watchvibe.adModelo.tablas.Peliculas;
import com.watchvibe.adModelo.tablas.Series;
import com.watchvibe.adModelo.tablas.Usuarios;
import com.welag.ad.tablas.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.util.List;

public class FXMLBuscarController {

    private Usuarios usuarioLogueado;
    @FXML
    private Text sinopsis;
    @FXML
    private Text sionpsistxt;
    @FXML
    private Text pathimagentxt;
    @FXML
    private Button botonbuscar;
    @FXML
    private TextField textfieldbusqueda;
    @FXML
    private Button botonvolver;
    @FXML
    private Button bototnAñadirReserña;
    @FXML
    private Button bototnVerReseñas;

    public void setUsuarioLogueado(Usuarios usuario) {
        this.usuarioLogueado = usuario;
    }

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
    public Text titulotxt;
    @FXML
    public Text aniotxt;
    @FXML
    private Button bototnAñadir;
    @FXML
    private Label botonCerra;
    @FXML
    private Label botonminimiza;

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

    public Text getSionpsistxt() {
        return sionpsistxt;
    }

    public void setSionpsistxt(Text sionpsistxt) {
        this.sionpsistxt = sionpsistxt;
    }

    public Text getPathimagentxt() {
        return pathimagentxt;
    }

    public void setPathimagentxt(Text pathimagentxt) {
        this.pathimagentxt = pathimagentxt;
    }

    public void initialize() {
        bototnAñadirReserña.getStyleClass().add("boton-material");
        bototnAñadir.getStyleClass().add("boton-material");
        botonbuscar.getStyleClass().add("boton-material");
        botonvolver.getStyleClass().add("boton-material");
        textfieldbusqueda.getStyleClass().add("custom-textfield");

        setUsuarioLogueado(usuarioLogueado);
        listviewseries.getStyleClass().add("list-view-material");
        listviewseries.setPrefHeight(Control.USE_COMPUTED_SIZE);
        listviewseries.setStyle("-fx-background-color: transparent;");
        listviewpeliculas.getStyleClass().add("list-view-material");
        listviewpeliculas.setPrefHeight(Control.USE_COMPUTED_SIZE);
        listviewpeliculas.setStyle("-fx-background-color: transparent;");

        // Ocultar la barra de desplazamiento vertical del ListView de series
        ScrollBar seriesScrollBar = (ScrollBar) listviewseries.lookup(".scroll-bar:vertical");
        if (seriesScrollBar != null) {
            seriesScrollBar.setVisible(false);
        }

        // Ocultar la barra de desplazamiento vertical del ListView de películas
        ScrollBar peliculasScrollBar = (ScrollBar) listviewpeliculas.lookup(".scroll-bar:vertical");
        if (peliculasScrollBar != null) {
            peliculasScrollBar.setVisible(false);
        }

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
                            setStyle("-fx-font-size: 10px;");
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
                            setStyle("-fx-font-size: 10px;");
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
                aniotxt.setText("" + selectedPelicula.getAnio());
                String sinopsis = selectedPelicula.getSinopsis();
                if (sinopsis.length() > 200) {
                    sinopsis = sinopsis.substring(0, 200) + "...";
                }
                sionpsistxt.setText(sinopsis);
                pathimagentxt.setText(selectedPelicula.getFotodePortada());
                portada.setImage(new Image(selectedPelicula.getFotodePortada()));
            }
        });

        listviewseries.setOnMouseClicked(event -> {
            Series selectedSerie = listviewseries.getSelectionModel().getSelectedItem();
            if (selectedSerie != null) {
                titulotxt.setText(selectedSerie.getTitulo());
                aniotxt.setText("" + selectedSerie.getAnio());
                String sinopsis = selectedSerie.getSinopsis();
                if (sinopsis.length() > 200) {
                    sinopsis = sinopsis.substring(0, 200) + "...";
                }
                sionpsistxt.setText(sinopsis);
                pathimagentxt.setText(selectedSerie.getFotodePortada());
                portada.setImage(new Image(selectedSerie.getFotodePortada()));
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

    public void añadir(ActionEvent actionEvent) {
        // Obtener la película seleccionada
        Peliculas peliculaSeleccionada = listviewpeliculas.getSelectionModel().getSelectedItem();

        if (peliculaSeleccionada != null) {
            // Crear un objeto de tipo Operacion
            Operacion operacion = new Operacion();
            operacion.agregarPelicula(this,usuarioLogueado); // Añadir la película seleccionada a la operación

        }
    }

    @javafx.fxml.FXML
    public void metodoBuscarPeliculasySeries(ActionEvent actionEvent) {
        List<Series> series = MetodosAPI.buscarSeries("c5d32ee544149dd1396e8996324d5da5", textfieldbusqueda.getText());
        List<Peliculas> peliculas = MetodosAPI.buscarPeliculas("c5d32ee544149dd1396e8996324d5da5", textfieldbusqueda.getText());

        if (series.isEmpty() && peliculas.isEmpty()) {
            System.out.println("No hay resultados para esta búsqueda");
            return; // No cargar la nueva escena si ambas listas están vacías
        } else {
                // Limpiar el ListView
                listviewseries.getItems().clear();
                listviewpeliculas.getItems().clear();

                // Agregar las series al ListView
                for (Series serie : series) {
                    listviewseries.getItems().add(serie);
                }

                // Agregar las películas al ListView
                for (Peliculas pelicula : peliculas) {
                    listviewpeliculas.getItems().add(pelicula);
                }
            }
        }



    @FXML
    public void onClickVolver(ActionEvent actionEvent) {
        Usuarios user = Autenticator.getUsuarioLogueado();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/watchvibe/ProyectoFinal/FXMLMenu.fxml"));
            Parent root = loader.load();
            FXMLMenuController menuController = loader.getController();
            menuController.setUsuario(user);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene.getStylesheets().add(getClass().getResource("/com/watchvibe/css/materialbotonesestilo.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Error! " + ex.getMessage());
        }
    }

    @FXML
    public void añadir(ActionEvent actionEvent) {
    }

    @FXML
    public void onClicCerrar(Event event) {
    }

    @FXML
    public void onClicMinimizar(Event event) {
    }

    @FXML
    public void añadirReseña(ActionEvent actionEvent) {
    }

    @FXML
    public void añadir(ActionEvent actionEvent) {
    }
}

