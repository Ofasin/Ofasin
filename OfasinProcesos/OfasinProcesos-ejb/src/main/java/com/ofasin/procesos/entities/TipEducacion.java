/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ofasin.procesos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAGONFER
 */
@Entity
@Table(name = "tip_educacion", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipEducacion.findAll", query = "SELECT t FROM TipEducacion t")
    , @NamedQuery(name = "TipEducacion.findByIdtipeducacion", query = "SELECT t FROM TipEducacion t WHERE t.idtipeducacion = :idtipeducacion")
    , @NamedQuery(name = "TipEducacion.findByDescrptipeducacion", query = "SELECT t FROM TipEducacion t WHERE t.descrptipeducacion = :descrptipeducacion")})
public class TipEducacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipeducacion_generator")
    @SequenceGenerator(name="tipeducacion_generator", sequenceName = "sec_tipeducacion", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipeducacion")
    private Long idtipeducacion;
    @Basic(optional = false)
    @Column(name = "descrptipeducacion")
    private String descrptipeducacion;
    @OneToMany(mappedBy = "tipEdu")
    private List<Wayuu> wayuuList;

    public TipEducacion() {
    }

    public TipEducacion(Long idtipeducacion) {
        this.idtipeducacion = idtipeducacion;
    }

    public TipEducacion(Long idtipeducacion, String descrptipeducacion) {
        this.idtipeducacion = idtipeducacion;
        this.descrptipeducacion = descrptipeducacion;
    }

    public Long getIdtipeducacion() {
        return idtipeducacion;
    }

    public void setIdtipeducacion(Long idtipeducacion) {
        this.idtipeducacion = idtipeducacion;
    }

    public String getDescrptipeducacion() {
        return descrptipeducacion;
    }

    public void setDescrptipeducacion(String descrptipeducacion) {
        this.descrptipeducacion = descrptipeducacion;
    }

    @XmlTransient
    public List<Wayuu> getWayuuList() {
        return wayuuList;
    }

    public void setWayuuList(List<Wayuu> wayuuList) {
        this.wayuuList = wayuuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipeducacion != null ? idtipeducacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipEducacion)) {
            return false;
        }
        TipEducacion other = (TipEducacion) object;
        if ((this.idtipeducacion == null && other.idtipeducacion != null) || (this.idtipeducacion != null && !this.idtipeducacion.equals(other.idtipeducacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipEducacion[ idtipeducacion=" + idtipeducacion + " ]";
    }
    
}
