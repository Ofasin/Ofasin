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
@Table(name = "tip_estpublicidad", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipEstpublicidad.findAll", query = "SELECT t FROM TipEstpublicidad t")
    , @NamedQuery(name = "TipEstpublicidad.findByIdtipestpublicidad", query = "SELECT t FROM TipEstpublicidad t WHERE t.idtipestpublicidad = :idtipestpublicidad")
    , @NamedQuery(name = "TipEstpublicidad.findByDescrptipestpublicidad", query = "SELECT t FROM TipEstpublicidad t WHERE t.descrptipestpublicidad = :descrptipestpublicidad")})
public class TipEstpublicidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipestpublicidad_generator")
    @SequenceGenerator(name="tipestpublicidad_generator", sequenceName = "sec_tipestpublicidad", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipestpublicidad")
    private Long idtipestpublicidad;
    @Column(name = "descrptipestpublicidad")
    private String descrptipestpublicidad;

    public TipEstpublicidad() {
    }

    public TipEstpublicidad(Long idtipestpublicidad) {
        this.idtipestpublicidad = idtipestpublicidad;
    }

    public Long getIdtipestpublicidad() {
        return idtipestpublicidad;
    }

    public void setIdtipestpublicidad(Long idtipestpublicidad) {
        this.idtipestpublicidad = idtipestpublicidad;
    }

    public String getDescrptipestpublicidad() {
        return descrptipestpublicidad;
    }

    public void setDescrptipestpublicidad(String descrptipestpublicidad) {
        this.descrptipestpublicidad = descrptipestpublicidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipestpublicidad != null ? idtipestpublicidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipEstpublicidad)) {
            return false;
        }
        TipEstpublicidad other = (TipEstpublicidad) object;
        if ((this.idtipestpublicidad == null && other.idtipestpublicidad != null) || (this.idtipestpublicidad != null && !this.idtipestpublicidad.equals(other.idtipestpublicidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipEstpublicidad[ idtipestpublicidad=" + idtipestpublicidad + " ]";
    }
    
}
