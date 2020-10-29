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
@Table(name = "tip_publicidad", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipPublicidad.findAll", query = "SELECT t FROM TipPublicidad t")
    , @NamedQuery(name = "TipPublicidad.findByIdtippublicidad", query = "SELECT t FROM TipPublicidad t WHERE t.idtippublicidad = :idtippublicidad")
    , @NamedQuery(name = "TipPublicidad.findByDescrptippublicidad", query = "SELECT t FROM TipPublicidad t WHERE t.descrptippublicidad = :descrptippublicidad")})
public class TipPublicidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tippublicidad_generator")
    @SequenceGenerator(name="tippublicidad_generator", sequenceName = "sec_tippublicidad", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtippublicidad")
    private Long idtippublicidad;
    @Column(name = "descrptippublicidad")
    private String descrptippublicidad;

    public TipPublicidad() {
    }

    public TipPublicidad(Long idtippublicidad) {
        this.idtippublicidad = idtippublicidad;
    }

    public Long getIdtippublicidad() {
        return idtippublicidad;
    }

    public void setIdtippublicidad(Long idtippublicidad) {
        this.idtippublicidad = idtippublicidad;
    }

    public String getDescrptippublicidad() {
        return descrptippublicidad;
    }

    public void setDescrptippublicidad(String descrptippublicidad) {
        this.descrptippublicidad = descrptippublicidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtippublicidad != null ? idtippublicidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipPublicidad)) {
            return false;
        }
        TipPublicidad other = (TipPublicidad) object;
        if ((this.idtippublicidad == null && other.idtippublicidad != null) || (this.idtippublicidad != null && !this.idtippublicidad.equals(other.idtippublicidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipPublicidad[ idtippublicidad=" + idtippublicidad + " ]";
    }
    
}
