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
 * @author FAGONFER
 */

public class DominioPresupuesto extends DominioGeneric  {

    private static final long serialVersionUID = 1L;
    
    private Long idpresupuesto;
    private String obs;
    private List<DominioPresupuestodetll> presupuestodetllList;
    private DominioPerfil idperfil;
    private DominioSector idsector;

    public DominioPresupuesto() {
    }

    public DominioPresupuesto(Long idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public Long getIdpresupuesto() {
        return idpresupuesto;
    }

    public void setIdpresupuesto(Long idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    
    public List<DominioPresupuestodetll> getPresupuestodetllList() {
        return presupuestodetllList;
    }

    public void setPresupuestodetllList(List<DominioPresupuestodetll> presupuestodetllList) {
        this.presupuestodetllList = presupuestodetllList;
    }

    public DominioPerfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(DominioPerfil idperfil) {
        this.idperfil = idperfil;
    }

    public DominioSector getIdsector() {
        return idsector;
    }

    public void setIdsector(DominioSector idsector) {
        this.idsector = idsector;
    }

    
    
}
