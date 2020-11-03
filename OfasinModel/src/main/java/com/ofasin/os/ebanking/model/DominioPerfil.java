/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FAGONFER
 */

public class DominioPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long idperfil;
    private String descrpperfil;
    private Date fecradica;
    private String contratista;
    private BigDecimal techopresp;
    private BigDecimal monto;
    private Date vigencia;
    private String obs;
    private List<DominioPresupuesto> presupuestoList;
    private DominioLuma idluma;

    public DominioPerfil() {
    }

    public DominioPerfil(Long idperfil) {
        this.idperfil = idperfil;
    }

    public Long getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Long idperfil) {
        this.idperfil = idperfil;
    }

    public String getDescrpperfil() {
        return descrpperfil;
    }

    public void setDescrpperfil(String descrpperfil) {
        this.descrpperfil = descrpperfil;
    }

    public Date getFecradica() {
        return fecradica;
    }

    public void setFecradica(Date fecradica) {
        this.fecradica = fecradica;
    }

    public String getContratista() {
        return contratista;
    }

    public void setContratista(String contratista) {
        this.contratista = contratista;
    }

    public BigDecimal getTechopresp() {
        return techopresp;
    }

    public void setTechopresp(BigDecimal techopresp) {
        this.techopresp = techopresp;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

   
    public List<DominioPresupuesto> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<DominioPresupuesto> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }

    public DominioLuma getIdluma() {
        return idluma;
    }

    public void setIdluma(DominioLuma idluma) {
        this.idluma = idluma;
    }

  
    
}
