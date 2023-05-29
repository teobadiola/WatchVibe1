package com.watchvibe.adModelo.cruds;

import com.watchvibe.adModelo.operaciones.Conexion;
import com.watchvibe.adModelo.tablas.Valoraciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CRUDValoraciones {

    public Valoraciones getValoracion(int idValoracion) {
        Valoraciones valoracion = null;
        EntityManager em = Conexion.conecta();
        try {
            TypedQuery<Valoraciones> query = em.createNamedQuery("Valoraciones.findByIDvaloracion", Valoraciones.class);
            query.setParameter("iDvaloracion", idValoracion);
            valoracion = query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No se encontró la valoración. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        } finally {
            Conexion.desconecta(em);
        }
        return valoracion;
    }

    public void createValoracion(Valoraciones valoracion) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(valoracion);
            et.commit();
            System.out.println("Se creó la valoración exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al crear la valoración. " + ex.getMessage());
        } finally {
            Conexion.desconecta(em);
        }
    }

    public void updateValoracion(Valoraciones valoracion) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(valoracion);
            et.commit();
            System.out.println("Se actualizó la valoración exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al actualizar la valoración. " + ex.getMessage());
        } finally {
            Conexion.desconecta(em);
        }
    }

    public void deleteValoracion(int idValoracion) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Valoraciones valoracion = em.find(Valoraciones.class, idValoracion);
            if (valoracion != null) {
                em.remove(valoracion);
                System.out.println("Se eliminó la valoración exitosamente.");
            } else {
                System.out.println("No se encontró la valoración con el ID: " + idValoracion);
            }
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al eliminar la valoración. " + ex.getMessage());
        } finally {
            Conexion.desconecta(em);
        }
    }

    public List<Valoraciones> getAllValoraciones() {
        EntityManager em = Conexion.conecta();
        try {
            TypedQuery<Valoraciones> query = em.createNamedQuery("Valoraciones.findAll", Valoraciones.class);
            return query.getResultList();
        } finally {
            Conexion.desconecta(em);
        }
    }
}
