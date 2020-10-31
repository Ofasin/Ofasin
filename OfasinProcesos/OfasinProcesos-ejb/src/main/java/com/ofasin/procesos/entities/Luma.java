/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "luma", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Luma.findAll", query = "SELECT l FROM Luma l")
    , @NamedQuery(name = "Luma.findByIdluma", query = "SELECT l FROM Luma l WHERE l.idluma = :idluma")
    , @NamedQuery(name = "Luma.findByDescrluma", query = "SELECT l FROM Luma l WHERE l.descrluma = :descrluma")
    , @NamedQuery(name = "Luma.findByFecactuliza", query = "SELECT l FROM Luma l WHERE l.fecactuliza = :fecactuliza")
    , @NamedQuery(name = "Luma.findByLatitud", query = "SELECT l FROM Luma l WHERE l.latitud = :latitud")
    , @NamedQuery(name = "Luma.findByLongitud", query = "SELECT l FROM Luma l WHERE l.longitud = :longitud")})
public class Luma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idluma")
    private Long idluma;
    @Column(name = "descrluma")
    private String descrluma;
    @Column(name = "fecactuliza")
    @Temporal(TemporalType.DATE)
    private Date fecactuliza;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private Float latitud;
    @Column(name = "longitud")
    private Float longitud;
    @JoinColumn(name = "idasociacion", referencedColumnName = "idasocicion")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asociacion idasociacion;
    @JoinColumn(name = "idresguardo", referencedColumnName = "idresguardo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Resguardo idresguardo;
    @OneToMany(mappedBy = "idluma", fetch = FetchType.LAZY)
    private List<Perfil> perfilList;
    @OneToMany(mappedBy = "luma", fetch = FetchType.LAZY)
    private List<Wayuu> wayuuList;

    public Luma() {
    }

    public Luma(Long idluma) {
        this.idluma = idluma;
    }

    public Long getIdluma() {
        return idluma;
    }

    public void setIdluma(Long idluma) {
        this.idluma = idluma;
    }

    public String getDescrluma() {
        return descrluma;
    }

    public void setDescrluma(String descrluma) {
        this.descrluma = descrluma;
    }

    public Date getFecactuliza() {
        return fecactuliza;
    }

    public void setFecactuliza(Date fecactuliza) {
        this.fecactuliza = fecactuliza;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public Asociacion getIdasociacion() {
        return idasociacion;
    }

    public void setIdasociacion(Asociacion idasociacion) {
        this.idasociacion = idasociacion;
    }

    public Resguardo getIdresguardo() {
        return idresguardo;
    }

    public void setIdresguardo(Resguardo idresguardo) {
        this.idresguardo = idresguardo;
    }

    @XmlTransient
    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
    }

    @XmlTransient
    public List<Wayuu> getWayuuList() {
        return wayuuList;
    }

    public void setWayuuList(List<Wayuu> wayuuList) {
        this.wayuuList = wayuuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idluma != null ? idluma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Luma)) {
            return false;
        }
        Luma other = (Luma) object;
        if ((this.idluma == null && other.idluma != null) || (this.idluma != null && !this.idluma.equals(other.idluma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Luma[ idluma=" + idluma + " ]";
    }
    
}
