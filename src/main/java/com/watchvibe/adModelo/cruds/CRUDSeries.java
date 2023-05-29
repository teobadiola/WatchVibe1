package com.watchvibe.adModelo.cruds;

import com.watchvibe.adModelo.operaciones.Conexion;
import com.watchvibe.adModelo.tablas.Series;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class CRUDSeries {

    public Series getSeries(int iDSerie) {
        Series series = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("Series.findByIDSerie");
            query.setParameter("iDSerie", iDSerie);
            series = (Series) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No se encontró la serie. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }
        Conexion.desconecta(em);
        return series;
    }

    public void createSeries(Series series) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(series);
            et.commit();
            System.out.println("Se creó la serie exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al crear la serie. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public void updateSeries(Series series) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(series);
            et.commit();
            System.out.println("Se actualizó la serie exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al actualizar la serie. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public void deleteSeries(int iDSerie) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Series series = em.find(Series.class, iDSerie);
            if (series != null) {
                em.remove(series);
                System.out.println("Se eliminó la serie exitosamente.");
            } else {
                System.out.println("No se encontró la serie con el ID: " + iDSerie);
            }
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al eliminar la serie. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public List<Series> getAllSeries() {
        EntityManager em = Conexion.conecta();
        try {
            return em.createNamedQuery("Series.findAll", Series.class).getResultList();
        } finally {
            Conexion.desconecta(em);
        }
    }
}
