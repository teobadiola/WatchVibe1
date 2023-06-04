package com.watchvibe.adModelo.operaciones;

import com.watchvibe.adModelo.cruds.CRUDUsuarios;
import com.watchvibe.adModelo.tablas.*;
import com.watchvibe.visualsVista.FXMLBuscarController;
import com.watchvibe.visualsVista.FXMLFichaController;
import com.watchvibe.visualsVista.FXMLRegistroController;
import com.welag.ad.tablas.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.persistence.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Usuarios user = new Usuarios();
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

    public void agregarPelicula(FXMLBuscarController busqcontr, Usuarios usuario) {
        System.out.println("ID "+usuario.getIDUsuario());
        // Establecer la conexión a la base de datos usando EntityManager
        EntityManager em = Conexion.conecta();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            // Verificar si el usuario tiene un catálogo de películas
            Query consultaCatalogo = em.createQuery("SELECT cp FROM CatalogoPeliculas cp WHERE cp.iDusuario = :usuario");
            consultaCatalogo.setParameter("usuario", usuario);
            List<CatalogoPeliculas> catalogoPeliculas = consultaCatalogo.getResultList();

            // Si el catálogo de películas del usuario no existe, se crea
            if (catalogoPeliculas.isEmpty()) {
                CatalogoPeliculas nuevoCatalogo = new CatalogoPeliculas();
                nuevoCatalogo.setIDusuario(usuario);
                em.persist(nuevoCatalogo);
            }

            // Verificar si la película ya existe
            String tituloPelicula = busqcontr.getTitulotxt().getText();
            System.out.println(tituloPelicula);
            Query consultaPelicula = em.createQuery("SELECT p FROM Peliculas p WHERE p.titulo = :titulo");
            consultaPelicula.setParameter("titulo", tituloPelicula);
            List<Peliculas> peliculasExistentes = consultaPelicula.getResultList();
            if (!peliculasExistentes.isEmpty()) {
                System.out.println("La película ya existe en la base de datos.");

                // Agregar la película existente al catálogo del usuario
                Peliculas peliculaExistente = peliculasExistentes.get(0); // Obtener la primera película coincidente
                CatalogoPeliculas cp = new CatalogoPeliculas();
                cp.setIDusuario(usuario);
                cp.setIDpelicula(peliculaExistente);
                cp.setFechadeanadido(new Date());
                em.persist(cp);
            } else {
                // La película no existe, se procede a agregarla

                // Paso 1: Insertar la película en la tabla "peliculas"
                Peliculas pelicula = new Peliculas();
                pelicula.setTitulo(tituloPelicula);
                pelicula.setAnio(Integer.parseInt(busqcontr.getAniotxt().getText()));
                pelicula.setSinopsis(busqcontr.getSionpsistxt().getText());
                pelicula.setFotodePortada(busqcontr.getPathimagentxt().getText());
                em.persist(pelicula);

                // Paso 2: Insertar la película en el catálogo de películas del usuario
                CatalogoPeliculas cp = new CatalogoPeliculas();
                cp.setIDusuario(usuario);
                cp.setIDpelicula(pelicula);
                cp.setFechadeanadido(new Date());
                em.persist(cp);
            }

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, hacer rollback de la transacción
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Cerrar EntityManager
            em.close();
        }
    }


    public void agregarSeries(FXMLBuscarController busqcontr, Usuarios usuario) {
        // Establecer la conexión a la base de datos usando EntityManager
        EntityManager em = Conexion.conecta();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            // Verificar si el usuario tiene un catálogo de series
            Query consultaCatalogo = em.createQuery("SELECT cs FROM CatalogoSeries cs WHERE cs.iDusuario = :usuario");
            consultaCatalogo.setParameter("usuario", usuario);
            List<CatalogoSeries> catalogoSeries = consultaCatalogo.getResultList();

            // Si el catálogo de series del usuario no existe, se crea
            if (catalogoSeries.isEmpty()) {
                CatalogoSeries nuevoCatalogo = new CatalogoSeries();
                nuevoCatalogo.setIDusuario(usuario);
                em.persist(nuevoCatalogo);
            }

            // Verificar si la serie ya existe
            String tituloSerie = busqcontr.titulo.getText();
            System.out.println(tituloSerie);
            Query consultaSerie = em.createQuery("SELECT s FROM Series s WHERE s.titulo = :titulo");
            consultaSerie.setParameter("titulo", tituloSerie);
            List<Series> seriesExistentes = consultaSerie.getResultList();
            if (!seriesExistentes.isEmpty()) {
                System.out.println("La serie ya existe en la base de datos.");

                // Agregar la serie existente al catálogo del usuario
                Series serieExistente = seriesExistentes.get(0); // Obtener la primera serie coincidente
                CatalogoSeries cs = new CatalogoSeries();
                cs.setIDusuario(usuario);
                cs.setIDserie(serieExistente);
                cs.setFechadeanadido(new Date());
                em.persist(cs);
            } else {
                // La serie no existe, se procede a agregarla

                // Paso 1: Insertar la serie en la tabla "series"
                Series serie = new Series();
                serie.setTitulo(tituloSerie);
                serie.setAnio(Integer.parseInt(busqcontr.getAnio().getText()));
                serie.setSinopsis(busqcontr.getSionpsistxt().getText());
                serie.setFotodePortada(busqcontr.getPathimagentxt().getText());
                em.persist(serie);

                // Paso 2: Insertar la serie en el catálogo de series del usuario
                CatalogoSeries cs = new CatalogoSeries();
                cs.setIDusuario(usuario);
                cs.setIDserie(serie);
                cs.setFechadeanadido(new Date());
                em.persist(cs);
            }

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, hacer rollback de la transacción
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Cerrar EntityManager
            em.close();
        }
    }

    public void agregarPeliculaPreCarga(Peliculas pelicula) {
        EntityManager em = Conexion.conecta();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            // Verificar si la película ya existe en la base de datos
            Query consultaPelicula = em.createQuery("SELECT p FROM Peliculas p WHERE p.titulo = :titulo");
            consultaPelicula.setParameter("titulo", pelicula.getTitulo());
            List<Peliculas> peliculasExistentes = consultaPelicula.getResultList();
            if (!peliculasExistentes.isEmpty()) {
                System.out.println("La película " + pelicula.getTitulo() + " ya existe en la base de datos.");
                return; // No se agrega la película
            }

            // Insertar la película en la tabla "peliculas"
            em.persist(pelicula);

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, hacer rollback de la transacción
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Cerrar EntityManager
            em.close();
        }
    }

    public void agregarSeriePreCarga(Series serie) {
        EntityManager em = Conexion.conecta();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            // Verificar si la serie ya existe en la base de datos
            Query consultaSerie = em.createQuery("SELECT s FROM Series s WHERE s.titulo = :titulo");
            consultaSerie.setParameter("titulo", serie.getTitulo());
            List<Series> seriesExistentes = consultaSerie.getResultList();
            if (!seriesExistentes.isEmpty()) {
                System.out.println("La serie " + serie.getTitulo() + " ya existe en la base de datos.");
                return; // No se agrega la serie
            }

            // Insertar la serie en la tabla "series"
            em.persist(serie);

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, hacer rollback de la transacción
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Cerrar EntityManager
            em.close();
        }
    }


    public List<Usuarios> listarUsuariosSeguidos(Integer usuarioId) {
        EntityManager em = Conexion.conecta();
        try {
            String consulta = "SELECT u FROM Usuarios u JOIN u.seguimientoUsuariosCollection1 s WHERE s.iDUsuarioSeguidor.iDUsuario = :usuarioId";
            TypedQuery<Usuarios> query = em.createQuery(consulta, Usuarios.class);
            query.setParameter("usuarioId", usuarioId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Usuarios> listarUsuariosQueSiguen(Integer usuarioId) {
        EntityManager em = Conexion.conecta();

        try {
            String consulta = "SELECT u FROM Usuarios u JOIN u.seguimientoUsuariosCollection s WHERE s.iDUsuarioSeguido.iDUsuario = :usuarioId";
            TypedQuery<Usuarios> query = em.createQuery(consulta, Usuarios.class);
            query.setParameter("usuarioId", usuarioId);
            return query.getResultList();
        } finally {
            em.close();
        }


    }

    public ArrayList<Valoraciones> obtenerValoracionesDeUsuario(Usuarios usuario) {
        // Establecer la conexión a la base de datos usando EntityManager
        EntityManager em = Conexion.conecta();

        try {
            // Realizar la consulta para obtener las valoraciones del usuario
            Query consulta = em.createQuery("SELECT v FROM Valoraciones v WHERE v.iDusuario = :usuario");
            consulta.setParameter("usuario", usuario);
            List<Valoraciones> valoraciones = consulta.getResultList();

            // Convertir la lista de valoraciones a un ArrayList
            ArrayList<Valoraciones> valoracionesArrayList = new ArrayList<>(valoraciones);

            return valoracionesArrayList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar EntityManager
            em.close();
        }

        return new ArrayList<>(); // Si ocurre un error, se devuelve un ArrayList vacío
    }

    public ArrayList<String> obtenerPathsPeliculasAleatorios(int nant) {
        ArrayList<String> paths = new ArrayList<>();

        // Crear el EntityManager
        EntityManager em = Conexion.conecta();

        try {
            // Construir la consulta JPQL para obtener los paths aleatorios
            String consulta = "SELECT p.fotodePortada FROM Peliculas p ORDER BY RAND()";

            // Crear la consulta TypedQuery
            TypedQuery<String> query = em.createQuery(consulta, String.class);

            // Establecer límite de resultados
            query.setMaxResults(nant);

            // Obtener los resultados de la consulta
            List<String> resultados = query.getResultList();

            // Agregar los resultados a la lista de paths
            paths.addAll(resultados);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            if (em != null) {
                em.close();
            }
        }

        return paths;
    }

    public ArrayList<String> obtenerPathsSeriesAleatorios( int nant) {
        ArrayList<String> paths = new ArrayList<>();

        // Crear el EntityManager
        EntityManager em = Conexion.conecta();

        try {
            // Construir la consulta JPQL para obtener los paths aleatorios
            String consulta = "SELECT s.fotodePortada FROM Series s ORDER BY RAND()";

            // Crear la consulta TypedQuery
            TypedQuery<String> query = em.createQuery(consulta, String.class);

            // Establecer límite de resultados
            query.setMaxResults(nant);

            // Obtener los resultados de la consulta
            List<String> resultados = query.getResultList();

            // Agregar los resultados a la lista de paths
            paths.addAll(resultados);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            if (em != null) {
                em.close();
            }
        }

        return paths;
    }

    public void agregarURLsAImageViewsPeliculas(ArrayList<String> imagePaths, ImageView[] imageViews) {
        for (int i = 0; i < imagePaths.size(); i++) {
            String imagePath = imagePaths.get(i);
            Image image = new Image(imagePath);
            imageViews[i].setImage(image);
        }
    }

    public void agregarURLsAImageViewsSeries(ArrayList<String> imagePaths, ImageView[] imageViews) {
        for (int i = 0; i < imagePaths.size(); i++) {
                String imagePath = imagePaths.get(i);
                Image image = new Image(imagePath);
                imageViews[i].setImage(image);
            }
        }


    }

