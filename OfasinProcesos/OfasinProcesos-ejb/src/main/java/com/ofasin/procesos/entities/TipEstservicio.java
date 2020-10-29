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
@Table(name = "tip_estservicio", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipEstservicio.findAll", query = "SELECT t FROM TipEstservicio t")
    , @NamedQuery(name = "TipEstservicio.findByIdtipestservicio", query = "SELECT t FROM TipEstservicio t WHERE t.idtipestservicio = :idtipestservicio")
    , @NamedQuery(name = "TipEstservicio.findByDescrptipestservicio", query = "SELECT t FROM TipEstservicio t WHERE t.descrptipestservicio = :descrptipestservicio")})
public class TipEstservicio implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipestservicio_generator")
    @SequenceGenerator(name="tipestservicio_generator", sequenceName = "sec_tipestservicio", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipestservicio")
    private Long idtipestservicio;
    @Column(name = "descrptipestservicio")
    private String descrptipestservicio;

    public TipEstservicio() {
    }

    public TipEstservicio(Long idtipestservicio) {
        this.idtipestservicio = idtipestservicio;
    }

    public Long getIdtipestservicio() {
        return idtipestservicio;
    }

    public void setIdtipestservicio(Long idtipestservicio) {
        this.idtipestservicio = idtipestservicio;
    }

    public String getDescrptipestservicio() {
        return descrptipestservicio;
    }

    public void setDescrptipestservicio(String descrptipestservicio) {
        this.descrptipestservicio = descrptipestservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipestservicio != null ? idtipestservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipEstservicio)) {
            return false;
        }
        TipEstservicio other = (TipEstservicio) object;
        if ((this.idtipestservicio == null && other.idtipestservicio != null) || (this.idtipestservicio != null && !this.idtipestservicio.equals(other.idtipestservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipEstservicio[ idtipestservicio=" + idtipestservicio + " ]";
    }
    
}
