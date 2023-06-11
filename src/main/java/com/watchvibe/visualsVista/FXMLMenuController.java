package com.watchvibe.visualsVista;


import com.watchvibe.API.MetodosAPI;
import com.watchvibe.adModelo.cruds.CRUDPeliculas;
import com.watchvibe.adModelo.cruds.CRUDSeries;
import com.watchvibe.adModelo.operaciones.Operacion;
import com.watchvibe.adModelo.tablas.Comentarios;
import com.watchvibe.adModelo.tablas.Peliculas;
import com.watchvibe.adModelo.tablas.Series;
import com.watchvibe.adModelo.tablas.Usuarios;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FXMLMenuController {

    private Usuarios usuarioLogueado;
    private Usuarios usuario;
    @javafx.fxml.FXML
    private Pane panelderechaFicha;
    @javafx.fxml.FXML
    private TextField textFieldBusqueda1;
    @javafx.fxml.FXML
    private ImageView portada;
    @javafx.fxml.FXML
    private Button AñadirReseña;
    @javafx.fxml.FXML
    private Button VerReseñas;
    @javafx.fxml.FXML
    private Button AñadirPelicula;
    @javafx.fxml.FXML
    private Button Volver;
    @javafx.fxml.FXML
    private Text titulotxt;
    @javafx.fxml.FXML
    private Text añotxt;
    @javafx.fxml.FXML
    private Text sinopsistxt;
    @javafx.fxml.FXML
    private Text pathImagen;
    @javafx.fxml.FXML
    private Button botonBusquedaFicha;
    @javafx.fxml.FXML
    private ImageView fondopanelderechaficha;
    @javafx.fxml.FXML
    private Text textescribirreseña;
    @javafx.fxml.FXML
    private Button botonCancelarInterior;
    @javafx.fxml.FXML
    private Button botonAñadirReseñaInterior1;
    @javafx.fxml.FXML
    private Label botonCerrar;
    @javafx.fxml.FXML
    private Label botonminimizar;
    @javafx.fxml.FXML
    private Label botonCerra1;
    @javafx.fxml.FXML
    private Label botonminimiza1;
    @javafx.fxml.FXML
    private Pane panelTransparenteReseñas;
    @javafx.fxml.FXML
    private TextArea textoReseñaEnvia;
    @javafx.fxml.FXML
    private Pane panelReseñasPeliculaSerie;
    @javafx.fxml.FXML
    private Button botonMasReseñas;
    @javafx.fxml.FXML
    private Text textUser1;
    @javafx.fxml.FXML
    private Text textReseña1;
    @javafx.fxml.FXML
    private Text textUser2;
    @javafx.fxml.FXML
    private Text textReseña2;
    @javafx.fxml.FXML
    private Text textUser3;
    @javafx.fxml.FXML
    private Text TextReseña3;
    @javafx.fxml.FXML
    private Button botonAtras;

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
        nombreusuariologueado.setText(usuario.getNombre());
        emailusuariologueado.setText(usuario.getCorreoelectronico());
    }

    @javafx.fxml.FXML
    private Pane panelizq;
    @javafx.fxml.FXML
    private ImageView fondopanelizq;
    @javafx.fxml.FXML
    private ImageView logotipo;
    @javafx.fxml.FXML
    private ImageView iconouser;
    @javafx.fxml.FXML
    private ImageView IconoAmigos;
    @javafx.fxml.FXML
    private Button botonAmigos;
    @javafx.fxml.FXML
    private ImageView iconoPeliculas;
    @javafx.fxml.FXML
    private Button BotonPeliculas;
    @javafx.fxml.FXML
    private Pane panelderecha;
    @javafx.fxml.FXML
    private ImageView fondopanelderecha;
    @javafx.fxml.FXML
    private ImageView pelicula1;
    @javafx.fxml.FXML
    private ImageView pelicula2;
    @javafx.fxml.FXML
    private ImageView pelicula3;
    @javafx.fxml.FXML
    private ImageView pelicula4;
    @javafx.fxml.FXML
    private ImageView botonmaspeliculas;
    @javafx.fxml.FXML
    private ImageView botonmasseries;
    @javafx.fxml.FXML
    private ImageView serie1;
    @javafx.fxml.FXML
    private ImageView serie2;
    @javafx.fxml.FXML
    private ImageView serie3;
    @javafx.fxml.FXML
    private ImageView serie4;
    @javafx.fxml.FXML
    private Button botonBusqueda;
    @javafx.fxml.FXML
    private Text peliculastendenciatext;
    @javafx.fxml.FXML
    private Text seriestendenciatext;
    @javafx.fxml.FXML
    public TextField textFieldBusqueda;

    Operacion op = new Operacion();
    @javafx.fxml.FXML
    private Button BotonSeries;
    @javafx.fxml.FXML
    private Text nombreusuariologueado;
    @javafx.fxml.FXML
    private Text emailusuariologueado;
    @javafx.fxml.FXML
    private Text cerrarsesiontxt;

    private Peliculas peliculaSeleccionada;
    private Series serieSeleccionada;

    public void initialize() {

        panelderechaFicha.setVisible(false);
        panelTransparenteReseñas.setVisible(false);
        panelReseñasPeliculaSerie.setVisible(false);

        BotonSeries.getStyleClass().add("boton-material");
        botonAmigos.getStyleClass().add("boton-material");

        AñadirReseña.getStyleClass().add("boton-material");
        VerReseñas.getStyleClass().add("boton-material");;
        AñadirPelicula.getStyleClass().add("boton-material");;
        Volver.getStyleClass().add("boton-material");;

        BotonPeliculas.getStyleClass().add("boton-material");
        botonBusqueda.getStyleClass().add("boton-material");
        textFieldBusqueda.getStyleClass().add("custom-textfield");

        titulotxt.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");


        añotxt.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");


        sinopsistxt.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");


        nombreusuariologueado.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");

        emailusuariologueado.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");

        cerrarsesiontxt.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");


        peliculastendenciatext.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");

        seriestendenciatext.setStyle("-font-family: 'Plus Jakarta Sans', sans-serif;" +
                "-fx-font-size: 0.875em; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 0 0 1 0; " +
                "-fx-border-color: white; "+ " -fx-border-size:12; " + "-fx-color: white; ");



        Image IMAGENFONDOIZ = new Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/DEGRADADO_AZUL.png"));
        fondopanelderecha.setImage(IMAGENFONDOIZ);
        fondopanelderechaficha.setImage(IMAGENFONDOIZ);
        fondopanelderecha.toBack();

        Image IMAGENFONDOdr = new Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/naranja.png"));
        fondopanelizq.setImage(IMAGENFONDOdr);


        Image logotip = new Image(getClass().getResourceAsStream("/com/watchvibe/recursos_fondos/LOGO_COLOR.png"));
        logotipo.setImage(logotip);

        Image iconouser1 = new Image(getClass().getResourceAsStream("/com/watchvibe/iconos_pequeños/usuario2.png"));
        iconouser.setImage(iconouser1);

        Image iconoPeliculas1 = new Image(getClass().getResourceAsStream("/com/watchvibe/iconos_pequeños/busqueda_peliculas.png"));
        iconoPeliculas.setImage(iconoPeliculas1);


        Image iconoAmigos1 = new Image(getClass().getResourceAsStream("/com/watchvibe/iconos_pequeños/Amigos.png"));
        IconoAmigos.setImage(iconoAmigos1);

        ImageView[] imageViewspelis = {
                pelicula1,
                pelicula2,
                pelicula3,
                pelicula4
        };

        ImageView[] imageViewsSeries = {
                serie1,
                serie2,
                serie3,
                serie4
        };

        ArrayList<String> imagePathspelis = op.obtenerPathsPeliculasAleatorios(4);
        System.out.println(imagePathspelis.size());

        ArrayList<String> imagePathsSeries = op.obtenerPathsSeriesAleatorios(4);
        System.out.println(imagePathsSeries.size());

        op.agregarURLsAImageViewsPeliculas(imagePathspelis, imageViewspelis);
        op.agregarURLsAImageViewsSeries(imagePathsSeries, imageViewsSeries);

        pelicula1.setOnMouseClicked(this::onMouseClicked);
        pelicula2.setOnMouseClicked(this::onMouseClicked);
        pelicula3.setOnMouseClicked(this::onMouseClicked);
        pelicula4.setOnMouseClicked(this::onMouseClicked);

        serie1.setOnMouseClicked(this::onMouseClicked);
        serie2.setOnMouseClicked(this::onMouseClicked);
        serie3.setOnMouseClicked(this::onMouseClicked);
        serie4.setOnMouseClicked(this::onMouseClicked);

    }

    @javafx.fxml.FXML
    public void onHandleAmigos(ActionEvent actionEvent) {
        /*
        try {
            // Cargar el archivo FXML "perfil.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLAmigos.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con el archivo FXML cargado
            Scene scene = new Scene(root);

            // Obtener la ventana actual a través del evento
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Establecer la escena en la ventana
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

    }


    @javafx.fxml.FXML
    public void onMouseClicked(MouseEvent event) {

        panelderecha.setVisible(false);
        CRUDPeliculas cp = new CRUDPeliculas();
        CRUDSeries cs = new CRUDSeries();

        ImageView imageView = (ImageView) event.getSource();
        String imagePath = imageView.getImage().getUrl();

        // Comprobar si es una película
        peliculaSeleccionada = cp.getPeliculaPorPath(imagePath);
        if (peliculaSeleccionada != null) {
            // Actualizar los elementos en el panel de películas
            titulotxt.setText(peliculaSeleccionada.getTitulo());
            añotxt.setText("" + peliculaSeleccionada.getAnio());
            sinopsistxt.setText(peliculaSeleccionada.getSinopsis());
            portada.setImage(new Image(imagePath));
            // Actualiza otros elementos según los datos de la película seleccionada

            // Mostrar el panel de películas
            panelderechaFicha.setVisible(true);
        } else {
            // Comprobar si es una serie
            serieSeleccionada = cs.getSeriesPath(imagePath);
            if (serieSeleccionada != null) {
                // Actualizar los elementos en el panel de series
                titulotxt.setText(serieSeleccionada.getTitulo());
                añotxt.setText("" + serieSeleccionada.getAnio());
                sinopsistxt.setText(serieSeleccionada.getSinopsis());
                portada.setImage(new Image(imagePath));
                // Mostrar el panel de series
                panelderechaFicha.setVisible(true);
            } else {
                System.out.println("No se encontró la película ni la serie.");
            }
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

    @javafx.fxml.FXML
    public void onClicCerrar(Event event) {
    }

    @javafx.fxml.FXML
    public void onClicMinimizar(Event event) {
    }

    @javafx.fxml.FXML
    public void metodoBuscarPeliculasySeries(ActionEvent actionEvent) {
        List<Series> series = MetodosAPI.buscarSeries("c5d32ee544149dd1396e8996324d5da5", textFieldBusqueda.getText());
        List<Peliculas> peliculas = MetodosAPI.buscarPeliculas("c5d32ee544149dd1396e8996324d5da5", textFieldBusqueda.getText());

        if (series.isEmpty() && peliculas.isEmpty()) {
            System.out.println("No hay resultados para esta búsqueda");
            return; // No cargar la nueva escena si ambas listas están vacías
        } else {
            try {
                // Cargar el archivo FXML "perfil.fxml"
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/watchvibe/ProyectoFinal/FXMLBuscar.fxml"));
                Parent root = loader.load();

                // Obtener la instancia del controlador de la nueva escena
                FXMLBuscarController buscarController = loader.getController();
                buscarController.setUsuarioLogueado(usuario);

                // Pasar los ArrayList a la instancia del controlador
                buscarController.setSeries(series);
                buscarController.setPeliculas(peliculas);

                // Crear una nueva escena con el archivo FXML cargado
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("/com/watchvibe/css/materialbotonesestilo.css").toExternalForm());

                // Obtener la ventana actual a través del evento
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                // Establecer la escena en la ventana
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @javafx.fxml.FXML
    public void masPeliculas(Event event) {
        ImageView[] imageViewspelis = {
                pelicula1,
                pelicula2,
                pelicula3,
                pelicula4
        };

        ArrayList<String> imagePathspelis = op.obtenerPathsPeliculasAleatorios(4);
        System.out.println(imagePathspelis.size());

        op.agregarURLsAImageViewsPeliculas(imagePathspelis, imageViewspelis);
    }

    @javafx.fxml.FXML
    public void masSeries(Event event) {
        ImageView[] imageViewsSeries = {
                serie1,
                serie2,
                serie3,
                serie4
        };

        ArrayList<String> imagePathsSeries = op.obtenerPathsSeriesAleatorios(4);
        System.out.println(imagePathsSeries.size());

        op.agregarURLsAImageViewsSeries(imagePathsSeries, imageViewsSeries);

    }

    @javafx.fxml.FXML
    public void AñadirReseñas(ActionEvent actionEvent) {
        /*
        Operacion op = new Operacion();
        op.agregarReseña(this, usuarioLogueado);
        System.out.println("Exito");
         */
    }

    @javafx.fxml.FXML
    public void verReseñasTotal(ActionEvent actionEvent) {
        panelTransparenteReseñas.setVisible(false);

        Operacion operacion = new Operacion();

        if (peliculaSeleccionada != null) {
            panelReseñasPeliculaSerie.setVisible(true);
            List<Comentarios> comentariosPelicula = operacion.obtenerComentariosPeliculas(this, peliculaSeleccionada);

            if (comentariosPelicula.size() >= 1) {
                // Obtener los primeros tres comentarios o menos si no hay suficientes
                int numComentarios = Math.min(comentariosPelicula.size(), 3);

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
            } else {
                // No hay comentarios
                // Limpiar los campos correspondientes
                textUser1.setText("-");
                textReseña1.setText("-");
                textUser2.setText("-");
                textReseña2.setText("-");
                textUser3.setText("-");
                TextReseña3.setText("-");
            }
        } else if (serieSeleccionada != null) {
            panelReseñasPeliculaSerie.setVisible(true);

            List<Comentarios> comentariosSeries = operacion.obtenerComentariosSeries(this,serieSeleccionada);

            if (comentariosSeries.size() >= 1) {
                // Obtener los primeros tres comentarios o menos si no hay suficientes
                int numComentarios = Math.min(comentariosSeries.size(), 3);

                // Recorrer los comentarios
                for (int i = 0; i < numComentarios; i++) {
                    Comentarios comentario = comentariosSeries.get(i);
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
            } else {
                textUser1.setText("");
                textReseña1.setText("");
                textUser2.setText("");
                textReseña2.setText("");
                textUser3.setText("");
                TextReseña3.setText("");
            }
        } else {
            System.out.println("Error");
        }
    }


    @javafx.fxml.FXML
    public void añadirpelicula(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) {
        panelderechaFicha.setVisible(false);
        panelderecha.setVisible(true);
    }

    @javafx.fxml.FXML
    public void BBDDReseña(ActionEvent actionEvent) {
    }
}
