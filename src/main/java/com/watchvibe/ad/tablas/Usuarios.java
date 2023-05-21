/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchvibe.ad.tablas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author teode
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIDUsuario", query = "SELECT u FROM Usuarios u WHERE u.iDUsuario = :iDUsuario"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByCorreoelectronico", query = "SELECT u FROM Usuarios u WHERE u.correoelectronico = :correoelectronico"),
    @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuarios.findByFechaderegistro", query = "SELECT u FROM Usuarios u WHERE u.fechaderegistro = :fechaderegistro")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Usuario")
    private Integer iDUsuario;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Correo_electronico")
    private String correoelectronico;
    @Column(name = "Contrasena")
    private String contrasena;
    @Column(name = "Fecha_de_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaderegistro;
    @OneToMany(mappedBy = "iDusuario")
    private Collection<CatalogoSeries> catalogoSeriesCollection;
    @OneToMany(mappedBy = "iDusuario")
    private Collection<CatalogoPeliculas> catalogoPeliculasCollection;
    @OneToMany(mappedBy = "iDUsuario")
    private Collection<Comentarios> comentariosCollection;
    @OneToMany(mappedBy = "iDUsuarioSeguidor")
    private Collection<SeguimientoUsuarios> seguimientoUsuariosCollection;
    @OneToMany(mappedBy = "iDUsuarioSeguido")
    private Collection<SeguimientoUsuarios> seguimientoUsuariosCollection1;
    @OneToMany(mappedBy = "iDusuario")
    private Collection<Valoraciones> valoracionesCollection;

    public Usuarios() {
    }

    public Usuarios(Integer iDUsuario) {
        this.iDUsuario = iDUsuario;
    }

    public Integer getIDUsuario() {
        return iDUsuario;
    }

    public void setIDUsuario(Integer iDUsuario) {
        this.iDUsuario = iDUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaderegistro() {
        return fechaderegistro;
    }

    public void setFechaderegistro(Date fechaderegistro) {
        this.fechaderegistro = fechaderegistro;
    }

    @XmlTransient
    public Collection<CatalogoSeries> getCatalogoSeriesCollection() {
        return catalogoSeriesCollection;
    }

    public void setCatalogoSeriesCollection(Collection<CatalogoSeries> catalogoSeriesCollection) {
        this.catalogoSeriesCollection = catalogoSeriesCollection;
    }

    @XmlTransient
    public Collection<CatalogoPeliculas> getCatalogoPeliculasCollection() {
        return catalogoPeliculasCollection;
    }

    public void setCatalogoPeliculasCollection(Collection<CatalogoPeliculas> catalogoPeliculasCollection) {
        this.catalogoPeliculasCollection = catalogoPeliculasCollection;
    }

    @XmlTransient
    public Collection<Comentarios> getComentariosCollection() {
        return comentariosCollection;
    }

    public void setComentariosCollection(Collection<Comentarios> comentariosCollection) {
        this.comentariosCollection = comentariosCollection;
    }

    @XmlTransient
    public Collection<SeguimientoUsuarios> getSeguimientoUsuariosCollection() {
        return seguimientoUsuariosCollection;
    }

    public void setSeguimientoUsuariosCollection(Collection<SeguimientoUsuarios> seguimientoUsuariosCollection) {
        this.seguimientoUsuariosCollection = seguimientoUsuariosCollection;
    }

    @XmlTransient
    public Collection<SeguimientoUsuarios> getSeguimientoUsuariosCollection1() {
        return seguimientoUsuariosCollection1;
    }

    public void setSeguimientoUsuariosCollection1(Collection<SeguimientoUsuarios> seguimientoUsuariosCollection1) {
        this.seguimientoUsuariosCollection1 = seguimientoUsuariosCollection1;
    }

    @XmlTransient
    public Collection<Valoraciones> getValoracionesCollection() {
        return valoracionesCollection;
    }

    public void setValoracionesCollection(Collection<Valoraciones> valoracionesCollection) {
        this.valoracionesCollection = valoracionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDUsuario != null ? iDUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.iDUsuario == null && other.iDUsuario != null) || (this.iDUsuario != null && !this.iDUsuario.equals(other.iDUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.watchvibe.ad.tablas.Usuarios[ iDUsuario=" + iDUsuario + " ]";
    }
    
}
