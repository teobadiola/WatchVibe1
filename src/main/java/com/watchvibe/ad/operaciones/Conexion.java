package com.watchvibe.ad.operaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Conexion {
    public Conexion() {
    }

    public static EntityManager conecta() {
        EntityManager entitymanager = null;
        try {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("com.watchvibe.0-SNAPSHOTPU");
            entitymanager = emfactory.createEntityManager();
        } catch (PersistenceException ex) {
            System.err.println("ERROR al conectar. " + ex.getLocalizedMessage());
        }
        return entitymanager;
    }


    public static void desconecta(EntityManager em) {
        if (em != null) {
            em.close();
        }
    }

    public static void main(String[] args) {
        EntityManager entityManager = Conexion.conecta();

        if (entityManager != null) {
            System.out.println("Conexión exitosa con la BBDD");
            Conexion.desconecta(entityManager);
            System.out.println("Desconexión exitosa");
        } else {
            System.out.println("No se pudo establecer la conexión");
        }

    }
}