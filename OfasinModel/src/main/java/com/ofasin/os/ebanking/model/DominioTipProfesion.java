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

public class DominioTipProfesion extends DominioGeneric {

    private static final long serialVersionUID = 1L;
    private Long idtipprofesion;
    private String descrpprofesion;
    private Date fecdia;
    private List<DominioWayuu> wayuuList;

    public DominioTipProfesion() {
    }

    public DominioTipProfesion(Long idtipprofesion) {
        this.idtipprofesion = idtipprofesion;
    }

    public DominioTipProfesion(Long idtipprofesion, String descrpprofesion) {
        this.idtipprofesion = idtipprofesion;
        this.descrpprofesion = descrpprofesion;
    }

    public Long getIdtipprofesion() {
        return idtipprofesion;
    }

    public void setIdtipprofesion(Long idtipprofesion) {
        this.idtipprofesion = idtipprofesion;
    }

    public String getDescrpprofesion() {
        return descrpprofesion;
    }

    public void setDescrpprofesion(String descrpprofesion) {
        this.descrpprofesion = descrpprofesion;
    }

    public Date getFecdia() {
        return fecdia;
    }

    public void setFecdia(Date fecdia) {
        this.fecdia = fecdia;
    }

    
    public List<DominioWayuu> getWayuuList() {
        return wayuuList;
    }

    public void setWayuuList(List<DominioWayuu> wayuuList) {
        this.wayuuList = wayuuList;
    }

   
    
}
