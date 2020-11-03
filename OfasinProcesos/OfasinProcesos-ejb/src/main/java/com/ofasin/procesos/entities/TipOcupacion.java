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
 * @author Heidelber Gonzalez Iguaran
 */
@Entity
@Table(name = "tip_ocupacion", catalog = "ofasin", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipOcupacion.findAll", query = "SELECT t FROM TipOcupacion t")
    , @NamedQuery(name = "TipOcupacion.findByIdtipocupacion", query = "SELECT t FROM TipOcupacion t WHERE t.idtipocupacion = :idtipocupacion")
    , @NamedQuery(name = "TipOcupacion.findByDecrptipocupacion", query = "SELECT t FROM TipOcupacion t WHERE t.decrptipocupacion = :decrptipocupacion")})
public class TipOcupacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipocupacion_generator")
    @SequenceGenerator(name="tipocupacion_generator", sequenceName = "sec_tipocupacion", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipocupacion")
    private Long idtipocupacion;
    @Basic(optional = false)
    @Column(name = "decrptipocupacion")
    private String decrptipocupacion;
    @OneToMany(mappedBy = "tipOcupacion")
    private List<Wayuu> wayuuList;

    public TipOcupacion() {
    }

    public TipOcupacion(Long idtipocupacion) {
        this.idtipocupacion = idtipocupacion;
    }

    public TipOcupacion(Long idtipocupacion, String decrptipocupacion) {
        this.idtipocupacion = idtipocupacion;
        this.decrptipocupacion = decrptipocupacion;
    }

    public Long getIdtipocupacion() {
        return idtipocupacion;
    }

    public void setIdtipocupacion(Long idtipocupacion) {
        this.idtipocupacion = idtipocupacion;
    }

    public String getDecrptipocupacion() {
        return decrptipocupacion;
    }

    public void setDecrptipocupacion(String decrptipocupacion) {
        this.decrptipocupacion = decrptipocupacion;
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
        hash += (idtipocupacion != null ? idtipocupacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipOcupacion)) {
            return false;
        }
        TipOcupacion other = (TipOcupacion) object;
        if ((this.idtipocupacion == null && other.idtipocupacion != null) || (this.idtipocupacion != null && !this.idtipocupacion.equals(other.idtipocupacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.TipOcupacion[ idtipocupacion=" + idtipocupacion + " ]";
    }
    
}
