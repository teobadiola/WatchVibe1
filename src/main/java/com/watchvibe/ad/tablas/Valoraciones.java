/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchvibe.ad.tablas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author teode
 */
@Entity
@Table(name = "valoraciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoraciones.findAll", query = "SELECT v FROM Valoraciones v"),
    @NamedQuery(name = "Valoraciones.findByIDvaloracion", query = "SELECT v FROM Valoraciones v WHERE v.iDvaloracion = :iDvaloracion"),
    @NamedQuery(name = "Valoraciones.findByValoracion", query = "SELECT v FROM Valoraciones v WHERE v.valoracion = :valoracion"),
    @NamedQuery(name = "Valoraciones.findByFechadelavaloracion", query = "SELECT v FROM Valoraciones v WHERE v.fechadelavaloracion = :fechadelavaloracion")})
public class Valoraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_valoracion")
    private Integer iDvaloracion;
    @Column(name = "Valoracion")
    private Integer valoracion;
    @Column(name = "Fecha_de_la_valoracion")
    @Temporal(TemporalType.DATE)
    private Date fechadelavaloracion;
    @JoinColumn(name = "ID_usuario", referencedColumnName = "ID_Usuario")
    @ManyToOne
    private Usuarios iDusuario;
    @JoinColumn(name = "ID_pelicula", referencedColumnName = "ID_Pelicula")
    @ManyToOne
    private Peliculas iDpelicula;
    @JoinColumn(name = "ID_serie", referencedColumnName = "ID_Serie")
    @ManyToOne
    private Series iDserie;

    public Valoraciones() {
    }

    public Valoraciones(Integer iDvaloracion) {
        this.iDvaloracion = iDvaloracion;
    }

    public Integer getIDvaloracion() {
        return iDvaloracion;
    }

    public void setIDvaloracion(Integer iDvaloracion) {
        this.iDvaloracion = iDvaloracion;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Date getFechadelavaloracion() {
        return fechadelavaloracion;
    }

    public void setFechadelavaloracion(Date fechadelavaloracion) {
        this.fechadelavaloracion = fechadelavaloracion;
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

    public Series getIDserie() {
        return iDserie;
    }

    public void setIDserie(Series iDserie) {
        this.iDserie = iDserie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDvaloracion != null ? iDvaloracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoraciones)) {
            return false;
        }
        Valoraciones other = (Valoraciones) object;
        if ((this.iDvaloracion == null && other.iDvaloracion != null) || (this.iDvaloracion != null && !this.iDvaloracion.equals(other.iDvaloracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.watchvibe.ad.tablas.Valoraciones[ iDvaloracion=" + iDvaloracion + " ]";
    }
    
}
