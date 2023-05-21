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
@Table(name = "catalogo_series")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoSeries.findAll", query = "SELECT c FROM CatalogoSeries c"),
    @NamedQuery(name = "CatalogoSeries.findByIDCat", query = "SELECT c FROM CatalogoSeries c WHERE c.iDCat = :iDCat"),
    @NamedQuery(name = "CatalogoSeries.findByFechadeanadido", query = "SELECT c FROM CatalogoSeries c WHERE c.fechadeanadido = :fechadeanadido")})
public class CatalogoSeries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Cat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDCat;
    @Column(name = "Fecha_de_anadido")
    @Temporal(TemporalType.DATE)
    private Date fechadeanadido;
    @JoinColumn(name = "ID_usuario", referencedColumnName = "ID_Usuario")
    @ManyToOne
    private Usuarios iDusuario;
    @JoinColumn(name = "ID_serie", referencedColumnName = "ID_Serie")
    @ManyToOne
    private Series iDserie;

    public CatalogoSeries() {
    }

    public CatalogoSeries(Integer iDCat) {
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

    public Series getIDserie() {
        return iDserie;
    }

    public void setIDserie(Series iDserie) {
        this.iDserie = iDserie;
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
        if (!(object instanceof CatalogoSeries)) {
            return false;
        }
        CatalogoSeries other = (CatalogoSeries) object;
        if ((this.iDCat == null && other.iDCat != null) || (this.iDCat != null && !this.iDCat.equals(other.iDCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.watchvibe.ad.tablas.CatalogoSeries[ iDCat=" + iDCat + " ]";
    }
    
}
