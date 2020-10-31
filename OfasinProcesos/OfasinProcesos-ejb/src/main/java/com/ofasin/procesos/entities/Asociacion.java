/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "asociacion", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asociacion.findAll", query = "SELECT a FROM Asociacion a")
    , @NamedQuery(name = "Asociacion.findByIdasocicion", query = "SELECT a FROM Asociacion a WHERE a.idasocicion = :idasocicion")
    , @NamedQuery(name = "Asociacion.findByIdmunicipio", query = "SELECT a FROM Asociacion a WHERE a.idmunicipio = :idmunicipio")
    , @NamedQuery(name = "Asociacion.findByNombre", query = "SELECT a FROM Asociacion a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Asociacion.findByTelefono", query = "SELECT a FROM Asociacion a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Asociacion.findByDireccion", query = "SELECT a FROM Asociacion a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Asociacion.findByBarrio", query = "SELECT a FROM Asociacion a WHERE a.barrio = :barrio")})
public class Asociacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idasocicion")
    private Long idasocicion;
    @Column(name = "idmunicipio")
    private BigInteger idmunicipio;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "barrio")
    private String barrio;
    @OneToMany(mappedBy = "idasociacion", fetch = FetchType.LAZY)
    private List<Luma> lumaList;

    public Asociacion() {
    }

    public Asociacion(Long idasocicion) {
        this.idasocicion = idasocicion;
    }

    public Long getIdasocicion() {
        return idasocicion;
    }

    public void setIdasocicion(Long idasocicion) {
        this.idasocicion = idasocicion;
    }

    public BigInteger getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(BigInteger idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @XmlTransient
    public List<Luma> getLumaList() {
        return lumaList;
    }

    public void setLumaList(List<Luma> lumaList) {
        this.lumaList = lumaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasocicion != null ? idasocicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asociacion)) {
            return false;
        }
        Asociacion other = (Asociacion) object;
        if ((this.idasocicion == null && other.idasocicion != null) || (this.idasocicion != null && !this.idasocicion.equals(other.idasocicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Asociacion[ idasocicion=" + idasocicion + " ]";
    }
    
}
