/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;
/**
 *
 * @author Heidelber Gonzalez Iguaran
 */

public class DominioPermisos extends DominioGeneric {

    private static final long serialVersionUID = 1L;
    
    private Long idpermiso;
    private DominioMenu idmenu;
    private DominioRoll idroll;

    public DominioPermisos() {
    }

    public DominioPermisos(Long idpermiso) {
        this.idpermiso = idpermiso;
    }

    public Long getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(Long idpermiso) {
        this.idpermiso = idpermiso;
    }

    public DominioMenu getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(DominioMenu idmenu) {
        this.idmenu = idmenu;
    }

    public DominioRoll getIdroll() {
        return idroll;
    }

    public void setIdroll(DominioRoll idroll) {
        this.idroll = idroll;
    }

    
    
}
