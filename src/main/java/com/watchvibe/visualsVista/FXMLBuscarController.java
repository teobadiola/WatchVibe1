package com.watchvibe.visualsVista;

import com.watchvibe.API.MetodosAPI;
import com.watchvibe.adModelo.operaciones.Autenticator;
import com.watchvibe.adModelo.operaciones.Conexion;
import com.watchvibe.adModelo.operaciones.Operacion;
import com.watchvibe.adModelo.tablas.*;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class FXMLBuscarController {

    private boolean elementoSeleccionado = false;

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
    @FXML
    private Pane PanelReseñas;
    @FXML
    private Pane panelTransparente;
    @FXML
    private Text textescribirreseña;
    @FXML
    private TextArea textoReseñaEnviar;
    @FXML
    private Button botonCancelarInterior;
    @FXML
    private Button botonAñadirReseñaInterior1;

    @Deprecated
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

    public Button getBototnAñadirReserña() {
        return bototnAñadirReserña;
    }

    public void setBototnAñadirReserña(Button bototnAñadirReserña) {
        this.bototnAñadirReserña = bototnAñadirReserña;
    }

    public Button getBototnVerReseñas() {
        return bototnVerReseñas;
    }

    public void setBototnVerReseñas(Button bototnVerReseñas) {
        this.bototnVerReseñas = bototnVerReseñas;
    }

    public Pane getPanelReseñas() {
        return PanelReseñas;
    }

    public void setPanelReseñas(Pane panelReseñas) {
        PanelReseñas = panelReseñas;
    }

    public Pane getPanelTransparente() {
        return panelTransparente;
    }

    public void setPanelTransparente(Pane panelTransparente) {
        this.panelTransparente = panelTransparente;
    }

    public Text getTextescribirreseña() {
        return textescribirreseña;
    }

    public void setTextescribirreseña(Text textescribirreseña) {
        this.textescribirreseña = textescribirreseña;
    }

    public TextArea getTextoReseñaEnviar() {
        return textoReseñaEnviar;
    }

    public void setTextoReseñaEnviar(TextArea textoReseñaEnviar) {
        this.textoReseñaEnviar = textoReseñaEnviar;
    }

    public Button getBotonCancelarInterior() {
        return botonCancelarInterior;
    }

    public void setBotonCancelarInterior(Button botonCancelarInterior) {
        this.botonCancelarInterior = botonCancelarInterior;
    }

    public Button getBotonAñadirReseñaInterior1() {
        return botonAñadirReseñaInterior1;
    }

    public void setBotonAñadirReseñaInterior1(Button botonAñadirReseñaInterior1) {
        this.botonAñadirReseñaInterior1 = botonAñadirReseñaInterior1;
    }

    public ListView<Series> getListviewseries() {
        return listviewseries;
    }

    public void setListviewseries(ListView<Series> listviewseries) {
        this.listviewseries = listviewseries;
    }

    public ListView<Peliculas> getListviewpeliculas() {
        return listviewpeliculas;
    }

    public void setListviewpeliculas(ListView<Peliculas> listviewpeliculas) {
        this.listviewpeliculas = listviewpeliculas;
    }

    public void initialize() {

        bototnAñadirReserña.setVisible(false);
        panelTransparente.setVisible(false);
        botonCancelarInterior.getStyleClass().add("boton-material");
        botonAñadirReseñaInterior1.getStyleClass().add("boton-material");
        bototnVerReseñas.getStyleClass().add("boton-material");
        bototnAñadirReserña.getStyleClass().add("boton-material");
        bototnAñadir.getStyleClass().add("boton-material");
        botonbuscar.getStyleClass().add("boton-material");
        botonvolver.getStyleClass().add("boton-material");
        textfieldbusqueda.getStyleClass().add("custom-textfield");
        textoReseñaEnviar.getStyleClass().add("custom-textarea");

        textescribirreseña.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");

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
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                // Double-clicked the selected item, clear the selection
                listviewpeliculas.getSelectionModel().clearSelection();
            } else {
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
        }});

        listviewseries.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                // Double-clicked the selected item, clear the selection
                listviewseries.getSelectionModel().clearSelection();
            } else {
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
        }});

        listviewpeliculas.getSelectionModel().selectFirst();

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
            bototnAñadirReserña.setVisible(true);
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
    public void añadirReseña(ActionEvent actionEvent) {
        panelTransparente.setVisible(true);
        botonCerra.toFront();
        botonminimiza.toFront();

    }

    @FXML
    public void BBDDReseña(ActionEvent actionEvent) {
        Operacion op = new Operacion();
        op.agregarReseña(this,usuarioLogueado);
        System.out.println("Exito");
    }




}

