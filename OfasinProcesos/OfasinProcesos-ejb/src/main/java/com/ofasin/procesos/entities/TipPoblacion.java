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
@Table(name = "tip_poblacion", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipPoblacion.findAll", query = "SELECT t FROM TipPoblacion t")
    , @NamedQuery(name = "TipPoblacion.findByIdtippoblacion", query = "SELECT t FROM TipPoblacion t WHERE t.idtippoblacion = :idtippoblacion")
    , @NamedQuery(name = "TipPoblacion.findByDescrptippoblacion", query = "SELECT t FROM TipPoblacion t WHERE t.descrptippoblacion = :descrptippoblacion")})
public class TipPoblacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tippoblacion_generator")
    @SequenceGenerator(name="tippoblacion_generator", sequenceName = "sec_tippoblacion", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtippoblacion")
    private Long idtippoblacion;
    @Column(name = "descrptippoblacion")
    private String descrptippoblacion;

    public TipPoblacion() {
    }

    public TipPoblacion(Long idtippoblacion) {
        this.idtippoblacion = idtippoblacion;
    }

    public Long getIdtippoblacion() {
        return idtippoblacion;
    }

    public void setIdtippoblacion(Long idtippoblacion) {
        this.idtippoblacion = idtippoblacion;
    }

    public String getDescrptippoblacion() {
        return descrptippoblacion;
    }

    public void setDescrptippoblacion(String descrptippoblacion) {
        this.descrptippoblacion = descrptippoblacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtippoblacion != null ? idtippoblacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipPoblacion)) {
            return false;
        }
        TipPoblacion other = (TipPoblacion) object;
        if ((this.idtippoblacion == null && other.idtippoblacion != null) || (this.idtippoblacion != null && !this.idtippoblacion.equals(other.idtippoblacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipPoblacion[ idtippoblacion=" + idtippoblacion + " ]";
    }
    
}
