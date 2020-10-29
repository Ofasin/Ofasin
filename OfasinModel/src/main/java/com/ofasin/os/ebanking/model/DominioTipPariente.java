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

public class DominioTipPariente extends DominioGeneric{

    private static final long serialVersionUID = 1L;
   
    private Long idtippariente;
    private String descrptppariente;
    private List<DominioWayuu> wayuuList;

    public DominioTipPariente() {
    }

    public DominioTipPariente(Long idtippariente) {
        this.idtippariente = idtippariente;
    }

    public DominioTipPariente(Long idtippariente, String descrptppariente) {
        this.idtippariente = idtippariente;
        this.descrptppariente = descrptppariente;
    }

    public Long getIdtippariente() {
        return idtippariente;
    }

    public void setIdtippariente(Long idtippariente) {
        this.idtippariente = idtippariente;
    }

    public String getDescrptppariente() {
        return descrptppariente;
    }

    public void setDescrptppariente(String descrptppariente) {
        this.descrptppariente = descrptppariente;
    }

   
    public List<DominioWayuu> getWayuuList() {
        return wayuuList;
    }

    public void setWayuuList(List<DominioWayuu> wayuuList) {
        this.wayuuList = wayuuList;
    }

    
    
}
