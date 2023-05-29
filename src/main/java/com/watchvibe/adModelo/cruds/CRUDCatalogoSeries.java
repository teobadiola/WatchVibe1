package com.watchvibe.adModelo.cruds;

import com.watchvibe.adModelo.operaciones.Conexion;
import com.watchvibe.adModelo.tablas.CatalogoSeries;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class CRUDCatalogoSeries {
    public CatalogoSeries getCatalogoSeries(int iDCat) {
        CatalogoSeries catalogoSeries = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("CatalogoSeries.findByIDCat");
            query.setParameter("iDCat", iDCat);
            catalogoSeries = (CatalogoSeries) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No se encontró el catálogo de series. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }
        Conexion.desconecta(em);
        return catalogoSeries;
    }

    public void createCatalogoSeries(CatalogoSeries catalogoSeries) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(catalogoSeries);
            et.commit();
            System.out.println("Se creó el catálogo de series exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al crear el catálogo de series. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public void updateCatalogoSeries(CatalogoSeries catalogoSeries) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(catalogoSeries);
            et.commit();
            System.out.println("Se actualizó el catálogo de series exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al actualizar el catálogo de series. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public void deleteCatalogoSeries(int iDCat) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            CatalogoSeries catalogoSeries = em.find(CatalogoSeries.class, iDCat);
            if (catalogoSeries != null) {
                em.remove(catalogoSeries);
                System.out.println("Se eliminó el catálogo de series exitosamente.");
            } else {
                System.out.println("No se encontró el catálogo de series con el ID: " + iDCat);
            }
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al eliminar el catálogo de series. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public List<CatalogoSeries> getAllCatalogoSeries() {
        EntityManager em = Conexion.conecta();
        try {
            return em.createNamedQuery("CatalogoSeries.findAll", CatalogoSeries.class).getResultList();
        } finally {
            Conexion.desconecta(em);
        }
    }

}
