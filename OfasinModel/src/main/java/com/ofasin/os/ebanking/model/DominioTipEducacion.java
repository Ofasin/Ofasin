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
public class DominioTipEducacion extends DominioGeneric {

    private static final long serialVersionUID = 1L;
    
    private Long idtipeducacion;
    private String descrptipeducacion;
    private List<DominioWayuu> wayuuList;

    public DominioTipEducacion() {
    }

    public DominioTipEducacion(Long idtipeducacion) {
        this.idtipeducacion = idtipeducacion;
    }

    public DominioTipEducacion(Long idtipeducacion, String descrptipeducacion) {
        this.idtipeducacion = idtipeducacion;
        this.descrptipeducacion = descrptipeducacion;
    }

    public Long getIdtipeducacion() {
        return idtipeducacion;
    }

    public void setIdtipeducacion(Long idtipeducacion) {
        this.idtipeducacion = idtipeducacion;
    }

    public String getDescrptipeducacion() {
        return descrptipeducacion;
    }

    public void setDescrptipeducacion(String descrptipeducacion) {
        this.descrptipeducacion = descrptipeducacion;
    }

   
    public List<DominioWayuu> getWayuuList() {
        return wayuuList;
    }

    public void setWayuuList(List<DominioWayuu> wayuuList) {
        this.wayuuList = wayuuList;
    }

    
    
}
