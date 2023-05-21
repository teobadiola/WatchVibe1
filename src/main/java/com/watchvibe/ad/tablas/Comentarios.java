/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchvibe.ad.tablas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author teode
 */
@Entity
@Table(name = "comentarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentarios.findAll", query = "SELECT c FROM Comentarios c"),
    @NamedQuery(name = "Comentarios.findByIDComent", query = "SELECT c FROM Comentarios c WHERE c.iDComent = :iDComent"),
    @NamedQuery(name = "Comentarios.findByFechadepublicacion", query = "SELECT c FROM Comentarios c WHERE c.fechadepublicacion = :fechadepublicacion")})
public class Comentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Coment")
    private Integer iDComent;
    @Lob
    @Column(name = "Contenido_del_comentario")
    private String contenidodelcomentario;
    @Column(name = "Fecha_de_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechadepublicacion;
    @JoinColumn(name = "ID_Usuario", referencedColumnName = "ID_Usuario")
    @ManyToOne
    private Usuarios iDUsuario;
    @JoinColumn(name = "ID_Pelicula", referencedColumnName = "ID_Pelicula")
    @ManyToOne
    private Peliculas iDPelicula;
    @JoinColumn(name = "ID_Serie", referencedColumnName = "ID_Serie")
    @ManyToOne
    private Series iDSerie;

    public Comentarios() {
    }

    public Comentarios(Integer iDComent) {
        this.iDComent = iDComent;
    }

    public Integer getIDComent() {
        return iDComent;
    }

    public void setIDComent(Integer iDComent) {
        this.iDComent = iDComent;
    }

    public String getContenidodelcomentario() {
        return contenidodelcomentario;
    }

    public void setContenidodelcomentario(String contenidodelcomentario) {
        this.contenidodelcomentario = contenidodelcomentario;
    }

    public Date getFechadepublicacion() {
        return fechadepublicacion;
    }

    public void setFechadepublicacion(Date fechadepublicacion) {
        this.fechadepublicacion = fechadepublicacion;
    }

    public Usuarios getIDUsuario() {
        return iDUsuario;
    }

    public void setIDUsuario(Usuarios iDUsuario) {
        this.iDUsuario = iDUsuario;
    }

    public Peliculas getIDPelicula() {
        return iDPelicula;
    }

    public void setIDPelicula(Peliculas iDPelicula) {
        this.iDPelicula = iDPelicula;
    }

    public Series getIDSerie() {
        return iDSerie;
    }

    public void setIDSerie(Series iDSerie) {
        this.iDSerie = iDSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDComent != null ? iDComent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentarios)) {
            return false;
        }
        Comentarios other = (Comentarios) object;
        if ((this.iDComent == null && other.iDComent != null) || (this.iDComent != null && !this.iDComent.equals(other.iDComent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.watchvibe.ad.tablas.Comentarios[ iDComent=" + iDComent + " ]";
    }
    
}
