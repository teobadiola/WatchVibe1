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
@Table(name = "catalogo_peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoPeliculas.findAll", query = "SELECT c FROM CatalogoPeliculas c"),
    @NamedQuery(name = "CatalogoPeliculas.findByIDCat", query = "SELECT c FROM CatalogoPeliculas c WHERE c.iDCat = :iDCat"),
    @NamedQuery(name = "CatalogoPeliculas.findByFechadeanadido", query = "SELECT c FROM CatalogoPeliculas c WHERE c.fechadeanadido = :fechadeanadido")})
public class CatalogoPeliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Cat")
    public Integer iDCat;
    @Column(name = "Fecha_de_anadido")
    @Temporal(TemporalType.DATE)
    public Date fechadeanadido;
    @JoinColumn(name = "ID_usuario", referencedColumnName = "ID_Usuario")
    @ManyToOne
    public Usuarios iDusuario;
    @JoinColumn(name = "ID_pelicula", referencedColumnName = "ID_Pelicula")
    @ManyToOne
    public Peliculas iDpelicula;

    public CatalogoPeliculas() {
    }

    public CatalogoPeliculas(Integer iDCat) {
        this.iDCat = iDCat;
    }

    public Integer getIDCat() {
        return iDCat;
    }

    public void setIDCat(Integer iDCat) {
        this.iDCat = iDCat;
    }

    public Date getFechadeanadido() {
        return fechadeanadido;
    }

    public void setFechadeanadido(Date fechadeanadido) {
        this.fechadeanadido = fechadeanadido;
    }

    public Usuarios getIDusuario() {
        return iDusuario;
    }

    public void setIDusuario(Usuarios iDusuario) {
        this.iDusuario = iDusuario;
    }

    public Peliculas getIDpelicula() {
        return iDpelicula;
    }

    public void setIDpelicula(Peliculas iDpelicula) {
        this.iDpelicula = iDpelicula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCat != null ? iDCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoPeliculas)) {
            return false;
        }
        CatalogoPeliculas other = (CatalogoPeliculas) object;
        if ((this.iDCat == null && other.iDCat != null) || (this.iDCat != null && !this.iDCat.equals(other.iDCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.watchvibe.ad.tablas.CatalogoPeliculas[ iDCat=" + iDCat + " ]";
    }
    
}
