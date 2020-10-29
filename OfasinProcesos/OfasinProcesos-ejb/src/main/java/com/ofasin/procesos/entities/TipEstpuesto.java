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
@Table(name = "tip_estpuesto", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipEstpuesto.findAll", query = "SELECT t FROM TipEstpuesto t")
    , @NamedQuery(name = "TipEstpuesto.findByIdtipestpuesto", query = "SELECT t FROM TipEstpuesto t WHERE t.idtipestpuesto = :idtipestpuesto")
    , @NamedQuery(name = "TipEstpuesto.findByDescrptipestpuesto", query = "SELECT t FROM TipEstpuesto t WHERE t.descrptipestpuesto = :descrptipestpuesto")})
public class TipEstpuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipestpuesto_generator")
    @SequenceGenerator(name="tipestpuesto_generator", sequenceName = "sec_tipestpuesto", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipestpuesto")
    private Long idtipestpuesto;
    @Column(name = "descrptipestpuesto")
    private String descrptipestpuesto;

    public TipEstpuesto() {
    }

    public TipEstpuesto(Long idtipestpuesto) {
        this.idtipestpuesto = idtipestpuesto;
    }

    public Long getIdtipestpuesto() {
        return idtipestpuesto;
    }

    public void setIdtipestpuesto(Long idtipestpuesto) {
        this.idtipestpuesto = idtipestpuesto;
    }

    public String getDescrptipestpuesto() {
        return descrptipestpuesto;
    }

    public void setDescrptipestpuesto(String descrptipestpuesto) {
        this.descrptipestpuesto = descrptipestpuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipestpuesto != null ? idtipestpuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipEstpuesto)) {
            return false;
        }
        TipEstpuesto other = (TipEstpuesto) object;
        if ((this.idtipestpuesto == null && other.idtipestpuesto != null) || (this.idtipestpuesto != null && !this.idtipestpuesto.equals(other.idtipestpuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipEstpuesto[ idtipestpuesto=" + idtipestpuesto + " ]";
    }
    
}
