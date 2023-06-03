package com.watchvibe.visualsVista;


import com.watchvibe.API.MetodosAPI;
import com.watchvibe.adModelo.operaciones.Operacion;
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

    private Usuarios usuario;

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
    @javafx.fxml.FXML
    private Label botonCerra;
    @javafx.fxml.FXML
    private Label botonminimiza;

    public void initialize() {

        BotonSeries.getStyleClass().add("boton-material");
        botonAmigos.getStyleClass().add("boton-material");
        BotonPeliculas.getStyleClass().add("boton-material");
        botonBusqueda.getStyleClass().add("boton-material");
        textFieldBusqueda.getStyleClass().add("custom-textfield");

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

    }

    @Deprecated
    public void onHandlPerfil(ActionEvent actionEvent) {
        try {
            // Cargar el archivo FXML "perfil.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPerfil.fxml"));
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

    @Deprecated
    public void onHandleAjustes(ActionEvent actionEvent) {
               /*
        try {
            // Cargar el archivo FXML "perfil.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLAjustes.fxml"));
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
    public void onHandleCatalogo(ActionEvent actionEvent) {
               /*
        try {
            // Cargar el archivo FXML "perfil.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLCatalogo.fxml"));
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
    public void onMouseClicked(Event event) {
        try {
            // Cargar el archivo FXML "perfil.fxml"
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFicha.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con el archivo FXML cargado
            Scene scene = new Scene(root);

            // Obtener la ventana actual a través del evento
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Establecer la escena en la ventana
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
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
}
