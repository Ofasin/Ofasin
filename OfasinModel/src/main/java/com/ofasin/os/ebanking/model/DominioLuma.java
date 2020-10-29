/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Heidelber Gonzalez Iguaran
 */
public class DominioLuma extends DominioGeneric {

    private static final long serialVersionUID = 1L;
  
    private Long idluma;
    private String descrluma;
    private Date fecactuliza;
    private Float latitud;
    private Float longitud;
    private DominioAsociacion idasociacion;
    private DominioResguardo idresguardo;
    private List<DominioPerfil> perfilList;
    private List<DominioWayuu> wayuuList;

    public DominioLuma() {
    }

    public DominioLuma(Long idluma) {
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

    public DominioAsociacion getIdasociacion() {
        return idasociacion;
    }

    public void setIdasociacion(DominioAsociacion idasociacion) {
        this.idasociacion = idasociacion;
    }

    public DominioResguardo getIdresguardo() {
        return idresguardo;
    }

    public void setIdresguardo(DominioResguardo idresguardo) {
        this.idresguardo = idresguardo;
    }

    
    public List<DominioPerfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<DominioPerfil> perfilList) {
        this.perfilList = perfilList;
    }

    
    public List<DominioWayuu> getWayuuList() {
        return wayuuList;
    }

    public void setWayuuList(List<DominioWayuu> wayuuList) {
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
        if (!(object instanceof DominioLuma)) {
            return false;
        }
        DominioLuma other = (DominioLuma) object;
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
