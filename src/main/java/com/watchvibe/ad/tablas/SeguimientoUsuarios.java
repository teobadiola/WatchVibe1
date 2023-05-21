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
@Table(name = "seguimiento_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoUsuarios.findAll", query = "SELECT s FROM SeguimientoUsuarios s"),
    @NamedQuery(name = "SeguimientoUsuarios.findByIDseguimiento", query = "SELECT s FROM SeguimientoUsuarios s WHERE s.iDseguimiento = :iDseguimiento"),
    @NamedQuery(name = "SeguimientoUsuarios.findByFechadeseguimiento", query = "SELECT s FROM SeguimientoUsuarios s WHERE s.fechadeseguimiento = :fechadeseguimiento")})
public class SeguimientoUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_seguimiento")
    private Integer iDseguimiento;
    @Column(name = "Fecha_de_seguimiento")
    @Temporal(TemporalType.DATE)
    private Date fechadeseguimiento;
    @JoinColumn(name = "ID_Usuario_Seguidor", referencedColumnName = "ID_Usuario")
    @ManyToOne
    private Usuarios iDUsuarioSeguidor;
    @JoinColumn(name = "ID_Usuario_Seguido", referencedColumnName = "ID_Usuario")
    @ManyToOne
    private Usuarios iDUsuarioSeguido;

    public SeguimientoUsuarios() {
    }

    public SeguimientoUsuarios(Integer iDseguimiento) {
        this.iDseguimiento = iDseguimiento;
    }

    public Integer getIDseguimiento() {
        return iDseguimiento;
    }

    public void setIDseguimiento(Integer iDseguimiento) {
        this.iDseguimiento = iDseguimiento;
    }

    public Date getFechadeseguimiento() {
        return fechadeseguimiento;
    }

    public void setFechadeseguimiento(Date fechadeseguimiento) {
        this.fechadeseguimiento = fechadeseguimiento;
    }

    public Usuarios getIDUsuarioSeguidor() {
        return iDUsuarioSeguidor;
    }

    public void setIDUsuarioSeguidor(Usuarios iDUsuarioSeguidor) {
        this.iDUsuarioSeguidor = iDUsuarioSeguidor;
    }

    public Usuarios getIDUsuarioSeguido() {
        return iDUsuarioSeguido;
    }

    public void setIDUsuarioSeguido(Usuarios iDUsuarioSeguido) {
        this.iDUsuarioSeguido = iDUsuarioSeguido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDseguimiento != null ? iDseguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoUsuarios)) {
            return false;
        }
        SeguimientoUsuarios other = (SeguimientoUsuarios) object;
        if ((this.iDseguimiento == null && other.iDseguimiento != null) || (this.iDseguimiento != null && !this.iDseguimiento.equals(other.iDseguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.watchvibe.ad.tablas.SeguimientoUsuarios[ iDseguimiento=" + iDseguimiento + " ]";
    }
    
}
