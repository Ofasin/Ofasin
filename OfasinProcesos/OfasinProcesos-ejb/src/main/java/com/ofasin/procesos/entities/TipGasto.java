/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tip_gasto", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipGasto.findAll", query = "SELECT t FROM TipGasto t")
    , @NamedQuery(name = "TipGasto.findByIdtipgasto", query = "SELECT t FROM TipGasto t WHERE t.idtipgasto = :idtipgasto")
    , @NamedQuery(name = "TipGasto.findByDescrptipgasto", query = "SELECT t FROM TipGasto t WHERE t.descrptipgasto = :descrptipgasto")})
public class TipGasto implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipgasto_generator")
    @SequenceGenerator(name="tipgasto_generator", sequenceName = "sec_tipgasto", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipgasto")
    private Long idtipgasto;
    @Basic(optional = false)
    @Column(name = "descrptipgasto")
    private String descrptipgasto;

    public TipGasto() {
    }

    public TipGasto(Long idtipgasto) {
        this.idtipgasto = idtipgasto;
    }

    public TipGasto(Long idtipgasto, String descrptipgasto) {
        this.idtipgasto = idtipgasto;
        this.descrptipgasto = descrptipgasto;
    }

    public Long getIdtipgasto() {
        return idtipgasto;
    }

    public void setIdtipgasto(Long idtipgasto) {
        this.idtipgasto = idtipgasto;
    }

    public String getDescrptipgasto() {
        return descrptipgasto;
    }

    public void setDescrptipgasto(String descrptipgasto) {
        this.descrptipgasto = descrptipgasto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipgasto != null ? idtipgasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipGasto)) {
            return false;
        }
        TipGasto other = (TipGasto) object;
        if ((this.idtipgasto == null && other.idtipgasto != null) || (this.idtipgasto != null && !this.idtipgasto.equals(other.idtipgasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipGasto[ idtipgasto=" + idtipgasto + " ]";
    }
    
}
