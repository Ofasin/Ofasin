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

public class DominioTipOcupacion extends DominioGeneric{

    private static final long serialVersionUID = 1L;
   
    private Long idtipocupacion;
    private String decrptipocupacion;
    private List<DominioWayuu> wayuuList;

    public DominioTipOcupacion() {
    }

    public DominioTipOcupacion(Long idtipocupacion) {
        this.idtipocupacion = idtipocupacion;
    }

    public DominioTipOcupacion(Long idtipocupacion, String decrptipocupacion) {
        this.idtipocupacion = idtipocupacion;
        this.decrptipocupacion = decrptipocupacion;
    }

    public Long getIdtipocupacion() {
        return idtipocupacion;
    }

    public void setIdtipocupacion(Long idtipocupacion) {
        this.idtipocupacion = idtipocupacion;
    }

    public String getDecrptipocupacion() {
        return decrptipocupacion;
    }

    public void setDecrptipocupacion(String decrptipocupacion) {
        this.decrptipocupacion = decrptipocupacion;
    }


    public List<DominioWayuu> getWayuuList() {
        return wayuuList;
    }

    public void setWayuuList(List<DominioWayuu> wayuuList) {
        this.wayuuList = wayuuList;
    }

   
    
}
