/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Heidelber Gonzalez Iguaran
 */

public class DominioSector extends DominioGeneric {

    private static final long serialVersionUID = 1L;
    
    private Long idsector;
    private String descrp;
    private List<DominioPerfildetll> perfildetllList;

    public DominioSector() {
    }

    public DominioSector(Long idsector) {
        this.idsector = idsector;
    }

    public Long getIdsector() {
        return idsector;
    }

    public void setIdsector(Long idsector) {
        this.idsector = idsector;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

   
    public List<DominioPerfildetll> getPerfildetllList() {
        return perfildetllList;
    }

    public void setPerfildetllList(List<DominioPerfildetll> perfildetllList) {
        this.perfildetllList = perfildetllList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsector != null ? idsector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DominioSector)) {
            return false;
        }
        DominioSector other = (DominioSector) object;
        if ((this.idsector == null && other.idsector != null) || (this.idsector != null && !this.idsector.equals(other.idsector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Sector[ idsector=" + idsector + " ]";
    }
    
}
