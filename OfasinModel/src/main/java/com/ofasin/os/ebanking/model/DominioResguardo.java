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

public class DominioResguardo extends DominioGeneric {

    private static final long serialVersionUID = 1L;
    private Long idresguardo;
    private String descrip;
    private List<DominioLuma> lumaList;

    public DominioResguardo() {
    }

    public DominioResguardo(Long idresguardo) {
        this.idresguardo = idresguardo;
    }

    public DominioResguardo(Long idresguardo, String descrip) {
        this.idresguardo = idresguardo;
        this.descrip = descrip;
    }

    public Long getIdresguardo() {
        return idresguardo;
    }

    public void setIdresguardo(Long idresguardo) {
        this.idresguardo = idresguardo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

   
    public List<DominioLuma> getLumaList() {
        return lumaList;
    }

    public void setLumaList(List<DominioLuma> lumaList) {
        this.lumaList = lumaList;
    }

   
    
}
