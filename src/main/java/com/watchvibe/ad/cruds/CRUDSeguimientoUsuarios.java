package com.watchvibe.ad.cruds;

import com.watchvibe.ad.operaciones.Conexion;
import com.watchvibe.ad.tablas.SeguimientoUsuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class CRUDSeguimientoUsuarios {

    public SeguimientoUsuarios getSeguimiento(int iDseguimiento) {
        SeguimientoUsuarios seguimiento = null;
        EntityManager em = Conexion.conecta();
        try {
            Query query = em.createNamedQuery("SeguimientoUsuarios.findByIDseguimiento");
            query.setParameter("iDseguimiento", iDseguimiento);
            seguimiento = (SeguimientoUsuarios) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No se encontró el seguimiento. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        }
        Conexion.desconecta(em);
        return seguimiento;
    }

    public void createSeguimiento(SeguimientoUsuarios seguimiento) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(seguimiento);
            et.commit();
            System.out.println("Se creó el seguimiento exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al crear el seguimiento. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public void updateSeguimiento(SeguimientoUsuarios seguimiento) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(seguimiento);
            et.commit();
            System.out.println("Se actualizó el seguimiento exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al actualizar el seguimiento. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public void deleteSeguimiento(int iDseguimiento) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            SeguimientoUsuarios seguimiento = em.find(SeguimientoUsuarios.class, iDseguimiento);
            if (seguimiento != null) {
                em.remove(seguimiento);
                System.out.println("Se eliminó el seguimiento exitosamente.");
            } else {
                System.out.println("No se encontró el seguimiento con el ID: " + iDseguimiento);
            }
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al eliminar el seguimiento. " + ex.getMessage());
        }
        Conexion.desconecta(em);
    }

    public List<SeguimientoUsuarios> getAllSeguimientos() {
        EntityManager em = Conexion.conecta();
        try {
            return em.createNamedQuery("SeguimientoUsuarios.findAll", SeguimientoUsuarios.class).getResultList();
        } finally {
            Conexion.desconecta(em);
        }
    }
}
