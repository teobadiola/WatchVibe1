package com.watchvibe.ad.cruds;

import com.watchvibe.ad.operaciones.Conexion;
import com.watchvibe.ad.tablas.Usuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CRUDUsuarios {

    public Usuarios getUsuario(int idUsuario) {
        Usuarios usuario = null;
        EntityManager em = Conexion.conecta();
        try {
            TypedQuery<Usuarios> query = em.createNamedQuery("Usuarios.findByIDUsuario", Usuarios.class);
            query.setParameter("iDUsuario", idUsuario);
            usuario = query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No se encontró el usuario. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        } finally {
            Conexion.desconecta(em);
        }
        return usuario;
    }

    public Usuarios getUsuarioporNombre(String nombre) {
        Usuarios usuario = null;
        EntityManager em = Conexion.conecta();
        try {
            TypedQuery<Usuarios> query = em.createNamedQuery("Usuarios.findByNombre", Usuarios.class);
            query.setParameter("nombre", nombre);
            usuario = query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No se encontró el usuario. " + ex.getMessage());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Error en el argumento. " + ex1.getMessage());
        } finally {
            Conexion.desconecta(em);
        }
        return usuario;
    }

    public void createUsuario(Usuarios usuario) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(usuario);
            et.commit();
            System.out.println("Se creó el usuario exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al crear el usuario. " + ex.getMessage());
        } finally {
            Conexion.desconecta(em);
        }
    }

    public void updateUsuario(Usuarios usuario) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(usuario);
            et.commit();
            System.out.println("Se actualizó el usuario exitosamente.");
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al actualizar el usuario. " + ex.getMessage());
        } finally {
            Conexion.desconecta(em);
        }
    }

    public void deleteUsuario(int idUsuario) {
        EntityManager em = Conexion.conecta();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Usuarios usuario = em.find(Usuarios.class, idUsuario);
            if (usuario != null) {
                em.remove(usuario);
                System.out.println("Se eliminó el usuario exitosamente.");
            } else {
                System.out.println("No se encontró el usuario con el ID: " + idUsuario);
            }
            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            System.out.println("Error al eliminar el usuario. " + ex.getMessage());
        } finally {
            Conexion.desconecta(em);
        }
    }

    public List<Usuarios> getAllUsuarios() {
        EntityManager em = Conexion.conecta();
        try {
            TypedQuery<Usuarios> query = em.createNamedQuery("Usuarios.findAll", Usuarios.class);
            return query.getResultList();
        } finally {
            Conexion.desconecta(em);
        }
    }


}
