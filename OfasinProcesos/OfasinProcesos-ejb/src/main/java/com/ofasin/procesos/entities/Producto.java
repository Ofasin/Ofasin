/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "producto", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto")
    , @NamedQuery(name = "Producto.findByNombreproducto", query = "SELECT p FROM Producto p WHERE p.nombreproducto = :nombreproducto")
    , @NamedQuery(name = "Producto.findByDescpproducto", query = "SELECT p FROM Producto p WHERE p.descpproducto = :descpproducto")
    , @NamedQuery(name = "Producto.findByValor", query = "SELECT p FROM Producto p WHERE p.valor = :valor")
    , @NamedQuery(name = "Producto.findByIdsector", query = "SELECT p FROM Producto p WHERE p.idsector = :idsector")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Long idproducto;
    @Column(name = "nombreproducto")
    private String nombreproducto;
    @Column(name = "descpproducto")
    private String descpproducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "idsector")
    private BigInteger idsector;
    @OneToMany(mappedBy = "idproducto", fetch = FetchType.LAZY)
    private List<Presupuestodetll> presupuestodetllList;

    public Producto() {
    }

    public Producto(Long idproducto) {
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

    @XmlTransient
    public List<Presupuestodetll> getPresupuestodetllList() {
        return presupuestodetllList;
    }

    public void setPresupuestodetllList(List<Presupuestodetll> presupuestodetllList) {
        this.presupuestodetllList = presupuestodetllList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
