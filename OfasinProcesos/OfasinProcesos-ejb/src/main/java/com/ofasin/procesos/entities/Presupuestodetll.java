/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "presupuestodetll", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuestodetll.findAll", query = "SELECT p FROM Presupuestodetll p")
    , @NamedQuery(name = "Presupuestodetll.findByIdperfildetll", query = "SELECT p FROM Presupuestodetll p WHERE p.idperfildetll = :idperfildetll")
    , @NamedQuery(name = "Presupuestodetll.findByCantprodct", query = "SELECT p FROM Presupuestodetll p WHERE p.cantprodct = :cantprodct")
    , @NamedQuery(name = "Presupuestodetll.findByPrecioprodct", query = "SELECT p FROM Presupuestodetll p WHERE p.precioprodct = :precioprodct")
    , @NamedQuery(name = "Presupuestodetll.findByValordetll", query = "SELECT p FROM Presupuestodetll p WHERE p.valordetll = :valordetll")
    , @NamedQuery(name = "Presupuestodetll.findByObservacion", query = "SELECT p FROM Presupuestodetll p WHERE p.observacion = :observacion")
    , @NamedQuery(name = "Presupuestodetll.findByIdsector", query = "SELECT p FROM Presupuestodetll p WHERE p.idsector = :idsector")})
public class Presupuestodetll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idperfildetll")
    private Long idperfildetll;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantprodct")
    private BigDecimal cantprodct;
    @Column(name = "precioprodct")
    private BigDecimal precioprodct;
    @Column(name = "valordetll")
    private BigDecimal valordetll;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "idsector")
    private BigInteger idsector;
    @JoinColumn(name = "idpresupuesto", referencedColumnName = "idpresupuesto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Presupuesto idpresupuesto;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idproducto;

    public Presupuestodetll() {
    }

    public Presupuestodetll(Long idperfildetll) {
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

    public Presupuesto getIdpresupuesto() {
        return idpresupuesto;
    }

    public void setIdpresupuesto(Presupuesto idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfildetll != null ? idperfildetll.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuestodetll)) {
            return false;
        }
        Presupuestodetll other = (Presupuestodetll) object;
        if ((this.idperfildetll == null && other.idperfildetll != null) || (this.idperfildetll != null && !this.idperfildetll.equals(other.idperfildetll))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Presupuestodetll[ idperfildetll=" + idperfildetll + " ]";
    }
    
}
