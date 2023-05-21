package com.watchvibe.ad.operaciones;

import com.watchvibe.ad.cruds.CRUDUsuarios;
import com.watchvibe.ad.tablas.CatalogoPeliculas;
import com.watchvibe.ad.tablas.CatalogoSeries;
import com.watchvibe.ad.tablas.Usuarios;
import com.watchvibe.proyectofinal.FXMLRegistroController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.Date;

public class Operacion {

    public static int procesarRegistro(FXMLRegistroController registroc) {
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
            //cr.createUsuario(user);
            //System.out.println(user.toString());

            /*
            // Crear el objeto Catalogo_Peliculas
            CatalogoPeliculas cp = new CatalogoPeliculas();
            cp.setIDusuario(user); // Asignar el ID del usuario
            em.persist(cp);

            // Crear el objeto Catalogo_Series
            CatalogoSeries cs = new CatalogoSeries();
            cs.setIDusuario(user); // Asignar el ID del usuario
            em.persist(cs);
            */


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
}
