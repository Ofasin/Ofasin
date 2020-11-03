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

public class DominioIrruko extends DominioGeneric  {

    private static final long serialVersionUID = 1L;
    
    private Long idirruko;
    private String descrp;
    private List<DominioWayuu> wayuuList;

    public DominioIrruko() {
    }

    public DominioIrruko(Long idirruko) {
        this.idirruko = idirruko;
    }

    public Long getIdirruko() {
        return idirruko;
    }

    public void setIdirruko(Long idirruko) {
        this.idirruko = idirruko;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public List<DominioWayuu> getWayuuList() {
        return wayuuList;
    }

    public void setWayuuList(List<DominioWayuu> wayuuList) {
        this.wayuuList = wayuuList;
    }

    
}
