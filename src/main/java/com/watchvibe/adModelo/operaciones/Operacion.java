package com.watchvibe.adModelo.operaciones;

import com.watchvibe.adModelo.cruds.CRUDUsuarios;
import com.watchvibe.adModelo.tablas.CatalogoPeliculas;
import com.watchvibe.adModelo.tablas.CatalogoSeries;
import com.watchvibe.adModelo.tablas.Usuarios;
import com.watchvibe.visualsVista.FXMLRegistroController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.IOException;
import java.util.Date;

public class Operacion {

    public int procesarRegistro(FXMLRegistroController registroc) {
        EntityManager em = Conexion.conecta();
        CRUDUsuarios cr = new CRUDUsuarios();
        try {
            em.getTransaction().begin();
            Usuarios user = new Usuarios();
            user.setNombre(registroc.textfieldusuario.getText());
            user.setContrasena(registroc.textfieldcontrasena.getText());
            user.setCorreoelectronico(registroc.textfieldemail.getText());
            Date fechaActual = new Date();
            user.setFechaderegistro(fechaActual);
            em.persist(user);
            em.getTransaction().commit(); // Confirmar la transacción
            cr.createUsuario(user);
            System.out.println(user.toString());


            // Crear el objeto Catalogo_Peliculas
            CatalogoPeliculas cp = new CatalogoPeliculas();
            cp.setIDusuario(user); // Asignar el ID del usuario
            em.persist(cp);

            // Crear el objeto Catalogo_Series
            CatalogoSeries cs = new CatalogoSeries();
            cs.setIDusuario(user); // Asignar el ID del usuario
            em.persist(cs);



        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            System.err.println("ERROR al hacer el registro. " + ex.getLocalizedMessage());
            return 0;
        } catch (NullPointerException ex) {
            System.out.println("Error null" + ex.getMessage());
            return 0;
        } catch (IllegalArgumentException ex) {
            System.out.println("Error en argumento" + ex.getMessage());
            return 0;
        }
        Conexion.desconecta(em);
        return 1;

    }

    public int cambiarEscena(MouseEvent mouseEvent, String formatEscena, Class<?> clazz) {
        int valor = 0;
        try {

            // Cargar el archivo FXML "perfil.fxml"
            FXMLLoader loader = new FXMLLoader(clazz.getResource(formatEscena));
            Parent root = loader.load();

            // Crear una nueva escena con el archivo FXML cargado
            Scene scene = new Scene(root);

            // Obtener la ventana actual a través del evento
            scene.getStylesheets().add(clazz.getResource("/com/watchvibe/css/materialbotonesestilo.css").toExternalForm());
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

            javafx.scene.image.Image backg = new javafx.scene.image.Image(clazz.getResourceAsStream("/com/watchvibe/recursos_fondos/ISOTIPO_NEGRO.png"));

            // Establecer la escena en la ventana
            stage.setScene(scene);
            stage.show();
            valor = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valor;
    }

    public int cambiarEscena(ActionEvent actionEvent, String formatEscena, Class<?> clazz) {
        int valor = 0;
        try {

            // Cargar el archivo FXML "perfil.fxml"
            FXMLLoader loader = new FXMLLoader(clazz.getResource(formatEscena));
            Parent root = loader.load();

            // Crear una nueva escena con el archivo FXML cargado
            Scene scene = new Scene(root);

            // Obtener la ventana actual a través del evento
            scene.getStylesheets().add(clazz.getResource("/com/watchvibe/css/materialbotonesestilo.css").toExternalForm());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            javafx.scene.image.Image backg = new javafx.scene.image.Image(clazz.getResourceAsStream("/com/watchvibe/recursos_fondos/ISOTIPO_NEGRO.png"));

            // Establecer la escena en la ventana
            stage.setScene(scene);
            stage.show();
            valor = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valor;
    }


}
