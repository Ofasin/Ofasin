/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
/**
 *
 * @author FAGONFER
 */

public class DominioPresupuestodetll extends DominioGeneric  {

    private static final long serialVersionUID = 1L;
    
    private Long idperfildetll;
    private BigDecimal cantprodct;
    private BigDecimal precioprodct;
    private BigDecimal valordetll;
    private String observacion;
    private BigInteger idsector;
    private DominioPresupuesto idpresupuesto;
    private DominioProducto idproducto;

    public DominioPresupuestodetll() {
    }

    public DominioPresupuestodetll(Long idperfildetll) {
        this.idperfildetll = idperfildetll;
    }

    public Long getIdperfildetll() {
        return idperfildetll;
    }

    public void setIdperfildetll(Long idperfildetll) {
        this.idperfildetll = idperfildetll;
    }

    public BigDecimal getCantprodct() {
        return cantprodct;
    }

    public void setCantprodct(BigDecimal cantprodct) {
        this.cantprodct = cantprodct;
    }

    public BigDecimal getPrecioprodct() {
        return precioprodct;
    }

    public void setPrecioprodct(BigDecimal precioprodct) {
        this.precioprodct = precioprodct;
    }

    public BigDecimal getValordetll() {
        return valordetll;
    }

    public void setValordetll(BigDecimal valordetll) {
        this.valordetll = valordetll;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigInteger getIdsector() {
        return idsector;
    }

    public void setIdsector(BigInteger idsector) {
        this.idsector = idsector;
    }

    public DominioPresupuesto getIdpresupuesto() {
        return idpresupuesto;
    }

    public void setIdpresupuesto(DominioPresupuesto idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public DominioProducto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(DominioProducto idproducto) {
        this.idproducto = idproducto;
    }

  
    
}
