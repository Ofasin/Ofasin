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

public class DominioSector extends DominioGeneric  {

    private static final long serialVersionUID = 1L;
    
    private Long idsector;
    private String descrp;
    private List<DominioPresupuesto> presupuestoList;

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

    
    public List<DominioPresupuesto> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<DominioPresupuesto> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }

   
    
}
