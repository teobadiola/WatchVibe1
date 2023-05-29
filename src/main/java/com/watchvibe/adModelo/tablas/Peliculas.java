/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchvibe.adModelo.tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author teode
 */
@Entity
@Table(name = "peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peliculas.findAll", query = "SELECT p FROM Peliculas p"),
    @NamedQuery(name = "Peliculas.findByIDPelicula", query = "SELECT p FROM Peliculas p WHERE p.iDPelicula = :iDPelicula"),
    @NamedQuery(name = "Peliculas.findByTitulo", query = "SELECT p FROM Peliculas p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Peliculas.findByDirector", query = "SELECT p FROM Peliculas p WHERE p.director = :director"),
    @NamedQuery(name = "Peliculas.findByAnio", query = "SELECT p FROM Peliculas p WHERE p.anio = :anio"),
    @NamedQuery(name = "Peliculas.findByGenero", query = "SELECT p FROM Peliculas p WHERE p.genero = :genero"),
    @NamedQuery(name = "Peliculas.findByFotodePortada", query = "SELECT p FROM Peliculas p WHERE p.fotodePortada = :fotodePortada")})
public class Peliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Pelicula")
    private Integer iDPelicula;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Director")
    private String director;
    @Column(name = "Anio")
    private Integer anio;
    @Column(name = "Genero")
    private String genero;
    @Lob
    @Column(name = "Sinopsis")
    private String sinopsis;
    @Column(name = "Foto_de_Portada")
    private String fotodePortada;
    @OneToMany(mappedBy = "iDpelicula")
    private Collection<CatalogoPeliculas> catalogoPeliculasCollection;
    @OneToMany(mappedBy = "iDPelicula")
    private Collection<Comentarios> comentariosCollection;
    @OneToMany(mappedBy = "iDpelicula")
    private Collection<Valoraciones> valoracionesCollection;

    public Peliculas() {
    }

    public Peliculas(String titulo, Integer anio, String sinopsis, String fotodePortada) {
        this.titulo = titulo;
        this.anio = anio;
        this.sinopsis = sinopsis;
        this.fotodePortada = fotodePortada;
    }

    public Peliculas(String titulo, Integer anio, String fotodePortada) {
        this.titulo = titulo;
        this.anio = anio;
        this.fotodePortada = fotodePortada;
    }

    public Peliculas(Integer iDPelicula) {
        this.iDPelicula = iDPelicula;
    }

    public Integer getIDPelicula() {
        return iDPelicula;
    }

    public void setIDPelicula(Integer iDPelicula) {
        this.iDPelicula = iDPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getFotodePortada() {
        return fotodePortada;
    }

    public void setFotodePortada(String fotodePortada) {
        this.fotodePortada = fotodePortada;
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
    public Collection<Valoraciones> getValoracionesCollection() {
        return valoracionesCollection;
    }

    public void setValoracionesCollection(Collection<Valoraciones> valoracionesCollection) {
        this.valoracionesCollection = valoracionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPelicula != null ? iDPelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peliculas)) {
            return false;
        }
        Peliculas other = (Peliculas) object;
        if ((this.iDPelicula == null && other.iDPelicula != null) || (this.iDPelicula != null && !this.iDPelicula.equals(other.iDPelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Peliculas{" +
                "titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", sinopsis='" + sinopsis + '\'' +
                ", fotodePortada='" + fotodePortada + '\'' +
                '}';
    }
}
