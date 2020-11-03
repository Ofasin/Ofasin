/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.os.ebanking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author FAGONFER
 */

public class DominioProducto extends DominioGeneric  {

    private static final long serialVersionUID = 1L;
    private Long idproducto;
    private String nombreproducto;
    private String descpproducto;
    private BigDecimal valor;
    private BigInteger idsector;
    private List<DominioPresupuestodetll> presupuestodetllList;

    public DominioProducto() {
    }

    public DominioProducto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public Long getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getDescpproducto() {
        return descpproducto;
    }

    public void setDescpproducto(String descpproducto) {
        this.descpproducto = descpproducto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigInteger getIdsector() {
        return idsector;
    }

    public void setIdsector(BigInteger idsector) {
        this.idsector = idsector;
    }

    
    public List<DominioPresupuestodetll> getPresupuestodetllList() {
        return presupuestodetllList;
    }

    public void setPresupuestodetllList(List<DominioPresupuestodetll> presupuestodetllList) {
        this.presupuestodetllList = presupuestodetllList;
    }

    
}
