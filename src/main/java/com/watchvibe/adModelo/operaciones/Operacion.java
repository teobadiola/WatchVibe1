package com.watchvibe.adModelo.operaciones;

import com.watchvibe.adModelo.cruds.CRUDPeliculas;
import com.watchvibe.adModelo.cruds.CRUDSeries;
import com.watchvibe.adModelo.cruds.CRUDUsuarios;
import com.watchvibe.adModelo.tablas.*;
import com.watchvibe.visualsVista.FXMLBuscarController;
import com.watchvibe.visualsVista.FXMLFichaController;
import com.watchvibe.visualsVista.FXMLMenuController;
import com.watchvibe.visualsVista.FXMLRegistroController;
import com.welag.ad.tablas.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.persistence.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
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
        System.out.println("ID " + usuario.getIDUsuario());
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
            String tituloSerie = busqcontr.getTitulotxt().getText();
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

    public void agregarPeliculaSerie(FXMLBuscarController busqcontr, Usuarios usuario, boolean esPelicula) {
        // Establecer la conexión a la base de datos usando EntityManager
        EntityManager em = Conexion.conecta();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            // Verificar si el usuario tiene un catálogo de películas o series
            Query consultaCatalogoPeliculas = em.createQuery("SELECT cp FROM CatalogoPeliculas cp WHERE cp.iDusuario = :usuario");
            consultaCatalogoPeliculas.setParameter("usuario", usuario);
            List<CatalogoPeliculas> catalogoPeliculas = consultaCatalogoPeliculas.getResultList();

            Query consultaCatalogoSeries = em.createQuery("SELECT cs FROM CatalogoSeries cs WHERE cs.iDusuario = :usuario");
            consultaCatalogoSeries.setParameter("usuario", usuario);
            List<CatalogoSeries> catalogoSeries = consultaCatalogoSeries.getResultList();

            // Si el catálogo de películas o series del usuario no existe, se crea
            if (catalogoPeliculas.isEmpty() && esPelicula) {
                CatalogoPeliculas nuevoCatalogoPeliculas = new CatalogoPeliculas();
                nuevoCatalogoPeliculas.setIDusuario(usuario);
                em.persist(nuevoCatalogoPeliculas);
            }

            if (catalogoSeries.isEmpty() && !esPelicula) {
                CatalogoSeries nuevoCatalogoSeries = new CatalogoSeries();
                nuevoCatalogoSeries.setIDusuario(usuario);
                em.persist(nuevoCatalogoSeries);
            }

            // Verificar si el título ya existe en la base de datos
            String titulo = busqcontr.getTitulotxt().getText();
            Query consultaItem = null;
            List<?> itemsExistentes = null;

            if (esPelicula) {
                consultaItem = em.createQuery("SELECT p FROM Peliculas p WHERE p.titulo = :titulo");
                consultaItem.setParameter("titulo", titulo);
                itemsExistentes = consultaItem.getResultList();
            } else {
                consultaItem = em.createQuery("SELECT s FROM Series s WHERE s.titulo = :titulo");
                consultaItem.setParameter("titulo", titulo);
                itemsExistentes = consultaItem.getResultList();
            }

            if (!itemsExistentes.isEmpty()) {
                System.out.println("El item ya existe en la base de datos.");

                // Agregar el item existente al catálogo del usuario
                Object itemExistente = itemsExistentes.get(0); // Obtener el primer item coincidente

                if (esPelicula) {
                    CatalogoPeliculas cp = new CatalogoPeliculas();
                    cp.setIDusuario(usuario);
                    cp.setIDpelicula((Peliculas) itemExistente);
                    cp.setFechadeanadido(new Date());
                    em.persist(cp);
                } else {
                    CatalogoSeries cs = new CatalogoSeries();
                    cs.setIDusuario(usuario);
                    cs.setIDserie((Series) itemExistente);
                    cs.setFechadeanadido(new Date());
                    em.persist(cs);
                }
            } else {
                // El item no existe, se procede a agregarlo

                if (esPelicula) {
                    // Paso 1: Insertar la película en la tabla "peliculas"
                    Peliculas pelicula = new Peliculas();
                    pelicula.setTitulo(titulo);
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
                } else {
                    // Paso 1: Insertar la serie en la tabla "series"
                    Series serie = new Series();
                    serie.setTitulo(titulo);
                    serie.setAnio(Integer.parseInt(busqcontr.getAniotxt().getText()));
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

    public ArrayList<String> obtenerPathsSeriesAleatorios(int nant) {
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


    public void agregarReseña(FXMLBuscarController busqcontr, Usuarios usuario) {
        String reseña = busqcontr.getTextoReseñaEnviar().getText();
        Peliculas peliculaSeleccionada = busqcontr.getListviewpeliculas().getSelectionModel().getSelectedItem();
        Series serieSeleccionada = busqcontr.getListviewseries().getSelectionModel().getSelectedItem();

        EntityManager em = Conexion.conecta();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            if (peliculaSeleccionada != null) {
                // Se ha seleccionado una película

                Query query = em.createQuery("SELECT p FROM Peliculas p WHERE p.titulo = :titulo");
                query.setParameter("titulo", peliculaSeleccionada.getTitulo());
                Peliculas peliculaExistente = (Peliculas) query.getSingleResult();
                if (peliculaExistente != null) {
                    peliculaSeleccionada = peliculaExistente;
                } else {
                    em.persist(peliculaSeleccionada);
                    em.flush();
                }

                Comentarios comentario = new Comentarios();
                comentario.setContenidodelcomentario(reseña);
                comentario.setFechadepublicacion(new Date());
                comentario.setIDUsuario(usuario);
                comentario.setIDPelicula(peliculaSeleccionada);

                em.persist(comentario);
            } else if (serieSeleccionada != null) {
                // Se ha seleccionado una serie
                System.out.println("serie SELECCIONADA a insertar");
                Query query = em.createQuery("SELECT s FROM Series s WHERE s.titulo = :titulo");
                query.setParameter("titulo", serieSeleccionada.getTitulo());
                Series serieExistente = (Series) query.getSingleResult();
                if (serieExistente != null) {
                    serieSeleccionada = serieExistente;
                } else {
                    em.persist(serieSeleccionada);
                    em.flush();
                }

            }

            transaction.commit();
            busqcontr.getPanelTransparente().setVisible(false);
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }

    public void agregarReseñaMenu(FXMLMenuController fxmlMenuController, Usuarios usuario) {
        String reseña = "";
        EntityManager em = Conexion.conecta();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            if (fxmlMenuController.peliculaSeleccionada != null) {

                Query query = em.createQuery("SELECT p FROM Peliculas p WHERE p.titulo = :titulo");
                query.setParameter("titulo", fxmlMenuController.peliculaSeleccionada.getTitulo());
                Peliculas peliculaExistente = (Peliculas) query.getSingleResult();

                Comentarios comentario = new Comentarios();
                comentario.setContenidodelcomentario(reseña);
                comentario.setFechadepublicacion(new Date());
                comentario.setIDUsuario(usuario);
                comentario.setIDPelicula(peliculaExistente);

                em.persist(comentario);
            } else if (fxmlMenuController.serieSeleccionada != null) {

                System.out.println("serie SELECCIONADA a insertar");
                Query query = em.createQuery("SELECT s FROM Series s WHERE s.titulo = :titulo");
                query.setParameter("titulo", fxmlMenuController.serieSeleccionada.getTitulo());
                Series serieExistente = (Series) query.getSingleResult();

                Comentarios comentario = new Comentarios();
                comentario.setContenidodelcomentario(reseña);
                comentario.setFechadepublicacion(new Date());
                comentario.setIDUsuario(usuario);
                comentario.setIDSerie(serieExistente);

            }

            transaction.commit();
            fxmlMenuController.getPanelReseñasPeliculaSerie().setVisible(false);
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }

    public List<Comentarios> obtenerComentariosPeliculas(FXMLBuscarController busqcontr, Peliculas peliculaSeleccionada) {
        CRUDPeliculas cp = new CRUDPeliculas();
        EntityManager em = Conexion.conecta();

        try {

            Peliculas pelicula = cp.getPelicula(peliculaSeleccionada.getTitulo());
            // Realizar la consulta para obtener los comentarios de la película seleccionada
            Query consulta = em.createQuery("SELECT c FROM Comentarios c WHERE c.iDPelicula = :pelicula");
            consulta.setParameter("pelicula", pelicula);
            List<Comentarios> comentarios = consulta.getResultList();

            return comentarios;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return new ArrayList<>(); // Si ocurre un error, se devuelve una lista vacía
    }

    public List<Comentarios> obtenerComentariosSeries(FXMLBuscarController busqcontr, Series serieSeleccionada) {
        CRUDSeries cs = new CRUDSeries();
        EntityManager em = Conexion.conecta();

        try {

            Series serie = cs.getSeries(serieSeleccionada.getTitulo());

            // Realizar la consulta para obtener los comentarios de la serie seleccionada
            Query consulta = em.createQuery("SELECT c FROM Comentarios c WHERE c.iDSerie = :serie");
            consulta.setParameter("serie", serie);
            List<Comentarios> comentarios = consulta.getResultList();

            return comentarios;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return new ArrayList<>(); // Si ocurre un error, se devuelve una lista vacía
    }


    public List<Comentarios> obtenerComentariosPeliculas(FXMLMenuController fxmlMenuController, Peliculas peliculaSeleccionada) {
        CRUDPeliculas cp = new CRUDPeliculas();
        EntityManager em = Conexion.conecta();

        try {

            Peliculas pelicula = cp.getPelicula(peliculaSeleccionada.getTitulo());
            // Realizar la consulta para obtener los comentarios de la película seleccionada
            Query consulta = em.createQuery("SELECT c FROM Comentarios c WHERE c.iDPelicula = :pelicula");
            consulta.setParameter("pelicula", pelicula);
            List<Comentarios> comentarios = consulta.getResultList();

            return comentarios;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return new ArrayList<>(); // Si ocurre un error, se devuelve una lista vacía

    }

    public List<Comentarios> obtenerComentariosSeries(FXMLMenuController fxmlMenuController, Series serieSeleccionada) {
        CRUDSeries cs = new CRUDSeries();
        EntityManager em = Conexion.conecta();

        try {

            Series serie = cs.getSeries(serieSeleccionada.getTitulo());

            // Realizar la consulta para obtener los comentarios de la serie seleccionada
            Query consulta = em.createQuery("SELECT c FROM Comentarios c WHERE c.iDSerie = :serie");
            consulta.setParameter("serie", serie);
            List<Comentarios> comentarios = consulta.getResultList();

            return comentarios;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return new ArrayList<>(); // Si ocurre un error, se devuelve una lista vacía
    }

    public void AgregarCatalogo(FXMLMenuController fxmlMenuController, Usuarios usuario) {
        EntityManager em = Conexion.conecta();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            if (fxmlMenuController.peliculaSeleccionada != null) {
                // Verificar si el usuario ya tiene la película en su catálogo
                Query query = em.createQuery("SELECT cp FROM CatalogoPeliculas cp WHERE cp.iDusuario = :usuario AND cp.iDpelicula = :pelicula");
                query.setParameter("usuario", usuario);
                query.setParameter("pelicula", fxmlMenuController.peliculaSeleccionada);
                List<CatalogoPeliculas> catalogoPeliculas = query.getResultList();

                if (catalogoPeliculas.isEmpty()) {
                    CatalogoPeliculas cp = new CatalogoPeliculas();
                    cp.setIDusuario(usuario);
                    cp.setIDpelicula(fxmlMenuController.peliculaSeleccionada);
                    cp.setFechadeanadido(new Date());
                    em.persist(cp);
                    System.out.println("Película agregada");
                } else {
                    System.out.println("El usuario ya tiene la película en su catálogo.");
                }
            } else {
                System.out.println("No se ha seleccionado una película para agregar al catálogo.");
            }

            if (fxmlMenuController.serieSeleccionada != null) {
                // Verificar si el usuario ya tiene la serie en su catálogo
                Query query = em.createQuery("SELECT cs FROM CatalogoSeries cs WHERE cs.iDusuario = :usuario AND cs.iDserie = :serie");
                query.setParameter("usuario", usuario);
                query.setParameter("serie", fxmlMenuController.serieSeleccionada);
                List<CatalogoSeries> catalogoSeries = query.getResultList();

                if (catalogoSeries.isEmpty()) {
                    CatalogoSeries cs = new CatalogoSeries();
                    cs.setIDusuario(usuario);
                    cs.setIDserie(fxmlMenuController.serieSeleccionada);
                    cs.setFechadeanadido(new Date());
                    em.persist(cs);
                    System.out.println("Serie agregada al catálogo.");
                } else {
                    System.out.println("El usuario ya tiene la serie en su catálogo.");
                }
            } else {
                System.out.println("No se ha seleccionado una serie para agregar al catálogo.");
            }

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al agregar el elemento al catálogo: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    public ArrayList<CatalogoPeliculas> obtenerCatalogoPeliculasUsuario(Usuarios usuario) {
        ArrayList<CatalogoPeliculas> catalogoPeliculas = new ArrayList<>();

        // Crear el EntityManager
        EntityManager em = Conexion.conecta();

        try {
            // Construir la consulta JPQL para obtener los catálogos de películas del usuario
            String consulta = "SELECT cp FROM CatalogoPeliculas cp WHERE cp.iDusuario = :usuario";

            // Crear la consulta TypedQuery
            TypedQuery<CatalogoPeliculas> query = em.createQuery(consulta, CatalogoPeliculas.class);

            // Establecer el parámetro de usuario en la consulta
            query.setParameter("usuario", usuario);

            // Obtener los resultados de la consulta
            List<CatalogoPeliculas> resultados = query.getResultList();

            // Agregar los resultados al catálogo de películas
            catalogoPeliculas.addAll(resultados);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }

        return catalogoPeliculas;
    }

    public ArrayList<CatalogoSeries> obtenerCatalogoSeriesUsuario(Usuarios usuario) {
        ArrayList<CatalogoSeries> catalogoSeries = new ArrayList<>();

        // Crear el EntityManager
        EntityManager em = Conexion.conecta();

        try {
            // Construir la consulta JPQL para obtener los catálogos de series del usuario
            String consulta = "SELECT cs FROM CatalogoSeries cs WHERE cs.iDusuario = :usuario";

            // Crear la consulta TypedQuery
            TypedQuery<CatalogoSeries> query = em.createQuery(consulta, CatalogoSeries.class);

            // Establecer el parámetro de usuario en la consulta
            query.setParameter("usuario", usuario);

            // Obtener los resultados de la consulta
            List<CatalogoSeries> resultados = query.getResultList();

            // Agregar los resultados al catálogo de series
            catalogoSeries.addAll(resultados);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }

        return catalogoSeries;
    }

    public ArrayList<Peliculas> obtenerPeliculasDeCatalogo(ArrayList<CatalogoPeliculas> catalogoPeliculas) {
        ArrayList<Peliculas> peliculas = new ArrayList<>();

        for (CatalogoPeliculas cp : catalogoPeliculas) {
            Peliculas pelicula = cp.getIDpelicula();
            if (pelicula != null) {
                peliculas.add(pelicula);
            }
        }

        return peliculas;
    }

    public ArrayList<Series> obtenerSeriesDeCatalogo(ArrayList<CatalogoSeries> catalogoSeries) {
        ArrayList<Series> series = new ArrayList<>();

        for (CatalogoSeries cs : catalogoSeries) {
            Series serie = cs.getIDserie();
            if (serie != null) {
                series.add(serie);
            }
        }

        return series;
    }

    public boolean eliminarSerie(int serieId, int usuarioId) {
        // Crear el EntityManager
        EntityManager em = Conexion.conecta();

        try {
            // Iniciar una transacción
            em.getTransaction().begin();

            // Buscar el objeto CatalogoSeries por el ID de la serie y el ID del usuario
            TypedQuery<CatalogoSeries> query = em.createQuery("SELECT cs FROM CatalogoSeries cs WHERE cs.iDserie.iDSerie = :serieId AND cs.iDusuario.iDUsuario = :usuarioId", CatalogoSeries.class);
            query.setParameter("serieId", serieId);
            query.setParameter("usuarioId", usuarioId);

            CatalogoSeries catalogoSeries = query.getSingleResult();

            if (catalogoSeries != null) {
                // Eliminar el objeto CatalogoSeries
                em.remove(catalogoSeries);

                // Confirmar la transacción
                em.getTransaction().commit();
                return true;
            } else {
                // El objeto CatalogoSeries no existe o no corresponde al usuario
                return false;
            }
        } catch (NoResultException e) {
            // El objeto CatalogoSeries no existe o no corresponde al usuario
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            // Ocurrió un error en la transacción
            em.getTransaction().rollback();
            return false;
        } finally {
            // Cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }


    public boolean eliminarPelicula(int peliculaId, int usuarioId) {
        // Crear el EntityManager
        EntityManager em = Conexion.conecta();

        try {
            // Iniciar una transacción
            em.getTransaction().begin();

            // Buscar el objeto CatalogoSeries por el ID de la serie y el ID del usuario
            TypedQuery<CatalogoPeliculas> query = em.createQuery("SELECT cs FROM CatalogoPeliculas cs WHERE cs.iDpelicula.iDPelicula = :serieId AND cs.iDusuario.iDUsuario = :usuarioId", CatalogoPeliculas.class);
            query.setParameter("serieId", peliculaId);
            query.setParameter("usuarioId", usuarioId);

            CatalogoPeliculas catalogopelicula = query.getSingleResult();

            if (catalogopelicula != null) {
                // Eliminar el objeto CatalogoSeries
                em.remove(catalogopelicula);

                // Confirmar la transacción
                em.getTransaction().commit();
                return true;
            } else {
                // El objeto CatalogoSeries no existe o no corresponde al usuario
                return false;
            }
        } catch (NoResultException e) {
            // El objeto CatalogoSeries no existe o no corresponde al usuario
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            // Ocurrió un error en la transacción
            em.getTransaction().rollback();
            return false;
        } finally {
            // Cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuarios> obtenerTodosLosUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();

        // Crear el EntityManager
        EntityManager em = Conexion.conecta();

        try {
            // Construir la consulta JPQL para obtener todos los usuarios
            String consulta = "SELECT u FROM Usuarios u";

            // Crear la consulta TypedQuery
            TypedQuery<Usuarios> query = em.createQuery(consulta, Usuarios.class);

            // Obtener los resultados de la consulta
            usuarios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }

        return usuarios;
    }

    public static Pane crearPaneAmigo(Usuarios user) {
        // Crea un nuevo Pane para el amigo
        Pane paneAmigo = new Pane();
        paneAmigo.setStyle("-fx-background-color: transparent; -fx-padding: 10px;");

        // Agrega los elementos de contenido al Pane
        Label nombreLabel = new Label("Usuario: " + user.getNombre());
        nombreLabel.setStyle("-fx-font-weight: bold;");

        Button addButton = new Button("Añadir Amigo");
        addButton.setLayoutX(10);
        addButton.setLayoutY(30);

        paneAmigo.getChildren().addAll(nombreLabel, addButton);

        return paneAmigo;
    }




}



