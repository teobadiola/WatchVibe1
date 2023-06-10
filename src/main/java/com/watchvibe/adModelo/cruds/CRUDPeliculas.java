package com.watchvibe.adModelo.cruds;

import com.watchvibe.adModelo.operaciones.Conexion;
import com.watchvibe.adModelo.tablas.Peliculas;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class CRUDPeliculas {
    public Peliculas getPelicula(int iDPelicula) {
        Peliculas pelicula = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("Peliculas.findByIDPelicula");
            query.setParameter("iDPelicula", iDPelicula);
            pelicula = (Peliculas) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No se encontró la película. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }
        Conexion.desconecta(em);
        return pelicula;
    }

    public Peliculas getPelicula(String titulo) {
        Peliculas pelicula = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("Peliculas.findByTitulo");
            query.setParameter("titulo", titulo);
            pelicula = (Peliculas) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No se encontró la película. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }
        Conexion.desconecta(em);
        return pelicula;
    }


    public void createPelicula(Peliculas pelicula) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(pelicula);
            et.commit();
            System.out.println("Se creó la película exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al crear la película. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public void updatePelicula(Peliculas pelicula) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(pelicula);
            et.commit();
            System.out.println("Se actualizó la película exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al actualizar la película. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public void deletePelicula(int iDPelicula) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Peliculas pelicula = em.find(Peliculas.class, iDPelicula);
            if (pelicula != null) {
                em.remove(pelicula);
                System.out.println("Se eliminó la película exitosamente.");
            } else {
                System.out.println("No se encontró la película con el ID: " + iDPelicula);
            }
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al eliminar la película. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public List<Peliculas> getAllPeliculas() {
        EntityManager em = Conexion.conecta();
        try {
            return em.createNamedQuery("Peliculas.findAll", Peliculas.class).getResultList();
        } finally {
            Conexion.desconecta(em);
        }
    }
}
