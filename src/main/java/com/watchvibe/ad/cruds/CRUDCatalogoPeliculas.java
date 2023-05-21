package com.watchvibe.ad.cruds;

import com.watchvibe.ad.operaciones.Conexion;
import com.watchvibe.ad.tablas.CatalogoPeliculas;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class CRUDCatalogoPeliculas {
    public CatalogoPeliculas getCatalogoPeliculas(int iDCat) {
        CatalogoPeliculas catalogoPeliculas = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("CatalogoPeliculas.findByIDCat");
            query.setParameter("iDCat", iDCat);
            catalogoPeliculas = (CatalogoPeliculas) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No se encontró el catálogo de películas. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }
        Conexion.desconecta(em);
        return catalogoPeliculas;
    }

    public void createCatalogoPeliculas(CatalogoPeliculas catalogoPeliculas) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(catalogoPeliculas);
            et.commit();
            System.out.println("Se creó el catálogo de películas exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al crear el catálogo de películas. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public void updateCatalogoPeliculas(CatalogoPeliculas catalogoPeliculas) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(catalogoPeliculas);
            et.commit();
            System.out.println("Se actualizó el catálogo de películas exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al actualizar el catálogo de películas. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public void deleteCatalogoPeliculas(int iDCat) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            CatalogoPeliculas catalogoPeliculas = em.find(CatalogoPeliculas.class, iDCat);
            if (catalogoPeliculas != null) {
                em.remove(catalogoPeliculas);
                System.out.println("Se eliminó el catálogo de películas exitosamente.");
            } else {
                System.out.println("No se encontró el catálogo de películas con el ID: " + iDCat);
            }
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al eliminar el catálogo de películas. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }




}
