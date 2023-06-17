package com.watchvibe.visualsVista;


import com.watchvibe.API.MetodosAPI;
import com.watchvibe.adModelo.cruds.CRUDPeliculas;
import com.watchvibe.adModelo.cruds.CRUDSeries;
import com.watchvibe.adModelo.operaciones.Autenticator;
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
    private ImageView fondopanelderechaficha;
    @javafx.fxml.FXML
    private Text textescribirreseña;
    @javafx.fxml.FXML
    private Button botonCancelarInterior;
    @javafx.fxml.FXML
    private Button botonAñadirReseñaInterior1;
    @javafx.fxml.FXML
    private Pane panelTransparenteReseñas;
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
    @javafx.fxml.FXML
    private Label botonCerrar;
    @javafx.fxml.FXML
    private Label botonminimizar;
    @javafx.fxml.FXML
    private Label botonCerrarr1;
    @javafx.fxml.FXML
    private Label botonminimizarr1;
    @javafx.fxml.FXML
    public TextArea textoReseñaEnviarr;

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

    public Usuarios getUsuario() {
        return usuario;
    }

    public Pane getPanelderechaFicha() {
        return panelderechaFicha;
    }

    public void setPanelderechaFicha(Pane panelderechaFicha) {
        this.panelderechaFicha = panelderechaFicha;
    }

    public ImageView getPortada() {
        return portada;
    }

    public void setPortada(ImageView portada) {
        this.portada = portada;
    }

    public Button getAñadirReseña() {
        return AñadirReseña;
    }

    public void setAñadirReseña(Button añadirReseña) {
        AñadirReseña = añadirReseña;
    }

    public Button getVerReseñas() {
        return VerReseñas;
    }

    public void setVerReseñas(Button verReseñas) {
        VerReseñas = verReseñas;
    }

    public Button getAñadirPelicula() {
        return AñadirPelicula;
    }

    public void setAñadirPelicula(Button añadirPelicula) {
        AñadirPelicula = añadirPelicula;
    }

    public Button getVolver() {
        return Volver;
    }

    public void setVolver(Button volver) {
        Volver = volver;
    }

    public Text getTitulotxt() {
        return titulotxt;
    }

    public void setTitulotxt(Text titulotxt) {
        this.titulotxt = titulotxt;
    }

    public Text getAñotxt() {
        return añotxt;
    }

    public void setAñotxt(Text añotxt) {
        this.añotxt = añotxt;
    }

    public Text getSinopsistxt() {
        return sinopsistxt;
    }

    public void setSinopsistxt(Text sinopsistxt) {
        this.sinopsistxt = sinopsistxt;
    }

    public Text getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(Text pathImagen) {
        this.pathImagen = pathImagen;
    }

    public ImageView getFondopanelderechaficha() {
        return fondopanelderechaficha;
    }

    public void setFondopanelderechaficha(ImageView fondopanelderechaficha) {
        this.fondopanelderechaficha = fondopanelderechaficha;
    }

    public Text getTextescribirreseña() {
        return textescribirreseña;
    }

    public void setTextescribirreseña(Text textescribirreseña) {
        this.textescribirreseña = textescribirreseña;
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

    public Pane getPanelTransparenteReseñas() {
        return panelTransparenteReseñas;
    }

    public void setPanelTransparenteReseñas(Pane panelTransparenteReseñas) {
        this.panelTransparenteReseñas = panelTransparenteReseñas;
    }

    public Pane getPanelReseñasPeliculaSerie() {
        return panelReseñasPeliculaSerie;
    }

    public void setPanelReseñasPeliculaSerie(Pane panelReseñasPeliculaSerie) {
        this.panelReseñasPeliculaSerie = panelReseñasPeliculaSerie;
    }

    public Button getBotonMasReseñas() {
        return botonMasReseñas;
    }

    public void setBotonMasReseñas(Button botonMasReseñas) {
        this.botonMasReseñas = botonMasReseñas;
    }

    public Text getTextUser1() {
        return textUser1;
    }

    public void setTextUser1(Text textUser1) {
        this.textUser1 = textUser1;
    }

    public Text getTextReseña1() {
        return textReseña1;
    }

    public void setTextReseña1(Text textReseña1) {
        this.textReseña1 = textReseña1;
    }

    public Text getTextUser2() {
        return textUser2;
    }

    public void setTextUser2(Text textUser2) {
        this.textUser2 = textUser2;
    }

    public Text getTextReseña2() {
        return textReseña2;
    }

    public void setTextReseña2(Text textReseña2) {
        this.textReseña2 = textReseña2;
    }

    public Text getTextUser3() {
        return textUser3;
    }

    public void setTextUser3(Text textUser3) {
        this.textUser3 = textUser3;
    }

    public Text getTextReseña3() {
        return TextReseña3;
    }

    public void setTextReseña3(Text textReseña3) {
        TextReseña3 = textReseña3;
    }

    public Button getBotonAtras() {
        return botonAtras;
    }

    public void setBotonAtras(Button botonAtras) {
        this.botonAtras = botonAtras;
    }

    public Label getBotonCerrar() {
        return botonCerrar;
    }

    public void setBotonCerrar(Label botonCerrar) {
        this.botonCerrar = botonCerrar;
    }

    public Label getBotonminimizar() {
        return botonminimizar;
    }

    public void setBotonminimizar(Label botonminimizar) {
        this.botonminimizar = botonminimizar;
    }

    public Label getBotonCerrarr1() {
        return botonCerrarr1;
    }

    public void setBotonCerrarr1(Label botonCerrarr1) {
        this.botonCerrarr1 = botonCerrarr1;
    }

    public Label getBotonminimizarr1() {
        return botonminimizarr1;
    }

    public void setBotonminimizarr1(Label botonminimizarr1) {
        this.botonminimizarr1 = botonminimizarr1;
    }

    public TextArea getTextoReseñaEnviarr() {
        return textoReseñaEnviarr;
    }

    public void setTextoReseñaEnviarr(TextArea textoReseñaEnviarr) {
        this.textoReseñaEnviarr = textoReseñaEnviarr;
    }

    public Pane getPanelizq() {
        return panelizq;
    }

    public void setPanelizq(Pane panelizq) {
        this.panelizq = panelizq;
    }

    public ImageView getFondopanelizq() {
        return fondopanelizq;
    }

    public void setFondopanelizq(ImageView fondopanelizq) {
        this.fondopanelizq = fondopanelizq;
    }

    public ImageView getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(ImageView logotipo) {
        this.logotipo = logotipo;
    }

    public ImageView getIconouser() {
        return iconouser;
    }

    public void setIconouser(ImageView iconouser) {
        this.iconouser = iconouser;
    }

    public ImageView getIconoAmigos() {
        return IconoAmigos;
    }

    public void setIconoAmigos(ImageView iconoAmigos) {
        IconoAmigos = iconoAmigos;
    }

    public Button getBotonAmigos() {
        return botonAmigos;
    }

    public void setBotonAmigos(Button botonAmigos) {
        this.botonAmigos = botonAmigos;
    }

    public ImageView getIconoPeliculas() {
        return iconoPeliculas;
    }

    public void setIconoPeliculas(ImageView iconoPeliculas) {
        this.iconoPeliculas = iconoPeliculas;
    }

    public Button getBotonPeliculas() {
        return BotonPeliculas;
    }

    public void setBotonPeliculas(Button botonPeliculas) {
        BotonPeliculas = botonPeliculas;
    }

    public Pane getPanelderecha() {
        return panelderecha;
    }

    public void setPanelderecha(Pane panelderecha) {
        this.panelderecha = panelderecha;
    }

    public ImageView getFondopanelderecha() {
        return fondopanelderecha;
    }

    public void setFondopanelderecha(ImageView fondopanelderecha) {
        this.fondopanelderecha = fondopanelderecha;
    }

    public ImageView getPelicula1() {
        return pelicula1;
    }

    public void setPelicula1(ImageView pelicula1) {
        this.pelicula1 = pelicula1;
    }

    public ImageView getPelicula2() {
        return pelicula2;
    }

    public void setPelicula2(ImageView pelicula2) {
        this.pelicula2 = pelicula2;
    }

    public ImageView getPelicula3() {
        return pelicula3;
    }

    public void setPelicula3(ImageView pelicula3) {
        this.pelicula3 = pelicula3;
    }

    public ImageView getPelicula4() {
        return pelicula4;
    }

    public void setPelicula4(ImageView pelicula4) {
        this.pelicula4 = pelicula4;
    }

    public ImageView getBotonmaspeliculas() {
        return botonmaspeliculas;
    }

    public void setBotonmaspeliculas(ImageView botonmaspeliculas) {
        this.botonmaspeliculas = botonmaspeliculas;
    }

    public ImageView getBotonmasseries() {
        return botonmasseries;
    }

    public void setBotonmasseries(ImageView botonmasseries) {
        this.botonmasseries = botonmasseries;
    }

    public ImageView getSerie1() {
        return serie1;
    }

    public void setSerie1(ImageView serie1) {
        this.serie1 = serie1;
    }

    public ImageView getSerie2() {
        return serie2;
    }

    public void setSerie2(ImageView serie2) {
        this.serie2 = serie2;
    }

    public ImageView getSerie3() {
        return serie3;
    }

    public void setSerie3(ImageView serie3) {
        this.serie3 = serie3;
    }

    public ImageView getSerie4() {
        return serie4;
    }

    public void setSerie4(ImageView serie4) {
        this.serie4 = serie4;
    }

    public Button getBotonBusqueda() {
        return botonBusqueda;
    }

    public void setBotonBusqueda(Button botonBusqueda) {
        this.botonBusqueda = botonBusqueda;
    }

    public Text getPeliculastendenciatext() {
        return peliculastendenciatext;
    }

    public void setPeliculastendenciatext(Text peliculastendenciatext) {
        this.peliculastendenciatext = peliculastendenciatext;
    }

    public Text getSeriestendenciatext() {
        return seriestendenciatext;
    }

    public void setSeriestendenciatext(Text seriestendenciatext) {
        this.seriestendenciatext = seriestendenciatext;
    }

    public TextField getTextFieldBusqueda() {
        return textFieldBusqueda;
    }

    public void setTextFieldBusqueda(TextField textFieldBusqueda) {
        this.textFieldBusqueda = textFieldBusqueda;
    }

    public Operacion getOp() {
        return op;
    }

    public void setOp(Operacion op) {
        this.op = op;
    }

    public Button getBotonSeries() {
        return BotonSeries;
    }

    public void setBotonSeries(Button botonSeries) {
        BotonSeries = botonSeries;
    }

    public Text getNombreusuariologueado() {
        return nombreusuariologueado;
    }

    public void setNombreusuariologueado(Text nombreusuariologueado) {
        this.nombreusuariologueado = nombreusuariologueado;
    }

    public Text getEmailusuariologueado() {
        return emailusuariologueado;
    }

    public void setEmailusuariologueado(Text emailusuariologueado) {
        this.emailusuariologueado = emailusuariologueado;
    }

    public Text getCerrarsesiontxt() {
        return cerrarsesiontxt;
    }

    public void setCerrarsesiontxt(Text cerrarsesiontxt) {
        this.cerrarsesiontxt = cerrarsesiontxt;
    }

    public Peliculas getPeliculaSeleccionada() {
        return peliculaSeleccionada;
    }

    public void setPeliculaSeleccionada(Peliculas peliculaSeleccionada) {
        this.peliculaSeleccionada = peliculaSeleccionada;
    }

    public Series getSerieSeleccionada() {
        return serieSeleccionada;
    }

    public void setSerieSeleccionada(Series serieSeleccionada) {
        this.serieSeleccionada = serieSeleccionada;
    }

    public Peliculas peliculaSeleccionada;
    public Series serieSeleccionada;

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
        panelTransparenteReseñas.setVisible(true);
        //botonCerra.toFront();
        //botonminimiza.toFront();
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
        usuarioLogueado = Autenticator.getUsuarioLogueado();
        System.out.println(usuarioLogueado.toString());
        Operacion op = new Operacion();
        op.AgregarCatalogo(this,usuarioLogueado);
    }

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) {
        panelderechaFicha.setVisible(false);
        panelderecha.setVisible(true);
    }

    @javafx.fxml.FXML
    public void BBDDReseña(ActionEvent actionEvent) {
        Operacion op = new Operacion();
        op.agregarReseñaMenu(this, usuarioLogueado);
        System.out.println("Exito");
    }

    @javafx.fxml.FXML
    public void volverReseñasTotales(ActionEvent actionEvent) {
        panelReseñasPeliculaSerie.setVisible(false);
    }
}
