package com.watchvibe.ad.cruds;

import com.watchvibe.ad.operaciones.Conexion;
import com.watchvibe.ad.tablas.Comentarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class CRUDComentarios {

    public class ComentariosDAO {
        public Comentarios getComentario(int iDComent) {
            Comentarios comentario = null;
            EntityManager em = Conexion.conecta();
            try {
                Query query = em.createNamedQuery("Comentarios.findByIDComent");
                query.setParameter("iDComent", iDComent);
                comentario = (Comentarios) query.getSingleResult();
            } catch (NoResultException ex) {
                System.out.println("No se encontró el comentario. " + ex.getMessage());
            } catch (IllegalArgumentException ex1) {
                System.out.println("Error en el argumento. " + ex1.getMessage());
            }
            Conexion.desconecta(em);
            return comentario;
        }

        public void createComentario(Comentarios comentario) {
            EntityManager em = Conexion.conecta();
            EntityTransaction et = em.getTransaction();
            try {
                et.begin();
                em.persist(comentario);
                et.commit();
                System.out.println("Se creó el comentario exitosamente.");
            } catch (Exception ex) {
                if (et != null && et.isActive()) {
                    et.rollback();
                }
                ex.printStackTrace();
                System.out.println("Error al crear el comentario. " + ex.getMessage());
            }
            Conexion.desconecta(em);
        }

        public void updateComentario(Comentarios comentario) {
            EntityManager em = Conexion.conecta();
            EntityTransaction et = em.getTransaction();
            try {
                et.begin();
                em.merge(comentario);
                et.commit();
                System.out.println("Se actualizó el comentario exitosamente.");
            } catch (Exception ex) {
                if (et != null && et.isActive()) {
                    et.rollback();
                }
                ex.printStackTrace();
                System.out.println("Error al actualizar el comentario. " + ex.getMessage());
            }
            Conexion.desconecta(em);
        }

        public void deleteComentario(int iDComent) {
            EntityManager em = Conexion.conecta();
            EntityTransaction et = em.getTransaction();
            try {
                et.begin();
                Comentarios comentario = em.find(Comentarios.class, iDComent);
                if (comentario != null) {
                    em.remove(comentario);
                    System.out.println("Se eliminó el comentario exitosamente.");
                } else {
                    System.out.println("No se encontró el comentario con el ID: " + iDComent);
                }
                et.commit();
            } catch (Exception ex) {
                if (et != null && et.isActive()) {
                    et.rollback();
                }
                ex.printStackTrace();
                System.out.println("Error al eliminar el comentario. " + ex.getMessage());
            }
            Conexion.desconecta(em);
        }

        public List<Comentarios> getAllComentarios() {
            EntityManager em = Conexion.conecta();
            try {
                return em.createNamedQuery("Comentarios.findAll", Comentarios.class).getResultList();
            } finally {
                Conexion.desconecta(em);
            }
        }
    }
}
