/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "perfildetll", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfildetll.findAll", query = "SELECT p FROM Perfildetll p")
    , @NamedQuery(name = "Perfildetll.findByIdperfildetll", query = "SELECT p FROM Perfildetll p WHERE p.idperfildetll = :idperfildetll")
    , @NamedQuery(name = "Perfildetll.findByCantprodct", query = "SELECT p FROM Perfildetll p WHERE p.cantprodct = :cantprodct")
    , @NamedQuery(name = "Perfildetll.findByPrecioprodct", query = "SELECT p FROM Perfildetll p WHERE p.precioprodct = :precioprodct")
    , @NamedQuery(name = "Perfildetll.findByValordetll", query = "SELECT p FROM Perfildetll p WHERE p.valordetll = :valordetll")
    , @NamedQuery(name = "Perfildetll.findByObservacion", query = "SELECT p FROM Perfildetll p WHERE p.observacion = :observacion")})
public class Perfildetll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfildetll_generator")
    @SequenceGenerator(name="perfildetll_generator", sequenceName = "sec_perfildetll", allocationSize=1)
    @Basic(optional = false)
    @NotNull
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
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil")
    @ManyToOne
    private Perfil idperfil;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne
    private Producto idproducto;
    @JoinColumn(name = "idsector", referencedColumnName = "idsector")
    @ManyToOne
    private Sector idsector;

    public Perfildetll() {
    }

    public Perfildetll(Long idperfildetll) {
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

    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
        this.idperfil = idperfil;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public Sector getIdsector() {
        return idsector;
    }

    public void setIdsector(Sector idsector) {
        this.idsector = idsector;
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
        if (!(object instanceof Perfildetll)) {
            return false;
        }
        Perfildetll other = (Perfildetll) object;
        if ((this.idperfildetll == null && other.idperfildetll != null) || (this.idperfildetll != null && !this.idperfildetll.equals(other.idperfildetll))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Perfildetll[ idperfildetll=" + idperfildetll + " ]";
    }
    
}
