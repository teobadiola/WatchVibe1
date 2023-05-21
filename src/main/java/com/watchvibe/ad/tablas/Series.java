/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.watchvibe.ad.tablas;

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
@Table(name = "series")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Series.findAll", query = "SELECT s FROM Series s"),
    @NamedQuery(name = "Series.findByIDSerie", query = "SELECT s FROM Series s WHERE s.iDSerie = :iDSerie"),
    @NamedQuery(name = "Series.findByTitulo", query = "SELECT s FROM Series s WHERE s.titulo = :titulo"),
    @NamedQuery(name = "Series.findByDirector", query = "SELECT s FROM Series s WHERE s.director = :director"),
    @NamedQuery(name = "Series.findByAnio", query = "SELECT s FROM Series s WHERE s.anio = :anio"),
    @NamedQuery(name = "Series.findByGenero", query = "SELECT s FROM Series s WHERE s.genero = :genero"),
    @NamedQuery(name = "Series.findByNumtemporadas", query = "SELECT s FROM Series s WHERE s.numtemporadas = :numtemporadas"),
    @NamedQuery(name = "Series.findByEstado", query = "SELECT s FROM Series s WHERE s.estado = :estado"),
    @NamedQuery(name = "Series.findByFotodePortada", query = "SELECT s FROM Series s WHERE s.fotodePortada = :fotodePortada")})
public class Series implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Serie")
    private Integer iDSerie;
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
    @Column(name = "Num_temporadas")
    private Integer numtemporadas;
    @Column(name = "Estado")
    private String estado;
    @Column(name = "Foto_de_Portada")
    private String fotodePortada;
    @OneToMany(mappedBy = "iDserie")
    private Collection<CatalogoSeries> catalogoSeriesCollection;
    @OneToMany(mappedBy = "iDSerie")
    private Collection<Comentarios> comentariosCollection;
    @OneToMany(mappedBy = "iDserie")
    private Collection<Valoraciones> valoracionesCollection;

    public Series() {
    }

    public Series(Integer iDSerie) {
        this.iDSerie = iDSerie;
    }

    public Integer getIDSerie() {
        return iDSerie;
    }

    public void setIDSerie(Integer iDSerie) {
        this.iDSerie = iDSerie;
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

    public Integer getNumtemporadas() {
        return numtemporadas;
    }

    public void setNumtemporadas(Integer numtemporadas) {
        this.numtemporadas = numtemporadas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFotodePortada() {
        return fotodePortada;
    }

    public void setFotodePortada(String fotodePortada) {
        this.fotodePortada = fotodePortada;
    }

    @XmlTransient
    public Collection<CatalogoSeries> getCatalogoSeriesCollection() {
        return catalogoSeriesCollection;
    }

    public void setCatalogoSeriesCollection(Collection<CatalogoSeries> catalogoSeriesCollection) {
        this.catalogoSeriesCollection = catalogoSeriesCollection;
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
        hash += (iDSerie != null ? iDSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Series)) {
            return false;
        }
        Series other = (Series) object;
        if ((this.iDSerie == null && other.iDSerie != null) || (this.iDSerie != null && !this.iDSerie.equals(other.iDSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.watchvibe.ad.tablas.Series[ iDSerie=" + iDSerie + " ]";
    }
    
}
