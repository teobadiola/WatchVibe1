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
import java.util.ArrayList;
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
    @FXML
    private Pane panelReseñasPeliculaSerie;
    @FXML
    private Button botonMasReseñas;
    @FXML
    private Text textUser1;
    @FXML
    private Text textReseña1;
    @FXML
    private Text textUser2;
    @FXML
    private Text textReseña2;
    @FXML
    private Text textUser3;
    @FXML
    private Text TextReseña3;
    @FXML
    private Button botonAtras;

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


        Image imagenfondo = new Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/FONDO_NEGRO_CON_BLOQUES.png"));
        fondoizq.setImage(imagenfondo);

        bototnAñadirReserña.setVisible(true);
        panelTransparente.setVisible(false);
        panelReseñasPeliculaSerie.setVisible(false);
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
                "-fx-border-color: white; " + " -fx-border-size:12; " + "-fx-color: white; ");

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

        /*
        Imagenes para los botones
         */
        Image imagen1 = new Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/ICONO_REVIEW.png"));

        // Crear un ImageView con la imagen
        ImageView imageView = new ImageView(imagen1);

        // Establecer el ImageView como contenido gráfico del botón
        bototnVerReseñas.setGraphic(imageView);

        Image imagen2 = new Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/ICONO_ESCRIBIR_REVIEW.png"));

        // Crear un ImageView con la imagen
        ImageView imageView1 = new ImageView(imagen2);

        // Establecer el ImageView como contenido gráfico del botón
        bototnAñadirReserña.setGraphic(imageView1);

        Image imagen3 = new Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/ICONO_AÑADIRR.png"));

        // Crear un ImageView con la imagen
        ImageView imageView2 = new ImageView(imagen3);

        // Establecer el ImageView como contenido gráfico del botón
        bototnAñadir.setGraphic(imageView2);

        Image imagen4 = new Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/FLECHA.png"));

        // Crear un ImageView con la imagen
        ImageView imageView3 = new ImageView(imagen4);

        // Establecer el ImageView como contenido gráfico del botón
        botonvolver.setGraphic(imageView3);


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
        listviewpeliculas.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
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

        listviewseries.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
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
            }
        });

        listviewpeliculas.getSelectionModel().selectFirst();

        Peliculas pelicula = listviewpeliculas.getSelectionModel().getSelectedItem();
        if (pelicula != null) {
            titulotxt.setText(pelicula.getTitulo());
            aniotxt.setText("" + pelicula.getAnio());
            String sinopsis = pelicula.getSinopsis();
            if (sinopsis.length() > 200) {
                sinopsis = sinopsis.substring(0, 200) + "...";
            }
            sionpsistxt.setText(sinopsis);
            pathimagentxt.setText(pelicula.getFotodePortada());
            portada.setImage(new Image(pelicula.getFotodePortada()));
        }

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
        // Obtener el elemento seleccionado en el ListView de películas
        Object elementoPeliculaSeleccionado = listviewpeliculas.getSelectionModel().getSelectedItem();

        // Obtener el elemento seleccionado en el ListView de series
        Object elementoSerieSeleccionado = listviewseries.getSelectionModel().getSelectedItem();

        Operacion operacion = new Operacion();

        if (elementoPeliculaSeleccionado instanceof Peliculas) {
            Peliculas peliculaSeleccionada = (Peliculas) elementoPeliculaSeleccionado;
            operacion.agregarPeliculaSerie(this, usuarioLogueado, true);
        } else if (elementoSerieSeleccionado instanceof Series) {
            Series serieSeleccionada = (Series) elementoSerieSeleccionado;
            operacion.agregarPeliculaSerie(this, usuarioLogueado, false);
        }

    }


    @javafx.fxml.FXML
    public void metodoBuscarPeliculasySeries(ActionEvent actionEvent) {
        List<Series> series = MetodosAPI.buscarSeries("c5d32ee544149dd1396e8996324d5da5", textfieldbusqueda.getText());
        List<Peliculas> peliculas = MetodosAPI.buscarPeliculas("c5d32ee544149dd1396e8996324d5da5", textfieldbusqueda.getText());

        if (series.isEmpty() && peliculas.isEmpty()) {
            System.out.println("No hay resultados para esta búsqueda");
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

            listviewpeliculas.getSelectionModel().selectFirst();

            Peliculas pelicula = listviewpeliculas.getSelectionModel().getSelectedItem();
            if (pelicula != null) {
                titulotxt.setText(pelicula.getTitulo());
                aniotxt.setText("" + pelicula.getAnio());
                String sinopsis = pelicula.getSinopsis();
                if (sinopsis.length() > 200) {
                    sinopsis = sinopsis.substring(0, 200) + "...";
                }
                sionpsistxt.setText(sinopsis);
                pathimagentxt.setText(pelicula.getFotodePortada());
                portada.setImage(new Image(pelicula.getFotodePortada()));
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
        op.agregarReseña(this, usuarioLogueado);
        System.out.println("Exito");
    }

    @FXML
    public void MasReseñas(ActionEvent actionEvent) {

    }

    @FXML
    public void verValoraciones(ActionEvent actionEvent) {
        Operacion operacion = new Operacion();

        Object seleccionPeliculas = listviewpeliculas.getSelectionModel().getSelectedItem();
        Object seleccionSeries = listviewseries.getSelectionModel().getSelectedItem();

        if (seleccionPeliculas instanceof Peliculas) {
            Peliculas peliculaSeleccionada = (Peliculas) seleccionPeliculas;
            panelReseñasPeliculaSerie.setVisible(true);
            List<Comentarios> comentariosPelicula = operacion.obtenerComentariosPeliculas(this, peliculaSeleccionada);

            System.out.println(comentariosPelicula.size());


            if (comentariosPelicula.size() >= 1) {
                // Obtener los primeros tres comentarios o menos si no hay suficientes
                int numComentarios = Math.min(comentariosPelicula.size(), 3);
                System.out.println("NUMcOMENTS: "+numComentarios);

                // Recorrer los comentarios
                for (int i = 0; i < numComentarios; i++) {
                    Comentarios comentario = comentariosPelicula.get(i);
                    Usuarios usuario = comentario.getIDUsuario();
                    String texto = comentario.getContenidodelcomentario();

                    // Establecer los valores en los campos correspondientes
                    switch (i) {
                        case 0:
                            textUser1.setText(usuario.getNombre());
                            textReseña1.setText(texto);
                            break;
                        case 1:
                            textUser2.setText(usuario.getNombre());
                            textReseña2.setText(texto);
                            break;
                        case 2:
                            textUser3.setText(usuario.getNombre());
                            TextReseña3.setText(texto);
                            break;
                    }
                }
            }

        } else if (seleccionSeries instanceof Series) {
            Series serieSeleccionada = (Series) seleccionSeries;
            panelReseñasPeliculaSerie.setVisible(true);
            List<Comentarios> comentariosSeries = operacion.obtenerComentariosSeries(this, serieSeleccionada);
            System.out.println(comentariosSeries.size());

            if (comentariosSeries.size() > 1) {
                // Obtener los primeros tres comentarios o menos si no hay suficientes
                int numComentarios = Math.min(comentariosSeries.size(), 3);
                System.out.println("numComents series: "+numComentarios);

                // Recorrer los comentarios
                for (int i = 0; i < numComentarios; i++) {
                    Comentarios comentario = comentariosSeries.get(i);
                    Usuarios usuario = comentario.getIDUsuario();
                    String texto = comentario.getContenidodelcomentario();

                    // Establecer los valores en los campos correspondientes
                    switch (i) {
                        case 0:
                            System.out.println(usuario.getNombre());
                            textUser1.setText(usuario.getNombre());
                            System.out.println(texto);
                            textReseña1.setText(texto);
                            break;
                        case 1:
                            textUser2.setText(usuario.getNombre());
                            textReseña2.setText(texto);
                            break;
                        case 2:
                            textUser3.setText(usuario.getNombre());
                            TextReseña3.setText(texto);
                            break;
                    }
                }
            }
        } else {
            System.out.println("Error");
        }
    }

    @FXML
    public void atras(ActionEvent actionEvent) {
        panelReseñasPeliculaSerie.setVisible(false);
    }

}

